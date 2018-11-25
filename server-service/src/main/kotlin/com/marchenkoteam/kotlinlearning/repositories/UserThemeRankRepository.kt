package com.marchenkoteam.kotlinlearning.repositories

import com.marchenkoteam.kotlinlearning.models.UserThemeInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserThemeRankRepository : JpaRepository<UserThemeInfo, Long>