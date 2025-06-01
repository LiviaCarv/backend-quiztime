package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class IssueReport(
    val id: String? = null,
    val questionId: String,
    val issueType: String,
    val additionalComments: String?,
    val userEmail: String?,
    val timeStamp: String
)