package com.example.qna.question

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class QuestionService(private val questionRepository: QuestionRepository) {
    fun getList(): List<Question> {
        return this.questionRepository.findAll()
    }

    fun get(id: Int): Question? {
        val question: Question? = this.questionRepository.findByIdOrNull(id)
        return question
    }

    fun create(subject: String, content: String): Question {
        val question = Question()
        question.subject = subject
        question.content = content

        return this.questionRepository.save(question)
    }

    fun update(question: Question, subject: String, content: String): Question {
        question.subject = subject
        question.content = content

        return this.questionRepository.save(question)
    }

    fun delete(id: Int) {
        this.questionRepository.deleteById(id)
    }
}