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

/**
 * HomeController representa as acoes de controle de autenticacoes de usuarios
 * @author Eduardo Borba
 *
 */
@Controller
public class HomeController {

	/**
	 * Atribuicao da interface AppUserService
	 */
    @Autowired
    AppUserService appUserService;

    /**
     * Atribuicao da interface UserRoleService
     */
    @Autowired
    UserRoleService userRoleService;


    /**
     * Este método retorna uma pagina inicial
     * rota: /
     */
    @RequestMapping(value = "/")
    public ModelAndView home(ModelAndView model, Principal principal){
        return principal.userDetail(model, "home");
    }

    /**
     * Este método retorna uma pagina de login
     * rota: /login
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    /**
     * Este método retorna uma pagina de registro
     * rota: /signup
     */
    @RequestMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    /**
     * Este método retorna uma pagina de login invalidando a sessao de acesso do usuario atual
     * rota: /logout
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:login";
    }

    /**
     * 
     * rota: /test
     */
    @RequestMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String test(){
        return "home";
    }

    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupForm(@RequestParam String userName, 
    		@RequestParam String password,
    		@RequestParam String roleName){
        UserRole role = userRoleService.getRoleUser(roleName);
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);

        appUserService.insertAppUser(new AppUser(userName, Util.encodePassword(password),roles));
        return "redirect:/login";
    }
}
