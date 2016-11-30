package br.com.fernandoaag.http;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contato {
	private int idContato;
	private String nome;
	private String apelido;
	private Date dtNasc;
	private String telefone;
	private String tipo;
	private String email;
	
	public Contato(){
		
	}
	
	public Contato(int idContato, String nome, String apelido, 
			Date dtNasc, String telefone, String tipo, String email){
		super();
		this.idContato = idContato;
		this.nome = nome;
		this.apelido = apelido;
		this.dtNasc = dtNasc;
		this.telefone = telefone;
		this.tipo = tipo;
		this.email = email;
	}
	
	public int getIdContato() {
		return idContato;
	}
	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		
		this.dtNasc = dtNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
