package br.com.stoc.controller;

import java.util.Arrays;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stoc.mail.Mailer;
import br.com.stoc.mail.Mensagem;
import br.com.stoc.model.UsuarioModel;
import br.com.stoc.repository.UsuarioRepository;


 




@Controller
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private Mailer mailer;
	
	
	
	
	@GetMapping(value = "/lista_funcionarios")
	public ModelAndView ListarFuncionario(ModelMap model) {
		// Lista todos os usuários
		ModelAndView mv = new ModelAndView("/lista_funcionarios");

		model.addAttribute("usuarios", this.usuarioRepository.findAll());

		return mv;

	}


	 
	   
	    @GetMapping({"/rel_funcionarios"})
	    public String relatorioUsuario (ModelMap model) {
	       
	        model.addAttribute("funcionarios",usuarioRepository.findAll());
	        return"rel_funcionarios.html";
	    }
	    
	
	
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarFuncionario(@Valid UsuarioModel usuario, BindingResult result,
			@RequestParam("confirmar_email") String confirmarEmail, RedirectAttributes atributes) {
		if (result.hasErrors()) {
			return cadastrar(usuario);
		}

		ModelAndView mv = new ModelAndView("redirect:lista_funcionarios");
		usuarioRepository.save(usuario);
		atributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");

		return mv;

	}



	@GetMapping(value = "/cadastro")
	public ModelAndView cadastrar(UsuarioModel usuario) {
		ModelAndView mv = new ModelAndView("/cadastro");

		return mv;

	}
	
	
	
	@GetMapping(value = "/alterar_usuario/{id}")
	public ModelAndView alterarUsuario(UsuarioModel usuarioModel,ModelMap model, @PathVariable("id") Long idUsuario) {
	UsuarioModel usuario = new UsuarioModel();
	usuario = usuarioRepository.getOne(idUsuario);
	model.addAttribute("usuarioModel",usuarioRepository.findById(idUsuario));
	return new ModelAndView("cadastro",model);
	}
	
	
	@GetMapping("/deletar/{id}")
	public String delete(UsuarioModel usuario, @PathVariable("id") long id, RedirectAttributes attr) {
		usuario = (UsuarioModel) this.usuarioRepository.getOne(id);
		this.usuarioRepository.delete(usuario); // Exclui o usuario
		attr.addFlashAttribute("mensagem", "Usuário excluído com sucesso.");
		attr.addFlashAttribute("tipo_mensagem", "alert alert-sucess");
		return "redirect:../lista_funcionarios";
	}
	
	
	
	
	@PostMapping({ "/cadastro/recuperar_senha" })
	public ModelAndView recuperarSenhaEmail(UsuarioModel usuario, Model model, RedirectAttributes atributes) {

		ModelAndView mv = new ModelAndView("recuperar_senha.html");

		usuario = this.usuarioRepository.getOneByCpf(usuario.getCpf());

		String novaSenha = getRandomPass(); // gera uma senha randomica de 8 digitos

		BCryptPasswordEncoder b = new BCryptPasswordEncoder();

		usuarioRepository.alterarSenha(b.encode(novaSenha), usuario.getCpf());

		this.mailer.enviar(new Mensagem("stoc - Etejk <noreplysakila@gmail.com>",
				Arrays.asList("Recuperação de senha <" + usuario.getEmail() + ">"), "Recuperação de senha",
				"Olá! \n\n Sua nova senha é:  " + novaSenha));

		model.addAttribute("mensagem", "Senha enviada com sucesso para o email cadastrado.");

		return mv;

	}
	
	public String getRandomPass() {
		char[] chart = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };

		char[] senha = new char[8];

		int chartLenght = chart.length;
		Random rdm = new Random();

		for (int x = 0; x < 8; x++)
			senha[x] = chart[rdm.nextInt(chartLenght)];

		return new String(senha);
	}
	
	
	
	
	
	
}

