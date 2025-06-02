package com.example.presentation.routes.quiz_question

import com.example.domain.model.QuizQuestion
import com.example.presentation.config.quizQuestions
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.upsertQuizQuestion() {
    post(path = "/quiz/questions") {
        val question = call.receive<QuizQuestion>()
        quizQuestions.add(question)
       call.respond(status = HttpStatusCode.Created ,message = "Question added successfully.")
    }
}