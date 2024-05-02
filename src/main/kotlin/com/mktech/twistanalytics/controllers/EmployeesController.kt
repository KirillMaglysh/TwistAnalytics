package com.mktech.twistanalytics.controllers

import com.mktech.twistanalytics.requests.EmployeesRequest
import com.mktech.twistanalytics.services.EmployeeService
import com.mktech.twistanalytics.utils.EmployeeTableHeader
import jakarta.validation.Valid
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeesController(
    @Autowired private val employeeService: EmployeeService,
    @Autowired private val employeeTableHeaders: List<EmployeeTableHeader>
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping
    fun getEmployees(
        @Valid employeesRequest: EmployeesRequest = EmployeesRequest(),
        model: Model
    ): String {
        employeesRequest.validate(employeeTableHeaders)
        logger.info { "###Received employees request: $employeesRequest" }

        val employees = employeeService.getEmployeesWoPsw(employeesRequest)

        model.addAttribute("url_suf", "employees")
        model.addAttribute("employees", employees)
        model.addAttribute("tableProperties", employeeTableHeaders)
        model.addAttribute("properties", employeesRequest)
        return "employees"
    }
}
