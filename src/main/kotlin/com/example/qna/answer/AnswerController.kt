package com.example.qna.answer

import com.example.qna.question.QuestionService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/answers")
class AnswerController(private val answerService: AnswerService, private val questionService: QuestionService) {
    @GetMapping("/")
    fun getList(): List<Answer> {
        val answerList: List<Answer> = this.answerService.getList()
        return answerList
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): Answer {
        val answer: Answer = answerService.get(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Answer not found"
        )
        return answer
    }

    @PostMapping("/create")
    fun create(@RequestBody @Valid answerForm: AnswerForm): Answer {
        val question = this.questionService.get(answerForm.questionId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found")
        val answer = this.answerService.create(question, answerForm.content)
        return answer
    }

    @PutMapping("/{id}")
    fun update(
        @RequestBody @Valid answerForm: AnswerForm, @PathVariable("id") id: Int
    ): Answer {
        val answer: Answer = answerService.get(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Answer not found"
        )
        val updatedQuestion = answerService.update(answer, answerForm.content)
        return updatedQuestion
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        answerService.delete(id)
    }
}
