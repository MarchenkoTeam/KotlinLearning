package com.marchenkoteam.kotlinlearning.services

import com.marchenkoteam.kotlinlearning.exceptions.BadRequestException
import com.marchenkoteam.kotlinlearning.models.Test
import com.marchenkoteam.kotlinlearning.repositories.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService @Autowired constructor(private val testRepository: TestRepository) {

    fun findById(id: Long): Test = testRepository.findById(id)
            .orElseThrow { BadRequestException("No such test.") }
}