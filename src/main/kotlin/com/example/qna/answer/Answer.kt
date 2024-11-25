package com.example.qna.answer
import com.example.qna.question.Question
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @Column(columnDefinition = "TEXT")
    var content: String = ""

    var createDate: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JsonIgnore
    var question: Question? = null
}
