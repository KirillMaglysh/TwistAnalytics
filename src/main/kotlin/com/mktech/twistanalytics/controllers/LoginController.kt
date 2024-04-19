package com.mktech.twistanalytics.controllers

import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping
class LoginController {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/login")
    fun getLoginPage(): String {
        logger.info { "GET LOGIN PROCESSING" }
        return "login"
    }
}