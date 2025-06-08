package com.example.presentation.routes.quiz_question

import com.example.domain.repository.QuizQuestionRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deleteQuizQuestionById(repository: QuizQuestionRepository) {
    delete(path = "/quiz/questions/{questionId}") {
        val id = call.parameters["questionId"]


        if (id.isNullOrBlank()) {
            call.respond(status = HttpStatusCode.BadRequest, message = "Question Id needed.")
            return@delete
        }

        val isDeleted = repository.deleteQuizQuestionById(id)

        if (isDeleted) {
            call.respond(status = HttpStatusCode.OK, message = "Question removed successfully..")
        } else {
            call.respond(status = HttpStatusCode.NotFound, message = "Question not found.")
        }
        call.respond("Question removed successfully.")
    }
}