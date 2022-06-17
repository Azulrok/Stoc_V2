package br.com.stoc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	@GetMapping({"/home"}) //é o nome que eu quiser colocar
    public String home(ModelMap model) { 			
    	   
		
	
		 return "home.html"; //é o nome do arquivo real	
    	    	
    }
	@GetMapping({"/login"}) //é o nome que eu quiser colocar
    public String login(ModelMap model) { 			
    	   
		
	
		 return "login.html"; //é o nome do arquivo real	
    	    	
    }
	
	
	@GetMapping({"/recuperar_senha"}) //é o nome que eu quiser colocar
    public String recuperar(ModelMap model) { 			
    	   
		
	
		 return "recuperar_senha.html"; //é o nome do arquivo real	
    	    	
    }
	
	
	@RequestMapping(value = {"/postlogin"}, method = {RequestMethod.POST})
	public String postLogin(Model model, HttpSession session) {
	
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String cpf = auth.getName(); 
		
		
		session.setAttribute("cpf", cpf);
		
		return "home.html";
		
	}
}