package com.parking.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.parking.parking.model.User;
import com.parking.parking.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Muestra el formulario de registro de usuario
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";  // Redirige a la vista de registro
    }

    // Muestra la página de bienvenida
    @GetMapping("/welcome")
    public String showWelcomeForm(Model model) {
        return "welcome";  // Redirige a la vista welcome.html
    }

    // Procesa el formulario de registro
    @PostMapping("/register")
    public String registerUser(User user) {
        userRepository.save(user);  // Guarda el usuario en la base de datos
        return "redirect:/login";  // Redirige a la pantalla de login
    }
}
