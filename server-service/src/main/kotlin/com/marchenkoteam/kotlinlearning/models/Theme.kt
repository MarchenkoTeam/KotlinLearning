package com.marchenkoteam.kotlinlearning.models

import javax.persistence.*

@Entity
data class Theme(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long = 0,
                 @Column(nullable = false, unique = true)
                 var name: String = "")