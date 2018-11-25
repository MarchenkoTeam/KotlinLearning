package com.marchenkoteam.kotlinlearning.controllers

import com.marchenkoteam.kotlinlearning.dto.ThemeDto
import com.marchenkoteam.kotlinlearning.models.Theme
import com.marchenkoteam.kotlinlearning.services.ThemeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/themes")
class ThemeController @Autowired constructor(private val themeService: ThemeService) {

    @GetMapping
    fun getThemes(): List<ThemeDto> = themeService.findAll()

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    fun saveTheme(@RequestHeader authToken: String,
                  @RequestBody theme: Theme) {
        themeService.save(theme)
    }

    @GetMapping("/{id}")
    fun getTheme(@PathVariable("id") id: Long): ThemeDto = themeService.findById(id)

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    fun updateTheme(@RequestHeader authToken: String,
                    @RequestBody theme: Theme) {
        themeService.save(theme)
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    fun deleteTheme(@RequestHeader authToken: String,
                    @PathVariable("id") id: Long) {
        themeService.deleteById(id)
    }
}