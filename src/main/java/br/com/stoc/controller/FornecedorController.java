
package br.com.stoc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stoc.mail.Mensagem;
import br.com.stoc.model.FornecedorModel;
import br.com.stoc.model.UsuarioModel;
import br.com.stoc.repository.FornecedorRepository;







@Controller
public class FornecedorController {
	


			//cria uma instãncia do nosso repositório
			@Autowired
			private FornecedorRepository fornecedorRepository;
			
			@GetMapping({"/lista_fornecedores"}) //é o nome que eu quiser colocar
		    public String home(ModelMap model) { 			
		    	   
				
				 model.addAttribute("lista_fornecedores",fornecedorRepository.findAll());
				 return "lista_fornecedores.html"; //é o nome do arquivo real	
		    	    	
		    }
			
			
			
			
			@GetMapping("/deletar_fornecedor/{id}")
			public String delete(FornecedorModel fornecedor, @PathVariable("id") long id, RedirectAttributes attr) {
				fornecedor = (FornecedorModel) this.fornecedorRepository.getOne(id);
				this.fornecedorRepository.delete(fornecedor); // Exclui o usuario
				attr.addFlashAttribute("mensagem", "Fornecedor excluído com sucesso.");
				attr.addFlashAttribute("tipo_mensagem", "alert alert-sucess");
				return "redirect:../lista_fornecedores";
			}
			
		
				
		    	    	
		    
			
			
			@PostMapping(value = "/cadastrarfornecedor")
			public ModelAndView cadastrarFornecedor(@Valid FornecedorModel fornecedor, BindingResult result,
					 RedirectAttributes atributes) {
				if (result.hasErrors()) {
					return cadastrarfornecedor(fornecedor);
				}

			
				ModelAndView mv = new ModelAndView("redirect:lista_fornecedores");
				fornecedorRepository.save(fornecedor);
				atributes.addFlashAttribute("mensagem", "Fornecedor cadastrado com sucesso!");

				return mv;
			}
			
			
			
			
			
			
			@GetMapping(value = "/cadastrarfornecedor")
			public ModelAndView cadastrarfornecedor(FornecedorModel fonecedor) {
				ModelAndView mv = new ModelAndView("/cadastrarfornecedor");

				return mv;

			}
}