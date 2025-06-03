package com.example.data

import com.example.domain.QuizQuestionRepository
import com.example.domain.model.QuizQuestion

class QuizQuestionRepositoryImpl : QuizQuestionRepository {
    private val quizQuestions = mutableListOf<QuizQuestion>()

    override fun getAllQuizQuestions(topicCode: Int?, limit: Int?): List<QuizQuestion> {
        return if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions.take(limit ?: quizQuestions.size)
        }
    }

    override fun upsertQuizQuestion(question: QuizQuestion) {
        quizQuestions.add(question)
    }

    override fun getQuizQuestionById(id: String): QuizQuestion? {
        return quizQuestions.find { it.id == id }
    }

    override fun deleteQuizQuestionById(id: String): Boolean {
        return quizQuestions.removeIf { it.id == id }
    }

}