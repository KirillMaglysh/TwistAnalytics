package com.mktech.twistanalytics.services

import com.mktech.twistanalytics.db.entities.Employee

interface EmployeeService {
    fun getEmployeesWoPsw(limit: Int, offset: Int): List<Employee.EmployeeWoPsw>
}