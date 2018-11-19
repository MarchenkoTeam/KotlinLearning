package com.marchenkoteam.kotlinlearning.models

import javax.persistence.*

@Entity
data class Test(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
                @ManyToOne @JoinColumn(name = "theme_id") var theme: Theme,
                @Column(name = "time_limit") var timeLimit: Long,
                var name: String = "",
                var content: String = "",
                var rank: Int = 1,
                @ManyToMany
                @JoinTable(
                        name = "user_test_completion",
                        joinColumns = [JoinColumn(name = "test_id")],
                        inverseJoinColumns = [(JoinColumn(name = "user_id"))]
                )
                var whoCompleted: List<User>? = null)