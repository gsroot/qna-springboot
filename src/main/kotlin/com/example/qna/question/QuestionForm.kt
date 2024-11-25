package com.example.qna.question

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


data class QuestionForm(
    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max = 200)
    val subject: String,

    @NotEmpty(message = "내용은 필수항목입니다.")
    val content: String
)