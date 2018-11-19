package com.marchenkoteam.kotlinlearning.models

import javax.persistence.*

@Entity
data class Theme(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
                 @Column(nullable = false) var name: String = "")