package com.mktech.twistanalytics.services.impl

import com.mktech.twistanalytics.db.entities.Employee
import com.mktech.twistanalytics.db.repos.EmployeeRepo
import com.mktech.twistanalytics.requests.EmployeesRequest
import com.mktech.twistanalytics.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.lang.reflect.Method

@Service
class EmployeeServiceImpl(
    @Autowired private val employeeRepo: EmployeeRepo
) : EmployeeService {

    override fun getEmployeesWoPsw(request: EmployeesRequest): List<Employee.EmployeeWoPsw> {
        val method = getMethodFromRepo(request)

        val page =
            method(employeeRepo, PageRequest.of(request.offset, request.limit)) as Page<Employee.EmployeeWoPsw>
        return page.content
    }

    private fun getMethodFromRepo(request: EmployeesRequest): Method {
        val methodName = crateRepoMethodNameForRequest(request)
        return employeeRepo.javaClass.getMethod(methodName, Pageable::class.java)
    }

    private fun crateRepoMethodNameForRequest(request: EmployeesRequest): String {
        val sortParam = StringBuilder(request.sortParam)
        sortParam.setCharAt(0, request.sortParam[0].uppercaseChar())
        return "findAllByOrderBy$sortParam${if (request.isAsc) "Asc" else "Desc"}"
    }
}