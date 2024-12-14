package com.transportms.transportms.controller;

import com.transportms.transportms.model.User;
import com.transportms.transportms.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // Serve login page for both admin and customer
    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equalsIgnoreCase(user.getRole())) {
                return "redirect:/dashboard"; // Redirect to admin dashboard if already logged in
            } 
        }
        return "login"; // Return common login view
    }

    // Handle login for both admin and customer
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        if (email == null || password == null) {
            model.addAttribute("error", "Email and password must be provided");
            return "login"; // Redirect back to login with error
        }

        Optional<User> userOptional = userService.login(email, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            session.setAttribute("user", user); // Store user in session

            if ("admin".equalsIgnoreCase(user.getRole())) {
                return "redirect:/dashboard"; // Redirect to admin dashboard
            } else {
                model.addAttribute("error", "Unauthorized access");
                return "login"; // Redirect back to login with error
            }
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Redirect back to login with error
        }
    }

    // Handle logout for both admin and customer
    @GetMapping("/logout")
    public String logoutCustomer(HttpSession session) {
        session.invalidate(); // Invalidate session
        return "redirect:/login"; // Redirect to customer login page
    }
    
}
