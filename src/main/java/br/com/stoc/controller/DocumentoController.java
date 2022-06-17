package br.com.stoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.stoc.repository.DocumentoRepository;







@Controller
public class DocumentoController  {

		//cria uma instãncia do nosso repositório
		@Autowired
		private DocumentoRepository documentoRepository;
		
		@GetMapping({"/Documento"}) //é o nome que eu quiser colocar
	    public String home(ModelMap model) { 			
	    	   
			
		
			 return "Documento.html"; //é o nome do arquivo real	
	    	    	
	    }
		
		@GetMapping({"/Documento/Documento"}) //é o nome que eu quiser colocar
	    public String listarfuncionario(ModelMap model) { 			
	    	   
			 //o findAll lista todos atores 
			 model.addAttribute("Documento",documentoRepository.findAll());
			 return "Documento/Documento"; //é o nome do arquivo real	
	    	    	
	    }
	
	}