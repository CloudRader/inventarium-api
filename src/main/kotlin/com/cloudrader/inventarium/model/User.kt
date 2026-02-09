package com.cloudrader.inventarium.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
 class User(
    @Id var id: String = "",
    @Column(nullable = false, unique = true)
    var username: String = "",
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var secondName: String = "",
    @Column(nullable = false, unique = true)
    var email: String = "",
) {
    val fullName: String
        get() = "$firstName $secondName"
}
