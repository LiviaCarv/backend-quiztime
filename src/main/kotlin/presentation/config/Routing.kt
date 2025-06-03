package com.example.presentation.config

import com.example.data.QuizQuestionRepositoryImpl
import com.example.domain.QuizQuestionRepository
import com.example.domain.model.QuizQuestion
import com.example.presentation.routes.quiz_question.deleteQuizQuestionById
import com.example.presentation.routes.quiz_question.getAllQuizQuestions
import com.example.presentation.routes.quiz_question.getQuizQuestionById
import com.example.presentation.routes.quiz_question.upsertQuizQuestion
import com.example.presentation.routes.root
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val repository: QuizQuestionRepository = QuizQuestionRepositoryImpl()

    routing {
        root()

        getAllQuizQuestions(repository)
        upsertQuizQuestion(repository)
        deleteQuizQuestionById(repository)
        getQuizQuestionById(repository)
    }

}

