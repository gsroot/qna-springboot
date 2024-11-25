package com.example.qna.question

import com.example.qna.answer.Answer
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @Column(length = 200)
    var subject: String = ""

    @Column(columnDefinition = "TEXT")
    var content: String = ""

    var createDate: LocalDateTime = LocalDateTime.now()

    @OneToMany(mappedBy = "question", cascade = [CascadeType.REMOVE])
    var answerList: List<Answer> = emptyList()
}
