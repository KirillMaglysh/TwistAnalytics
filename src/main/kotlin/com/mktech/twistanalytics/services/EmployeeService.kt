package com.mktech.twistanalytics.services

import com.mktech.twistanalytics.db.entities.Employee
import com.mktech.twistanalytics.requests.EmployeesRequest

interface EmployeeService {
    fun getEmployeesWoPsw(request: EmployeesRequest): List<Employee.EmployeeWoPsw>
}