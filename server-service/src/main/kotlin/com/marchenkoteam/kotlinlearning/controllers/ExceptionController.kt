package com.marchenkoteam.kotlinlearning.controllers

import com.marchenkoteam.kotlinlearning.exceptions.PasswordsNotMatchedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class ExceptionController {
    @ExceptionHandler(PasswordsNotMatchedException::class)
    fun handlePasswordsNotMatch(e: PasswordsNotMatchedException) = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}