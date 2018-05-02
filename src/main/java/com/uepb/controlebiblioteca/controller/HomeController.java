package com.uepb.controlebiblioteca.controller;

import com.uepb.controlebiblioteca.model.AppUser;
import com.uepb.controlebiblioteca.model.UserRole;
import com.uepb.controlebiblioteca.service.AppUserService;
import com.uepb.controlebiblioteca.service.UserRoleService;
import com.uepb.controlebiblioteca.util.Principal;
import com.uepb.controlebiblioteca.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    UserRoleService userRoleService;


    @RequestMapping(value = "/")
    public ModelAndView home(ModelAndView model, Principal principal){
    	
        return principal.userDetail(model, "home");
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup(){
        return "signup";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:login";
    }

    @RequestMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String test(){
        return "home";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupForm(@RequestParam String userName, @RequestParam String password){
        UserRole role = userRoleService.getRoleUser();
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);

        appUserService.insertAppUser(new AppUser(userName, Util.encodePassword(password),roles));
        return "redirect:/login";
    }
}
