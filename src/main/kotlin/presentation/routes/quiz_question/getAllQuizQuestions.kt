package com.example.presentation.routes.quiz_question

import com.example.domain.QuizQuestionRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllQuizQuestions(
    repository: QuizQuestionRepository
) {
    get(path = "/quiz/questions") {
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull()
        val limit = call.queryParameters["limit"]?.toIntOrNull()

        val filteredQuestions = repository.getAllQuizQuestions(topicCode, limit)

        if (filteredQuestions.isNotEmpty()) {
            call.respond(status = HttpStatusCode.OK, message = filteredQuestions)
        } else {
            call.respond(status = HttpStatusCode.NotFound, message = "Questions not found.")
        }
    }
}