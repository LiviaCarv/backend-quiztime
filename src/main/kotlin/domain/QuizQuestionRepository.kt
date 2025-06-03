package com.example.domain

import com.example.domain.model.QuizQuestion

interface QuizQuestionRepository {

    fun getAllQuizQuestions(topicCode: Int?, limit: Int?): List<QuizQuestion>

    fun upsertQuizQuestion(question: QuizQuestion)

    fun getQuizQuestionById(id: String) : QuizQuestion?

    fun deleteQuizQuestionById(id: String) : Boolean
}