package com.marchenkoteam.kotlinlearning.models

import com.marchenkoteam.kotlinlearning.security.role.Role
import javax.persistence.*

@Entity
@Table(name = "app_user")
class User constructor(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
                       var firstName: String,
                       var lastName: String,
                       @Column(unique = true, nullable = false) var email: String,
                       @Column(nullable = false) var password: String,
                       @Column(nullable = false) var role: Role) {

    constructor(id: Long, email: String, role: Role) : this(0, "", "", email, "", role)

    constructor() : this(0, "", "", "", "", Role.USER)
}
