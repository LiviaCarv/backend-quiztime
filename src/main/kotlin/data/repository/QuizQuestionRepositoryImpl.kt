package com.example.data.repository

import com.example.data.database.entity.QuizQuestionEntity
import com.example.data.mapper.toQuizQuestionEntity
import com.example.data.util.Constant.QUIZ_QUESTIONS_COLLECTION_NAME
import com.example.domain.model.QuizQuestion
import com.example.domain.repository.QuizQuestionRepository
import com.mongodb.kotlin.client.coroutine.MongoDatabase

class QuizQuestionRepositoryImpl(
    mongoDatabase: MongoDatabase
) : QuizQuestionRepository {

    private val questionCollection = mongoDatabase.getCollection<QuizQuestionEntity>(QUIZ_QUESTIONS_COLLECTION_NAME)

    private val quizQuestions = mutableListOf<QuizQuestion>()

    override suspend fun getAllQuizQuestions(topicCode: Int?, limit: Int?): List<QuizQuestion> {
        return if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions.take(limit ?: quizQuestions.size)
        }
    }

    override suspend fun upsertQuizQuestion(question: QuizQuestion) {
        questionCollection.insertOne(question.toQuizQuestionEntity())
    }

    override suspend fun getQuizQuestionById(id: String): QuizQuestion? {
        return quizQuestions.find { it.id == id }
    }

    override suspend fun deleteQuizQuestionById(id: String): Boolean {
        return quizQuestions.removeIf { it.id == id }
    }

}