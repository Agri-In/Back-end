package com.audit.agriin.Core;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Nouhi",
                        email = "sidatnouhi@gmail.com",
                        url = "https://nouhi.ma"
                ),
                description = "OpenApi documentation for Agri In API",
                title = "OpenApi specification - Nouhi",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "PROD ENV",
                        url = "http://54.162.210.15:8085"
                ),
                @Server(
                        description = "Test ENV",
                        url = "http://localhost:8090"
                ),
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8090"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfiguration {

}
