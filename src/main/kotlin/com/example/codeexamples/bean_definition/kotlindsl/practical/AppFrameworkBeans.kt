package com.example.codeexamples.bean_definition.kotlindsl.practical

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.UUID

fun initCustomAppBeans(requiresAuthentication: Boolean, appType: AppType) = beans {
    if (requiresAuthentication) {
        registerAuthentication()
        registerAuthInterceptor()
    }
    when(appType) {
        AppType.CUSTOMER -> {
            bean("customerId") {
                UUID.randomUUID().toString()
            }
            bean<CustomerContext>()
        }
        AppType.OFFICE -> {
            bean("officeId") {
                UUID.randomUUID().toString()
            }
            bean<OfficeContext>()
        }
        AppType.BOTH -> {
            bean("customerId") {
                UUID.randomUUID().toString()
            }
            bean("officeId") {
                UUID.randomUUID().toString()
            }
            bean<CustomerContext>()
            bean<OfficeContext>()
        }
    }
}

fun BeanDefinitionDsl.registerAuthentication() = bean {
    val host = env.getProperty("authentication.host")!!
    val user = env.getProperty("authentication.user")!!
    val password = env.getProperty("authentication.password")!!
    AuthenticationService(host, user, password)
}

private fun BeanDefinitionDsl.registerAuthInterceptor() {
    bean<IsAuthenticatedInterceptor>()
    bean<AuthenticatedInterceptorAppConfig>()
}

class AuthenticatedInterceptorAppConfig(
    private val isAuthenticatedInterceptor: IsAuthenticatedInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(isAuthenticatedInterceptor)
    }
}

class IsAuthenticatedInterceptor(
    private val authenticationService: AuthenticationService
) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        authenticationService.getSession()?.let {
            return true
        }
        response.status = 401
        return false
    }
}

class AuthenticationService(
    private val host: String,
    private val user: String,
    private val password: String
) {
    fun getSession(): SessionData? {
        return dummyRestCallSession(host, user, password)
    }
}

fun dummyRestCallSession(host: String, user: String, password: String) =
    if (host == "host" && user == "user" && password == "password") {
        SessionData("user1234", "Navn Navnesen")
    } else null

data class SessionData(
    val userId: String,
    val name: String,
)

data class CustomerContext(
   val customerId: String
)

data class OfficeContext(
   val officeId: String
)

enum class AppType{
    CUSTOMER,
    OFFICE,
    BOTH
}