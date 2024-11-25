package com.example.qna.answer

import com.example.qna.question.Question
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class AnswerService(private val answerRepository: AnswerRepository) {
    fun getList(): List<Answer> {
        return this.answerRepository.findAll()
    }

    fun get(id: Int): Answer? {
        val answer: Answer? = this.answerRepository.findByIdOrNull(id)
        return answer
    }

    fun create(question: Question, content: String): Answer {
        val answer = Answer()
        answer.content = content
        answer.question = question

        return this.answerRepository.save(answer)
    }

    fun update(answer: Answer, content: String): Answer {
        answer.content = content

        return this.answerRepository.save(answer)
    }

    fun delete(id: Int) {
        this.answerRepository.deleteById(id)
    }
}