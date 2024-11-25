package com.example.qna.question

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/questions")
class QuestionController(private val questionService: QuestionService) {
    @GetMapping("/")
    fun list(): List<Question> {
        val questionList: List<Question> = this.questionService.getList()
        return questionList
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): Question {
        val question: Question = questionService.get(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found")
        return question
    }

    @PostMapping("/create")
    fun create(@RequestBody @Valid questionForm: QuestionForm): Question {
        val question = this.questionService.create(questionForm.subject, questionForm.content)
        return question
    }

    @PutMapping("/{id}")
    fun update(
        @RequestBody @Valid questionForm: QuestionForm, @PathVariable("id") id: Int
    ): Question {
        val question: Question = questionService.get(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found")
        val updatedQuestion = questionService.update(question, questionForm.subject, questionForm.content)
        return updatedQuestion
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        questionService.delete(id)
    }
}
