package com.marchenkoteam.kotlinlearning.controllers

import com.marchenkoteam.kotlinlearning.dto.LoginDto
import com.marchenkoteam.kotlinlearning.dto.TokenDto
import com.marchenkoteam.kotlinlearning.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun login(@RequestBody loginDto: LoginDto): TokenDto {
        return userService.login(loginDto)
    }
}