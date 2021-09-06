package com.isi.controllers;

import com.isi.dao.IUser;
import com.isi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUser userdao;


    /**
     * Spring security
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/connect")
    public String pageUsers(@RequestParam String email,@RequestParam String password) {
        System.out.println(email);
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		password = pwdEncoder.encode(password);
        User u = userdao.findUserByEmailAndPassword(email,password);
        if(u!=null){
            return "pageUsers";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/pageUsers")
    public String pageUsers() {
        return "pageUsers";
    }

    @RequestMapping(value = "")
    public String home() {

        return "redirect:/logon";
    }

    @RequestMapping(value = "/")
    public String index() {

        return "redirect:/logon";
    }

    @RequestMapping(value = "/logon")
    public String logon(HttpServletRequest req, HttpServletResponse resp) {

        /*String email = req.getRemoteUser();
        User user = userdao.getUserByEmail(email);
        System.out.println(user.getPrenom() + "  " + user.getNom());*/

        return "redirect:/annees";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
    }

    @RequestMapping(value="/403")
    public String accessDenied(){
        return "403";
    }









    /*
    @Autowired
    private IUser userdao;
    /**
     * Spring security
     * "" ou / correspond a la connexion a l'application cest a dire home
      */
    /*@RequestMapping(value="/")
    public String home(){
        return "redirect:/online/logon";
    }

    @RequestMapping(value="")
    public String homes(){
        return "redirect:/online/logon";
    }

    @RequestMapping(value="/online/logon")
	public String index(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		//Recuperation du login de l'utilisateur connecte
		String user_email = request.getRemoteUser();

        System.out.println(user_email);
		return "redirect:/online/users";
	}

    @RequestMapping(value="/online/login")
    public String login(){

        return "prof/login";
    }
    @RequestMapping(value="/online/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //if (auth != null){
            //new SecurityContextLogoutHandler().logout(request, response, auth);
        //}
        return "redirect:/online/login?logout";
    }
    @RequestMapping(value="/online/403")
    public String accessDenied(){
        return "prof/403";
    }

    /**
     * Securite simple
     * Pour le fichier login1.html
    @RequestMapping(value = "/", name = "login")
    public String login() {

        return "prof/login1";
    }

    //Ceci marche bien
    @RequestMapping(value = "/logon", name = "logon", method= RequestMethod.POST)
    public String login(ModelMap map, String username, String password) {
        System.out.println(username + "     " + password);
        User user = userdao.chercher(username, password);
        //System.out.println(user.getPrenom() + "  " + user.getNom());

        if(user != null) {
            return "redirect:/online/users";
        } else {
            map.addAttribute("loginParam", "Login ou mot de passe incorrect !!! ");
            return "prof/login1";
            //return "redirect:/";
        }
    }
    */
}
