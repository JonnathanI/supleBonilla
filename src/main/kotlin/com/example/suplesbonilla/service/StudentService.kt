package com.example.suplesbonilla.service

import com.example.suplesbonilla.entity.Student
import com.example.suplesbonilla.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository

    fun list(): List<Student>{
        return studentRepository.findAll()
    }
    fun listById(id:Long):Student{
        return studentRepository.findById(id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"El Estudiante con el id $id no es correcto")}
    }

    fun save(student: Student): Student{
        return studentRepository.save(student)
    }

    fun update(student: Student): Student{
        try {
            studentRepository.findById(student.id)?: throw Exception("Cliente no Encontrado")
            return studentRepository.save(student)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(student: Student): Student? {
        try {
            var response = studentRepository.findById(student.id)
            response.apply {
                studentName= student.studentName
            }
            return studentRepository.save (response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        if (!studentRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id $id not found")
        }
        studentRepository.deleteById(id)
    }
}