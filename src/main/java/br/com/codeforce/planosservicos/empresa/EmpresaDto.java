package br.com.codeforce.planosservicos.empresa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.codeforce.planosservicos.home.Servicos;

public class EmpresaDto {
	private String id;
	
	@NotBlank
	private String nomeDaEmpresa;
	@NotBlank
	private String responsavel;
	@NotBlank
	private String endereco;
	@NotBlank
	private String telefone;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	@CNPJ
	private String cnpj;
	@NotBlank
	private String servicos;
	@NotBlank
	private String linkFoto;
	
	public Empresa toSalve() {
		Empresa empresa = new Empresa();
		
		empresa.setNomeDaEmpresa(nomeDaEmpresa);
		empresa.setResponsavel(responsavel);
		empresa.setEndereco(endereco);
		empresa.setTelefone(telefone);
		empresa.setEmail(email);
		empresa.setCnpj(cnpj);
		empresa.setServicos(Servicos.valueOf(servicos));
		empresa.setLinkFoto(linkFoto);
		
		return empresa;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa.toUpperCase().trim();
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel.toUpperCase().trim();
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco.toUpperCase().trim();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase().trim();
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getServicos() {
		return servicos;
	}
	public void setServicos(String servicos) {
		this.servicos = servicos.toUpperCase().trim();
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
