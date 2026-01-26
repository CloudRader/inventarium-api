package com.cloudrader.inventarium.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "notes")
data class Note (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    val title: String,
    val content: String,
    val color: Long,
    val createdAt: Instant,
)