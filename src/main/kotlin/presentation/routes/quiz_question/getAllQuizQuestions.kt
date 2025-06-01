package com.example.presentation.routes.quiz_question

import com.example.presentation.config.quizQuestions
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllQuizQuestions() {
    get(path = "/quiz/questions") {
        call.respond(quizQuestions)
    }
}