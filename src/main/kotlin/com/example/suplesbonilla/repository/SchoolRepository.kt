package com.example.suplesbonilla.repository

import com.example.suplesbonilla.entity.School
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolRepository: JpaRepository<School, Long> {
    fun findById(id: Long?): School
}