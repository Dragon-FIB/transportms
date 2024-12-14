package com.transportms.transportms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String showLandingPage() {
        return "landing"; // This assumes landing.html is in the src/main/resources/templates folder
    }
}
