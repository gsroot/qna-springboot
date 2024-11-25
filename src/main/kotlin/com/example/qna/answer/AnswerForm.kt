package com.example.qna.answer

import jakarta.validation.constraints.NotEmpty


data class AnswerForm(
    @NotEmpty(message = "내용은 필수항목입니다.")
    val content: String,
    @NotEmpty(message = "질문 ID는 필수항목입니다.")
    val questionId: Int
)