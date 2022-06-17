package br.com.stoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.stoc.repository.PedidoRepository;


@Controller
public class PedidoController {

		//cria uma instãncia do nosso repositório
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@GetMapping({"/pedido"}) //é o nome que eu quiser colocar
	    public String home(ModelMap model) { 			
	    	   
			
		
			 return "pedido.html"; //é o nome do arquivo real	
	    	    	
	    }
		
		@GetMapping({"/pedido/pedido"}) //é o nome que eu quiser colocar
	    public String listarfuncionario(ModelMap model) { 			
	    	   
			 //o findAll lista todos atores 
			 model.addAttribute("pedido",pedidoRepository.findAll());
			 return "pedido/pedido"; //é o nome do arquivo real	
	    	    	
	    }
	
	}



