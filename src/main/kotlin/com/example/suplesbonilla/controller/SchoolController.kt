package com.example.suplesbonilla.controller

import com.example.suplesbonilla.entity.School
import com.example.suplesbonilla.service.SchoolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/school")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class SchoolController {

    @Autowired
    lateinit var schoolService: SchoolService

    @GetMapping
    fun list(): List<School> {
        return schoolService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): School {
        return schoolService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody school: School): School {
        return schoolService.save(school)
    }

    @PutMapping
    fun update(@RequestBody school: School):ResponseEntity <School> {
        return ResponseEntity(schoolService.update(school), HttpStatus.OK)
    }

    @PatchMapping
    fun updateAddress(@RequestBody school: School):ResponseEntity<School> {
        return ResponseEntity(schoolService.updateAddress(school), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        schoolService.delete(id)

    }
}