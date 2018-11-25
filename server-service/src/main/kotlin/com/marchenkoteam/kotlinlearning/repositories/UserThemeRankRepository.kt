package com.marchenkoteam.kotlinlearning.repositories

import com.marchenkoteam.kotlinlearning.models.UserThemeRank
import org.springframework.data.jpa.repository.JpaRepository

interface UserThemeRankRepository : JpaRepository<UserThemeRank, Long>