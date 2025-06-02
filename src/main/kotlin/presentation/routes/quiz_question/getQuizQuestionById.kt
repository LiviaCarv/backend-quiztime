package com.example.presentation.routes.quiz_question

import com.example.presentation.config.quizQuestions
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getQuizQuestionById() {
    get(path = "/quiz/questions/{questionId}") {
        val id = call.parameters["questionId"]

        if (id.isNullOrBlank()) {
            call.respond(status = HttpStatusCode.BadRequest, message = "Question Id needed.")
            return@get
        }

        val question = quizQuestions.filter { it.id == id }
        if (question.isEmpty()) {
            call.respond(status = HttpStatusCode.NotFound, message = "Question not found.")
        } else {
            call.respond(status = HttpStatusCode.OK, message = question)
        }
    }
}