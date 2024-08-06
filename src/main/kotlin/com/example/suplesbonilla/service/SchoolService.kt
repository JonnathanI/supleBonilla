package com.example.suplesbonilla.service

import com.example.suplesbonilla.entity.School
import com.example.suplesbonilla.repository.SchoolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SchoolService {
    @Autowired
    lateinit var schoolRepository: SchoolRepository

    fun list(): List<School>{
        return schoolRepository.findAll()
    }

    fun listById(id:Long):School{
        return schoolRepository.findById(id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"El Colegio con el id $id no es correcto")}
    }

    fun save(school: School): School{
        return schoolRepository.save(school)
    }

    fun update(school: School): School{
        try {
            schoolRepository.findById(school.id)?: throw Exception("Cliente no Encontrado")
            return schoolRepository.save(school)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateAddress(school: School): School? {
        try {
            var response = schoolRepository.findById(school.id)
            response.apply {
                address= school.address
            }
            return schoolRepository.save (response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        if (!schoolRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "School with id $id not found")
        }
        schoolRepository.deleteById(id)
    }
}