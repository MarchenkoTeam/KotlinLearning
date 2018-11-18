package com.marchenkoteam.kotlinlearning.security.providers

import com.marchenkoteam.kotlinlearning.security.auth.JwtAuthToken
import com.marchenkoteam.kotlinlearning.security.details.UserDetailsImpl
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtAuthTokenProvider : AuthenticationProvider {

    @Value("\${app.jwtSecret}")
    private lateinit var jwtSecret: String


    override fun authenticate(authentication: Authentication): Authentication {
        val authToken = authentication as JwtAuthToken
        val body: Claims

        try {
            body = Jwts
                    .parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken.name)
                    .body
        } catch (e: JwtException) {
            e.printStackTrace()
            throw AuthenticationServiceException("Invalid token.")
        }

        val userDetails = UserDetailsImpl(body["sub"].toString().toLong(),
                body["email"].toString(),
                body["role"].toString())

        authToken.details = userDetails
        authToken.isAuthenticated = true
        return authToken
    }

    override fun supports(auth: Class<*>): Boolean {
        return JwtAuthToken::class == auth
    }
}