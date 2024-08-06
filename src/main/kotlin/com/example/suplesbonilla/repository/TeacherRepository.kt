package com.example.suplesbonilla.repository

import com.example.suplesbonilla.entity.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository: JpaRepository<Teacher, Long> {
    fun findById(id: Long?): Teacher
}