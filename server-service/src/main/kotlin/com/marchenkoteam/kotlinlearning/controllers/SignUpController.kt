package com.marchenkoteam.kotlinlearning.controllers

import com.marchenkoteam.kotlinlearning.dto.RegistrationDto
import com.marchenkoteam.kotlinlearning.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign_up")
class SignUpController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun signUp(@RequestBody registrationDto: RegistrationDto) = userService.save(registrationDto)
}