package com.example.suplesbonilla.repository

import com.example.suplesbonilla.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
    fun  findById(id: Long?): Student
}