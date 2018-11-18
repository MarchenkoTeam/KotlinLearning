package com.marchenkoteam.kotlinlearning.security.details

import com.marchenkoteam.kotlinlearning.models.User
import com.marchenkoteam.kotlinlearning.security.role.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class UserDetailsImpl constructor(val user: User) : UserDetails {

    private val grantedAuthority: GrantedAuthority

    init {
        grantedAuthority = SimpleGrantedAuthority(user.role.toString())
    }

    constructor(id: Long,
                email: String,
                role: String) : this(User(id, email, Role.valueOf(role)))

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Collections.singletonList(grantedAuthority)
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return user.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}