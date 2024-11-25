package com.example.qna.answer

import org.springframework.data.jpa.repository.JpaRepository


interface AnswerRepository : JpaRepository<Answer, Int>