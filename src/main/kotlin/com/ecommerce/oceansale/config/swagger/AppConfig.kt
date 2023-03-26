package com.ecommerce.oceansale.config.swagger

import jakarta.annotation.PostConstruct
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import java.util.*

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class AppConfig(
    private val env: Environment,
    private val buildProperties: BuildProperties,
) {

    @Bean
    fun appInfo(): AppInfo {

        return AppInfo.apply {
            name = buildProperties.name
            version = buildProperties.version
            description = env.getProperty("swagger.description") ?: ""
            contactName = env.getProperty("swagger.contact.name") ?: ""
            contactUrl = env.getProperty("swagger.contact.url") ?: ""
            contactEmail = env.getProperty("swagger.contact.email") ?: ""
            serverUrl = env.getProperty("swagger.url") ?: "http://localhost:8899/oceansale"
            originRoot = env.getProperty("swagger.origin.root") ?: "cloud"
        }
    }

//    @Bean
//    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
//        return BCryptPasswordEncoder(10)
//    }

    @PostConstruct
    private fun init() {
        Locale.setDefault(Locale("pt", "BR"))
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
    }
}