package com.example.data.database

import com.example.data.util.Constant.MONGO_DATABASE_NAME
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object DatabaseFactory {
    private val CONNECTION_STRING = System.getenv("MONGO_URI") ?: throw IllegalArgumentException("MONGO_URI is not set.")

    fun create() : MongoDatabase {
        val mongoClient = MongoClient.create(CONNECTION_STRING)
        return mongoClient.getDatabase(MONGO_DATABASE_NAME)
    }
}