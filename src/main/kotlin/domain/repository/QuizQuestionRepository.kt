package com.example.domain.repository

import com.example.domain.model.QuizQuestion

interface QuizQuestionRepository {

    suspend fun getAllQuizQuestions(topicCode: Int?, limit: Int?): List<QuizQuestion>

    suspend fun upsertQuizQuestion(question: QuizQuestion)

    suspend fun getQuizQuestionById(id: String) : QuizQuestion?

    suspend fun deleteQuizQuestionById(id: String) : Boolean
}