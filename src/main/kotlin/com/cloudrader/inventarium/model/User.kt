package com.cloudrader.inventarium.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column


@Table(name = "users")
 class User(
    @Id var id: String = "",
    @Column("username")
    var username: String = "",
    @Column("first_name")
    var firstName: String = "",
    @Column("second_name")
    var secondName: String = "",
    @Column("email")
    var email: String = "",
) {
    val fullName: String
        get() = "$firstName $secondName"
}
