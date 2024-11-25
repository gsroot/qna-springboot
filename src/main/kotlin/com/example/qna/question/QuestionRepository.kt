package com.example.qna.question

import org.springframework.data.jpa.repository.JpaRepository


interface QuestionRepository : JpaRepository<Question, Int>
