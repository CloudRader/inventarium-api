package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.model.Note
import com.cloudrader.inventarium.adapter.repository.NoteRepository
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/v1/notes")
class NoteController(
    private val repository: NoteRepository
) {

    data class NoteRequest(
        @field:NotBlank(message = "Title can't be blank.")
        val title: String,
        val content: String,
        val color: Long,
    )

    data class NoteResponse(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant,
    )

    @PostMapping
    fun create(
        @Valid @RequestBody body: NoteRequest
    ): NoteResponse {
        val note = repository.save(
            Note(
                title = body.title,
                content = body.content,
                color = body.color,
                createdAt = Instant.now(),
            )
        )

        return note.toResponse()
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable id: String) {
        repository.findById(id).orElseThrow {
            IllegalArgumentException("Note not found")
        }

        repository.deleteById(id)
    }

    private fun Note.toResponse() : NoteController.NoteResponse {
        return NoteResponse(
            id = id,
            title = title,
            content = content,
            color = color,
            createdAt = createdAt,
        )
    }
}