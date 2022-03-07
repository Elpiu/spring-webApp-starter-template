package com.elpiu.application.web.errorController;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("title","Error Page");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            //if(statusCode == HttpStatus.NOT_FOUND.value()) {
            //else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            model.addAttribute("errorMessage",statusCode.toString());
        }
        return "error/error";
    }
}