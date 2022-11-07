package br.com.codeforce.planosservicos.empresa;

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
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/formEmpresa")
	public String formEmpresa(EmpresaDto empresaDto) {
		return"formEmpresa";
	}
	
	@PostMapping("/salveEmpresa")
	public String salveEmpresa(@Valid EmpresaDto empresaDto, BindingResult result) {
		Usuarios usuario = new Usuarios();
		if(result.hasErrors()) {
			return "/formEmpresa";
		}
		usuario.setLogin(empresaDto.getEmail());
		usuario.setSenha(empresaDto.getSenha());
		usuario.setModalidade(Modalidade.EMPRESA);
		usuarioRepository.save(usuario);
		
		Empresa empresa = empresaRepository.save(empresaDto.toSalve());
		return"redirect:/cadastradoComSucesso?id="+empresa.getId()+"&modalidade="+empresa.getModalidade();
	}
}
