package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository: JpaRepository<Note, String>
