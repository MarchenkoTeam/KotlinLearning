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
                var description: String = "",
                @Column(nullable = false)
                var rank: Int = 1,
                @Column(nullable = false)
                var inputFilePath: String = "",
                @Column(nullable = false)
                val outputFilePath: String = "",
                @ManyToMany(mappedBy = "completedTests")
                var whoCompleted: Set<User> = HashSet())