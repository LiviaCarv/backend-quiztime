package com.example.presentation.routes.quiz_question

import com.example.presentation.config.quizQuestions
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllQuizQuestions() {
    get(path = "/quiz/questions") {
        // query parameters
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull()
        val limit = call.queryParameters["limit"]?.toIntOrNull()


        val filteredQuestions = if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode}
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions
        }
        if (filteredQuestions.isNotEmpty()) {
            call.respond(status = HttpStatusCode.OK, message = filteredQuestions)
        } else {
            call.respond(status = HttpStatusCode.NotFound, message = "Questions not found.")
        }
    }
}