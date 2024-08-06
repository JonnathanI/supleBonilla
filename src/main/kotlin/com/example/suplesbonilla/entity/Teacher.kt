package com.example.suplesbonilla.entity

import jakarta.persistence.*

@Entity
@Table(name = "teacher")
class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var nui: String? = null
    @Column(name = "teacher_name")
    var teacherName: String? = null
    var age: String? = null
    var email: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    var student: Student? = null
}