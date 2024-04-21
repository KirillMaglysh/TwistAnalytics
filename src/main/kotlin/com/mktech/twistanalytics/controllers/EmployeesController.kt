package com.mktech.twistanalytics.controllers

import com.mktech.twistanalytics.requests.EmployeesRequest
import com.mktech.twistanalytics.services.EmployeeService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeesController(
    @Autowired private val employeeService: EmployeeService
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping
    fun getEmployees(@RequestBody(required = false) employeesRequest: EmployeesRequest = EmployeesRequest()): String {
        logger.info { "Received employees request: $employeesRequest" }
        val employees = employeeService.getEmployeesWoPsw(employeesRequest.limit, employeesRequest.offset)
        return "employees"
    }
}
