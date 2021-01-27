package managementsystem.edenclinic.demo.controllers;

import managementsystem.edenclinic.demo.models.Role;
import managementsystem.edenclinic.demo.models.User;
import managementsystem.edenclinic.demo.payload.SignUpRequest;
import managementsystem.edenclinic.demo.services.RoleService;
import managementsystem.edenclinic.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/auth/login")
    public String showLogin(){
        return "/auth/login";
    }

    @GetMapping("/auth/register")
    public String showRegister(Model model)
    {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String registerUser(@ModelAttribute("signUpRequest") SignUpRequest signUpRequest, BindingResult bindingResult){
        if (userService.existsByEmail(signUpRequest.getEmail())){
            bindingResult.addError(new FieldError("signUpRequest", "email", "Email address already in use."));
        }

        if (bindingResult.hasErrors()){
            return "/auth/register";
        }

        //create a role
        Role role = roleService.getRoleByName("user");

        //create user's account
        User user = new User(signUpRequest.getEmail(), signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getPassword());
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/auth/register?success";
    }

    @GetMapping("/auth/forgot_password")
    public String showForgotPassword(){
        return "/auth/forgot_password";
    }
}
