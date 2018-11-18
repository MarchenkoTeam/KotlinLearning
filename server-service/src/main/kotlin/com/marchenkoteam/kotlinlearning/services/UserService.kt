package com.marchenkoteam.kotlinlearning.services

import com.marchenkoteam.kotlinlearning.dto.LoginDto
import com.marchenkoteam.kotlinlearning.dto.RegistrationDto
import com.marchenkoteam.kotlinlearning.dto.TokenDto
import com.marchenkoteam.kotlinlearning.exceptions.InvalidLoginOrPasswordException
import com.marchenkoteam.kotlinlearning.exceptions.PasswordsNotMatchedException
import com.marchenkoteam.kotlinlearning.models.User
import com.marchenkoteam.kotlinlearning.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var tokenService: TokenService

    @Autowired
    private lateinit var userRepository: UserRepository

    fun save(registrationDto: RegistrationDto): TokenDto {
        if (registrationDto.password != registrationDto.passwordConfirm) throw PasswordsNotMatchedException()
        val user = User(registrationDto.firstName,
                registrationDto.lastName,
                registrationDto.email,
                passwordEncoder.encode(registrationDto.password))
        return save(user)
    }

    private fun save(user: User): TokenDto {
        userRepository.save(user)
        return tokenService.getToken(user)
    }

    fun login(loginDto: LoginDto): TokenDto {
        val user = userRepository.findByEmail(loginDto.email)
                .orElseThrow { InvalidLoginOrPasswordException() }

        if (!passwordEncoder.matches(loginDto.password, user.password)) throw InvalidLoginOrPasswordException()

        return tokenService.getToken(user)
    }
}