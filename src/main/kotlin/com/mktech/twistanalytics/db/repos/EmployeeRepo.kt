package com.mktech.twistanalytics.db.repos

import com.mktech.twistanalytics.db.entities.Employee
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepo : JpaRepository<Employee, Long> {
    fun findAllBy(pageable: Pageable): Page<Employee.EmployeeWoPsw>
}