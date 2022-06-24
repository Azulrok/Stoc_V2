package br.com.stoc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import br.com.stoc.repository.MovimentacaoRepository;




@Controller
public class MovimentacaoController {
	
	
	
	//cria uma instãncia do nosso repositório
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@GetMapping({"/histmovimentacao"}) //é o nome que eu quiser colocar
    public String home(ModelMap model) { 			
    	   
		
		 model.addAttribute("movimentacoes",movimentacaoRepository.findAll());
		 return "histmovimentacao.html"; //é o nome do arquivo real	
    	    	
    }

		
	}