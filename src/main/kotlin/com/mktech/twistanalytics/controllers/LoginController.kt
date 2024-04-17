package com.mktech.twistanalytics.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/login")
class LoginController {

    @GetMapping
    fun getLoginPage(): String {
        return "login"
    }
}