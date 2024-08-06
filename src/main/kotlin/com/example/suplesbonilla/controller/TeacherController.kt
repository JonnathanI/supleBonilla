package com.example.suplesbonilla.controller

import com.example.suplesbonilla.entity.School
import com.example.suplesbonilla.entity.Teacher
import com.example.suplesbonilla.service.SchoolService
import com.example.suplesbonilla.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teacher")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class TeacherController {

    @Autowired
    lateinit var teacherService: TeacherService

    @GetMapping
    fun list(): List<Teacher> {
        return teacherService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Teacher {
        return teacherService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody teacher: Teacher): Teacher {
        return teacherService.save(teacher)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody teacher: Teacher?):ResponseEntity <Teacher> {
        val updatedTeacher = teacherService.update(teacher!!)
        return ResponseEntity.ok(updatedTeacher)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: Long?, @RequestBody teacher: Teacher?):ResponseEntity<Teacher> {
        val updatedTeacher = teacherService.updateName(teacher!!)
        return ResponseEntity.ok(updatedTeacher)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        teacherService.delete(id)

    }
}