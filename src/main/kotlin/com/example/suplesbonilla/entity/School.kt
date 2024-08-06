package com.example.suplesbonilla.entity

import jakarta.persistence.*

@Entity
@Table(name = "school")
class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var address: String? = null
    var phone: String? = null
}