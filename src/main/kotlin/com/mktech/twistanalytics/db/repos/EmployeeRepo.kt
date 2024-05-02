package com.mktech.twistanalytics.db.repos

import com.mktech.twistanalytics.db.entities.Employee
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepo : JpaRepository<Employee, Long> {
    fun findAllBy(pageable: Pageable): Page<Employee.EmployeeWoPsw>

    fun findAllByOrderByIdAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByIdDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByNameAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByNameDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderBySurnameAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderBySurnameDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByEmailAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByEmailDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByPhoneAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByPhoneDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByRoleAsc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
    fun findAllByOrderByRoleDesc(pageable: Pageable): Page<Employee.EmployeeWoPsw>
}