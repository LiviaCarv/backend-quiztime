package com.example.presentation.config

import com.example.domain.model.QuizQuestion
import com.example.presentation.routes.quiz_question.getAllQuizQuestions
import com.example.presentation.routes.quiz_question.upsertQuizQuestion
import com.example.presentation.routes.root
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()

        getAllQuizQuestions()

        upsertQuizQuestion()
    }

}

val quizQuestions = mutableListOf<QuizQuestion>()