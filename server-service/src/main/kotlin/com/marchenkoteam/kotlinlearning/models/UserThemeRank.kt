package com.marchenkoteam.kotlinlearning.models

import javax.persistence.*

@Entity
@Table(name = "user_theme_rank")
data class UserThemeRank(@Id private var id: Long,
                         @ManyToOne @JoinColumn(name = "user_id") var user: User,
                         @ManyToOne @JoinColumn(name = "theme_id") var theme: Theme,
                         var rank: Int = 0)