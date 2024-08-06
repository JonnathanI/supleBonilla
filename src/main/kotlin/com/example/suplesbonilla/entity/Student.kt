package com.example.suplesbonilla.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "student_nombre")
    var studentName: String? = null
    var nui: String? = null
    var age: String? = null
    var email: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    var school: School? = null
}