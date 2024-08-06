package com.example.suplesbonilla.service

import com.example.suplesbonilla.entity.Teacher
import com.example.suplesbonilla.repository.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeacherService {
    @Autowired
    lateinit var teacherRepository: TeacherRepository

    fun list(): List<Teacher>{
        return teacherRepository.findAll()
    }
    fun listById(id:Long):Teacher{
        return teacherRepository.findById(id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"El Profesor con el id $id no es correcto")}
    }

    fun save(teacher: Teacher): Teacher{
        return teacherRepository.save(teacher)
    }

    fun update(teacher: Teacher): Teacher{
        try {
            teacherRepository.findById(teacher.id)?: throw Exception("Cliente no Encontrado")
            return teacherRepository.save(teacher)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(teacher: Teacher): Teacher? {
        try {
            var response = teacherRepository.findById(teacher.id)
            response.apply {
                teacherName= teacher.teacherName
            }
            return teacherRepository.save (response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        if (!teacherRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher with id $id not found")
        }
        teacherRepository.deleteById(id)
    }
}