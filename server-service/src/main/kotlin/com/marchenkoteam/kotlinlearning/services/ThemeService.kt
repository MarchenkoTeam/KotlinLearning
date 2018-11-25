package com.marchenkoteam.kotlinlearning.services

import com.marchenkoteam.kotlinlearning.exceptions.BadRequestException
import com.marchenkoteam.kotlinlearning.models.Theme
import com.marchenkoteam.kotlinlearning.repositories.ThemeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ThemeService @Autowired constructor(private val themeRepository: ThemeRepository) {

    fun findAll(): List<Theme> = themeRepository.findAll()

    fun findById(id: Long): Theme = themeRepository.findById(id)
            .orElseThrow { BadRequestException("No such theme.") }

    fun save(theme: Theme): Theme = themeRepository.save(theme)

    fun deleteById(id: Long): Unit = themeRepository.deleteById(id)
}
