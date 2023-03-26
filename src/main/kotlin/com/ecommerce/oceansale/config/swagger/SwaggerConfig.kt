package com.ecommerce.oceansale.config.swagger

import com.ecommerce.oceansale.utils.crypto.BEARER
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class SwaggerConfig {

    @Value("\${server.servlet.context-path}")
    val contextPath: String? = null

    @Value("\${server.url}")
    val url: String? = null

    fun setContact(): Contact {
        return Contact().apply {
            this.name = "Eduardo Zielke"
            this.url = "https://www.linkedin.com/in/eduardozielke/"
            this.email = "zielkeeduardo@gmail.com"
        }
    }

    @Bean
    fun springOpenAPI(): OpenAPI {

        val appContact = Contact().apply {
            this.name = AppInfo.contactName
            this.url = AppInfo.contactUrl
            this.email = AppInfo.contactEmail
        }

        val appLicense = License().apply {
            this.name = "MIT"
            this.url = "https://github.com/eduardozielke/ecommerce-backend/blob/main/LICENSE"
        }

        val server = Server().apply {
            url = AppInfo.serverUrl
        }

        return OpenAPI()
            .addServersItem(server)
            .components(
                Components().addSecuritySchemes(
                    "bearer-key",
                    SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme(BEARER)
                        .bearerFormat("JWT")
                )
            )
            .info(
                Info()
                    .title(AppInfo.name)
                    .description(AppInfo.description)
                    .version(AppInfo.version)
                    .contact(appContact)
                    .license(appLicense)
            ).addSecurityItem(
                SecurityRequirement()
                    .addList("bearer-key", emptyList())
            )
    }
}