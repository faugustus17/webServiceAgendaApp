package br.com.fernandoaag.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class ContatoEntidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idContato")
	private int idContato;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="apelido")
	private String apelido;
	
	@Column(name="dtNasc")
	private Date dtNasc;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="email")
	private String email;

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
