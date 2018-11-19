package com.marchenkoteam.kotlinlearning.models

import com.marchenkoteam.kotlinlearning.security.role.Role
import javax.persistence.*

@Entity
@Table(name = "app_user")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
           var firstName: String,
           var lastName: String,
           @Column(unique = true, nullable = false) var email: String,
           @Column(nullable = false) var password: String,
           @Column(nullable = false) @Enumerated(EnumType.STRING) var role: Role,
           @ManyToMany(mappedBy = "whoCompleted")
           var completedTests: List<Test>? = null) {

    constructor(id: Long,
                email: String,
                role: Role) : this(id, "", "", email, "", role)

    constructor() : this(0, "", Role.USER)

    constructor(firstName: String,
                lastName: String,
                email: String,
                password: String) : this(0, firstName, lastName, email, password, Role.USER)
}
