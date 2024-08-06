package com.example.suplesbonilla.controller

import com.example.suplesbonilla.entity.School
import com.example.suplesbonilla.entity.Student
import com.example.suplesbonilla.service.SchoolService
import com.example.suplesbonilla.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun list(): List<Student> {
        return studentService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Student {
        return studentService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody student: Student): Student {
        return studentService.save(student)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody student: Student?):ResponseEntity <Student> {
        val updatedStudent = studentService.update(student!!)
        return ResponseEntity.ok(updatedStudent)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: Long?, @RequestBody student: Student?):ResponseEntity<Student> {
        val updatedStudent = studentService.updateName(student!!)
        return ResponseEntity.ok(updatedStudent)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        studentService.delete(id)

    }
}