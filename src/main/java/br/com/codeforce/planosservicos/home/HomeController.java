package br.com.codeforce.planosservicos.home;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codeforce.planosservicos.cliente.Cliente;
import br.com.codeforce.planosservicos.cliente.ClienteRepository;
import br.com.codeforce.planosservicos.empresa.Empresa;
import br.com.codeforce.planosservicos.empresa.EmpresaRepository;
import br.com.codeforce.planosservicos.usuarios.UsuarioRepository;
import br.com.codeforce.planosservicos.usuarios.Usuarios;

@Controller
public class HomeController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/")
	public String formLogin() {
		return "formLogin";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "formLogin";
	}
	
	@RequestMapping("/verificaLogin")
	public String verificaLogin(String login, String senha) {
		try {
			Usuarios findByLogin = usuarioRepository.findByLogin(login);
			if(!findByLogin.equals(null)) {
				if(findByLogin.getLogin().equals(login) && findByLogin.getSenha().equals(senha)) {
					if(findByLogin.getModalidade().equals(Modalidade.CLIENTE)) {
						return "redirect:/cliente/listarTodos";
					}
					return "redirect:/empresa/listarTodos";
				}
				return "redirect:/";
			}
			return "redirect:/";
		
		} catch (Exception e) {
			return "redirect:/";
		}
		
}
		
	@RequestMapping("/selecaoCadastro")
	 public String selecaoCadastro() {
		 return "selecaoCadastro";
	 }
	
	@RequestMapping("/cadastradoComSucesso")
	public String cadastradoComSucesso(String id,String modalidade, Model model) {
		if(modalidade.equals("CLIENTE")) {
			Optional<Cliente> cliente = clienteRepository.findById(Long.valueOf(id));
			model.addAttribute("usuario", cliente);
			return "cadastroSucess";
		}
		Optional<Empresa> empresa = empresaRepository.findById(Long.valueOf(id));
		model.addAttribute("usuario", empresa);
		return "cadastroSucess";
	}
	
	@RequestMapping("/cliente/listarTodos")
	public String listarEmpresas(String modalidade,Model model) {
			List<Empresa> listaEmpresas = empresaRepository.findAll();
			model.addAttribute("listaEmpresas", listaEmpresas);
			return"listarEmpresas";
	}
	
	@RequestMapping("/empresa/listarTodos")
	public String listarClientes(String modalidade,Model model) {
			return"listarOrcamento";
	}
	
}
