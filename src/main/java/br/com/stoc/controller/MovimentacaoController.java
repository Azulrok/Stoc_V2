package br.com.stoc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.stoc.model.MovimentacaoModel;
import br.com.stoc.repository.ItemRepository;
import br.com.stoc.repository.MovimentacaoRepository;
import br.com.stoc.repository.SetorRepository;
import br.com.stoc.repository.TipoMovimentacaoRepository;




@Controller
public class MovimentacaoController {
	
	
	
	//cria uma instãncia do nosso repositório
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private TipoMovimentacaoRepository tipoMovimentacaoRepository ;
	
	@Autowired
	private ItemRepository itemRepository ;
	
	
	@GetMapping({"/histmovimentacao"}) //é o nome que eu quiser colocar
    public String home(ModelMap model) { 			
    	   
		
		 model.addAttribute("movimentacoes",movimentacaoRepository.findAll());
		 return "histmovimentacao.html"; //é o nome do arquivo real	
    	    	
    }
	
	@GetMapping(value = "/movimentacao")
	public ModelAndView movimentacaoitem(MovimentacaoModel movimentacao) {
	
		ModelAndView mv = new ModelAndView("/movimentacao");
		mv.addObject("setores",setorRepository.findAll());
		mv.addObject("tipomovimentacao",tipoMovimentacaoRepository.findAll());
		mv.addObject("itens",itemRepository.findAll());
		return mv;

	}
	

	@PostMapping(value = "/movimentacao")
	public ModelAndView movimentacaoitem(@Valid MovimentacaoModel movimentacao,@RequestParam("idItem") Integer idItem,
			@RequestParam("idSetor") Long idSetor, @RequestParam("idTipoMovimentacao") Long idTipoMovimentacao,  BindingResult result,
			 RedirectAttributes atributes) {
		if (result.hasErrors()) {
			return movimentacaoitem(movimentacao);
		}

	movimentacao.setIdItem(idItem);
	movimentacao.setIdSetor(idSetor);
	movimentacao.setIdTipoMovimentacao(idTipoMovimentacao);
		ModelAndView mv = new ModelAndView("redirect:histmovimentacao");
		movimentacaoRepository.save(movimentacao);
		atributes.addFlashAttribute("mensagem", "Movimentação Feita com sucesso!");

		return mv;
	}
	
}