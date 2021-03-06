package br.com.stoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.stoc.repository.FornecedorRepository;

import br.com.stoc.repository.ItemRepository;


	@Controller
	public class RelatorioController {
	   
	    @Autowired
	    private ItemRepository itemRepository;
	   
	    @GetMapping({"/rel_item"})
	    public String listarItem(ModelMap model) {
	       
	        model.addAttribute("itens",itemRepository.findAll());
	        return"rel_item.html";
	    }
	    
	    @Autowired
	    private FornecedorRepository fornecedorRepository;
	   
	    @GetMapping({"/rel_fornecedor"})
	    public String listarFornecedor (ModelMap model) {
	       
	        model.addAttribute("fornecedor",fornecedorRepository.findAll());
	        return"rel_fornecedor.html";
	    }

	 
}

