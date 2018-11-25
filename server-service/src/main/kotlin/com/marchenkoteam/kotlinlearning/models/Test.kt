package com.marchenkoteam.kotlinlearning.models

import javax.persistence.*

@Entity
data class Test(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long = 0,
                @ManyToOne
                @JoinColumn(name = "theme_id")
                var theme: Theme,
                @Column(name = "time_limit")
                var timeLimit: Long = 0,
                var name: String = "",
                var content: String = "",
                var rank: Int = 1,
                @ManyToMany(mappedBy = "completedTests")
                var whoCompleted: Set<User> = HashSet())