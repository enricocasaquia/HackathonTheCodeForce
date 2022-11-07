package br.com.codeforce.planosservicos.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.codeforce.planosservicos.home.Servicos;

public class ClienteDto {
	
	
	private String id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String celular;
	@NotBlank
	private String servicos;
	@NotBlank
	private String senha;
	
	
	public Cliente toSalve(){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		cliente.setEmail(email);
		cliente.setCelular(celular);
		cliente.setServicos(Servicos.valueOf(servicos));
		
		
		return cliente;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase().trim();
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome.toUpperCase().trim();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase().trim();
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getServicos() {
		return servicos;
	}
	public void setServicos(String servicos) {
		this.servicos = servicos.toUpperCase().trim();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
