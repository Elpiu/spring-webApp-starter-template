package com.elpiu.application.web;



import com.elpiu.application.AppConfGene;
import com.elpiu.application.persistence.entity.User;
import com.elpiu.application.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("appName", AppConfGene.NAMEAPP);
        model.addAttribute("appDes", AppConfGene.DESCRIPTIONAPP);

        model.addAttribute("title","Welcome");
        return "index";
    }


    @GetMapping("/login")
    public String doLogin(){
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/register")
    public String doRegister(Model model){
        model.addAttribute("title","Welcome");
        //if(model == null) model.addAttribute("registrationForm",new RegistrationForm());
        return "utenza/registration";
    }

    // Registration form with error
    @RequestMapping("/register-error")
    public String registerError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


    @GetMapping("/loginSuccess")
    public String loginSuccess(HttpServletRequest request, Authentication authentication){
        authentication.getName();
        if(!authentication.isAuthenticated()) return "redirect:/login";
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent((User) -> request.getSession().setAttribute("user",user.get()));
        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));
        return "pages/faq";
    }


    @GetMapping("/goLogout")
    public String goLogout(){
        //TODO se l'utente è null in sessione torna alla home
        return "logout";
    }


    @GetMapping("/user")
    public String user(){
        return "pages/faq";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
