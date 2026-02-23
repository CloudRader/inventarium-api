package com.cloudrader.inventarium.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column


@Table(name = "users")
 class User(
    @Id val id: String = "",
    @Column("username")
    val username: String = "",
    @Column("first_name")
    val firstName: String = "",
    @Column("second_name")
    val secondName: String = "",
    @Column("email")
    val email: String = "",
) {
    val fullName: String
        get() = "$firstName $secondName"
}
