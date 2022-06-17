package br.com.stoc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.stoc.model.ItemModel;

import br.com.stoc.repository.ItemRepository;

@Controller
public class ItemContoller {
	
	//cria uma instãncia do nosso repositório
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping({"/consulta"}) //é o nome que eu quiser colocar
    public String home(ModelMap model) { 			
    	   
		
		 model.addAttribute("consulta",itemRepository.findAll());
		 return "consulta.html"; //é o nome do arquivo real	
    	    	
    }
	
	@GetMapping("/deletar_item/{id}")
	public String delete(ItemModel fornecedor, @PathVariable("id") long id, RedirectAttributes attr) {
		fornecedor = (ItemModel) this.itemRepository.getOne(id);
		this.itemRepository.delete(fornecedor); // Exclui o usuario
		attr.addFlashAttribute("mensagem", "Item excluído com sucesso.");
		attr.addFlashAttribute("tipo_mensagem", "alert alert-sucess");
		return "redirect:../consulta";
	}
	
	
	@PostMapping(value = "/cadastraritem")
	public ModelAndView cadastrarItem(@Valid ItemModel item, BindingResult result,
			 RedirectAttributes atributes) {
		if (result.hasErrors()) {
			return cadastraritem(item);
		}

	
		ModelAndView mv = new ModelAndView("redirect:consulta");
		itemRepository.save(item);
		atributes.addFlashAttribute("mensagem", "item cadastrado com sucesso!");

		return mv;
	}
	
	
	
	
	
	
	@GetMapping(value = "/cadastraritem")
	public ModelAndView cadastraritem(ItemModel fonecedor) {
		ModelAndView mv = new ModelAndView("/cadastraritem");

		return mv;

	}
	
	
}
