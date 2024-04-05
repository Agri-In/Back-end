package com.audit.agriin.Services.Implemetation;

import com.audit.agriin.Domains.Entities.NonCorporate.Group;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import com.audit.agriin.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("UserDetailsService")
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    /**
     * @param username 
     * @return
     * @throws UsernameNotFoundException
     */
    @Autowired
    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        final User user = userRepository.findUserByEmail(email).get();
//        boolean enabled = !user.isAccountNonLocked(); // we can use this in case we want to activate account after user verified the account
//        UserDetails usr = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
//                .password(user.getPassword())
//                .disabled(user.isLoginDisabled())
//                .authorities(getAuthorities(user))
//                .build();
//
//        return user;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        boolean enabled = !user.isAccountNonLocked(); // we can use this in case we want to activate account after customer verified the account
        UserDetails userr = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .disabled(user.isLoginDisabled())
                .authorities(getAuthorities(user)).build()
                ;

        return userr;
    }

//    @Override
//    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
//        String username = JwtServiceImpl.extractUsername(token);
//        List<String> groups = JwtServiceImpl.extractGroups(token); // You need to implement this method in JwtService
//        List<GrantedAuthority> authorities = groups.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return new User(username, "", authorities);
//    }

    private Collection<GrantedAuthority> getAuthorities(User user){
        Set<Group> userGroups = user.getUserGroups();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for(Group userGroup : userGroups){
            authorities.add(new SimpleGrantedAuthority(userGroup.getName().toUpperCase()));
        }

        return authorities;
    }
}
