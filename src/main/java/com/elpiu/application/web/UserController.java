package com.elpiu.application.web;


import com.elpiu.application.AppConfGene;
import com.elpiu.application.form.dto.RegistrationForm;
import com.elpiu.application.persistence.entity.User;
import com.elpiu.application.persistence.repository.UserRepository;
import com.elpiu.application.security.MyUserDetailsSerivce;
import com.elpiu.application.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@Controller
public class UserController {

    private static final String ROLE_USER = "ROLE_USER";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MyUserDetailsSerivce myUserDetailsSerivce;

    /**
     * Root dell'applicazione
     * Aggiunge informazioni all'app e ritorna alla pagina index
     * @param model
     * @return
     */
    @GetMapping("/")
    public String home(HttpServletRequest request, Authentication authentication ,Model model){
        if(request.getSession().getAttribute("user") != null){
            User u = (User) request.getSession().getAttribute("user");
            if(u.getRole().equals(ROLE_USER)){
                model.addAttribute("title","Dashboard");
                return "utenza/dashboard";
            }
            if(u.getRole()== ROLE_ADMIN){
                //TODO admin dashboard
                //model.addAttribute("title","Dashboard");
                //return "utenza/dashboard";
            }
        }
        model.addAttribute("appName", AppConfGene.NAMEAPP);
        model.addAttribute("appDes", AppConfGene.DESCRIPTIONAPP);
        model.addAttribute("title","Welcome");
        return "index";
    }

    /**
     * Metodo get per accedere alla pagina di Login
     * @return
     */
    @GetMapping("/login")
    public String doLogin(HttpServletRequest request, Model model){
        //Se l'utente è gia loggato
        if(request.getSession().getAttribute("user") != null){
            return "redirect:/";
        }
        return "index";
    }

    /**
     * In caso di credenziali sbaglaite
     * @param model
     * @return
     */
    @RequestMapping("/login-error")
    public String loginError(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("user") != null){
            return "redirect:/";
        }
        model.addAttribute("loginError", true);
        return "index";
    }

    /**
     * Dopo aver effettuato il login con spring security
     * Mette in sessione l'user e rindirizza alla dashboard
     * @param request
     * @param authentication
     * @return
     */
    @GetMapping("/loginSuccess")
    public String loginSuccess(HttpServletRequest request, Authentication authentication, Model model){
        if(authentication == null) return "redirect:/";
        if(!authentication.isAuthenticated()) return "redirect:/login";
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent((User) -> request.getSession().setAttribute("user",user.get()));
        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));

        //TODO può essere differenziato in base al ruolo

        model.addAttribute("title","Dashboard");
        return "utenza/dashboard";
    }


    /**
     * Get della pagina di registrazione
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String doRegister(HttpServletRequest request, Model model){
        //Utente loggato che prova a registrasi
        if(request.getSession().getAttribute("user") != null){
            return "redirect:/";
        }
        model.addAttribute("title","Welcome");
        model.addAttribute("registrationForm", new RegistrationForm());
        //if(model == null) model.addAttribute("registrationForm",new RegistrationForm());
        return "utenza/registration";
    }

    /**
     * Efettua la registrazione di un nuovo utente,
     * al seguito della registrazione logga in automatico l'utente
     * @param request
     * @param response
     * @param rf
     * @param result
     * @param redirectAttribute
     * @param model
     * @param authentication
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request,
                           HttpServletResponse response,
                           @ModelAttribute @Valid RegistrationForm rf,
                           BindingResult result,
                           RedirectAttributes redirectAttribute,
                           ModelMap model,
                           Authentication authentication){
        //Utente loggato che prova a registrasi
        if(request.getSession().getAttribute("user") != null){
            return "redirect:/";
        }
        //Controlli Validate Form
        if (result.hasErrors()) return "utenza/registration";
        //Controlli Custom
        Map listError = new HashMap<String,String>();
        if(!rf.getPassword().equals(rf.getPasswordConfirm())){
            listError.put("PasswordError","Le password non corrispondono");
        }
        if(userService.emailIsOk(rf.getEmail())){
            listError.put("EmailError","Questa email non può essere accettata");
        }
        if(userService.usernameIsOk(rf.getUsername())){
            listError.put("UsernameError","Username già in uso");
        }
        //Se ci sono errori Torna alla pagina di registrazione
        if(listError.size() > 0){
            listError.forEach((k,v) -> model.addAttribute(k.toString(),v.toString()));
            return "utenza/registration";
        }

        //Salva l'account
        User user = new User();
        user.setUsername(rf.getUsername());
        user.setEmail(rf.getEmail());
        user.setPassword(rf.getPassword());
        user = userService.registerUser(user);
        if(user == null){
            response.setStatus(Response.SC_INTERNAL_SERVER_ERROR);
            return "redirect:/error";
        }
        authWithHttpServletRequest(request,user.getUsername(),user.getPassword());
        request.getSession().setAttribute("user",user);
        model.addAttribute("title","Dashboard");
        //authentication.isAuthenticated();
        return "utenza/dashboard";
    }

    /**
     * Effettua il login aggiungendo l'utente "Authentication authentication"
     * @param request
     * @param username
     * @param password
     */
    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {

        }
    }



    @GetMapping("/goLogout")
    public String goLogout(HttpServletRequest request, Model model, Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
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
