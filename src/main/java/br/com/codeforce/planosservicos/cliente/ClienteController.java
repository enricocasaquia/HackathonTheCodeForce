package br.com.codeforce.planosservicos.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codeforce.planosservicos.home.Modalidade;
import br.com.codeforce.planosservicos.usuarios.UsuarioRepository;
import br.com.codeforce.planosservicos.usuarios.Usuarios;

@Controller
public class ClienteController {
	
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/formCliente")
	public String formCliente(ClienteDto clienteDto) {
		return "formCliente";
	}
	
	@PostMapping("/clienteSalve")
	public String clienteSalve(@Valid ClienteDto clienteDto, BindingResult result) {
		Usuarios usuario = new Usuarios();
		if(result.hasErrors()) {
			return"/formCliente";
		}
		Cliente cliente = clienteRepository.save(clienteDto.toSalve());
		usuario.setLogin(clienteDto.getEmail());
		usuario.setSenha(clienteDto.getSenha());
		usuario.setModalidade(Modalidade.CLIENTE);
		usuarioRepository.save(usuario);
		
		return "redirect:/cadastradoComSucesso?id="+cliente.getId()+"&modalidade="+cliente.getModalidade();
	}

}
