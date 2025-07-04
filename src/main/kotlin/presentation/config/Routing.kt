package com.example.presentation.config

import com.example.data.database.DatabaseFactory
import com.example.data.repository.QuizQuestionRepositoryImpl
import com.example.domain.repository.QuizQuestionRepository
import com.example.presentation.routes.quiz_question.deleteQuizQuestionById
import com.example.presentation.routes.quiz_question.getAllQuizQuestions
import com.example.presentation.routes.quiz_question.getQuizQuestionById
import com.example.presentation.routes.quiz_question.upsertQuizQuestion
import com.example.presentation.routes.root
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val mongoDatabase = DatabaseFactory.create()
    val repository: QuizQuestionRepository = QuizQuestionRepositoryImpl(mongoDatabase)

    routing {
        root()

        getAllQuizQuestions(repository)
        upsertQuizQuestion(repository)
        deleteQuizQuestionById(repository)
        getQuizQuestionById(repository)
    }

}

