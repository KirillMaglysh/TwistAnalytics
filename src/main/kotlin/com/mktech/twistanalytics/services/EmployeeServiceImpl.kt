package com.mktech.twistanalytics.services

import com.mktech.twistanalytics.db.entities.Employee
import com.mktech.twistanalytics.db.repos.EmployeeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    @Autowired private val employeeRepo: EmployeeRepo
) : EmployeeService {

    override fun getEmployeesWoPsw(limit: Int, offset: Int): List<Employee.EmployeeWoPsw> {
        return employeeRepo.findAllBy(PageRequest.of(offset, limit)).content
    }
}