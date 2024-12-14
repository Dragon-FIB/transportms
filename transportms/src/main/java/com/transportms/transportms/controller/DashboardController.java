package com.transportms.transportms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



    @Controller
    public class DashboardController {
        @GetMapping("/dashboard")
        public String showDashboard(HttpSession session) {
            // Check if user is logged in
            if (session.getAttribute("user") == null) {
                return "redirect:/login"; // Redirect to login if not logged in
            }
            return "dashboard"; // Ensure dashboard.html exists in templates
        }

        @GetMapping("/")
        public String mainRoute( HttpSession session) {
          
            if (session.getAttribute("user") == null) {
                return "redirect:/login"; // Redirect to login if not logged in
            }
            return "dashboard"; // Ensure dashboard.html exists in templates
        }
    }
    

