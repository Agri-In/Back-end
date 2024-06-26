package com.audit.agriin.Security;

import com.audit.agriin.Exceptions.NoAuthenticateUser;
import com.audit.agriin.Repositories.TokenRepository;
import com.audit.agriin.Services.Specification.JwtService;
import com.audit.agriin.Services.Specification.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for handling user logout and token revocation.
 *
 * @author <a href="mailto:sidatnouhi@gmail.com">NOUHI Sidati</a>
 */
@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final UserService userService;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    /**
     * Handles user logout by revoking the JWT token.
     *
     * @param request        HttpServletRequest
     * @param response       HttpServletResponse
     * @param authentication Authentication object representing the current user's authentication details
     */
    @Transactional
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer "))
            throw new NoAuthenticateUser("Token not found");

        jwt = authHeader.substring(7);
        var storedToken = tokenRepository.findByToken(jwt)
                .orElseThrow(() -> new NoAuthenticateUser("Token not found"));

        if (!storedToken.isExpired() && !storedToken.isRevoked()) {
            userService.disconnect(storedToken.getUser());
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            SecurityContextHolder.clearContext();
        } else
            throw new NoAuthenticateUser("No user is authenticated");
    }
}