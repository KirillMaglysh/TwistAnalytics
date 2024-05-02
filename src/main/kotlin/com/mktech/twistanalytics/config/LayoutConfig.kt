package com.mktech.twistanalytics.config

import com.mktech.twistanalytics.utils.EmployeeTableHeader
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.TemplateEngine

@Configuration
class LayoutConfig {
    @Bean
    fun layoutDialect(): LayoutDialect {
        val layoutDialect = LayoutDialect()
        TemplateEngine().addDialect(layoutDialect)
        return layoutDialect
    }

    @Bean
    fun employeeTableHeaders(): List<EmployeeTableHeader> {
        return arrayListOf(
            EmployeeTableHeader("#", "id"),
            EmployeeTableHeader("Имя", "name"),
            EmployeeTableHeader("Фамилия", "surname"),
            EmployeeTableHeader("Email", "email"),
            EmployeeTableHeader("Телефон", "phone"),
            EmployeeTableHeader("Роль", "role"),
        )
    }
}