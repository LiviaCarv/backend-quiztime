package com.example.presentation.routes.quiz_question

import com.example.domain.model.QuizQuestion
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getAllQuizQuestions() {
    get(path = "/quiz/questions") {
        val question = QuizQuestion(
            question = "What is your name",
            correctAnswer = "Livia",
            incorrectAnswers = listOf("sa", "sf", "fd"),
            explanation = "thats your name",
            topicCode = 1
        )

       call.respond(question)
    }
}