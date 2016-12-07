package br.com.fernandoaag.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.fernandoaag.entidade.ContatoEntidade;
import br.com.fernandoaag.http.Contato;
import br.com.fernandoaag.repositorio.ContatoRepositorio;

/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
 
	private final  ContatoRepositorio repository = new ContatoRepositorio();
 
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra um novo contato
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Contato contato){
 
		ContatoEntidade entity = new ContatoEntidade();
 
		try {
			entity.setNome(contato.getNome());
			entity.setApelido(contato.getApelido());
			entity.setDtNasc(contato.getDtNasc());
			entity.setTelefone(contato.getTelefone());
			entity.setTipo(contato.getTipo());
			entity.setEmail(contato.getEmail());
			
			repository.Salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
 
	}
 
	/**
	 * Essse método altera um contato já cadastrado
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Contato contato){
 
		ContatoEntidade entity = new ContatoEntidade();
 
		try {
 
			entity.setIdContato(contato.getIdContato());
			entity.setNome(contato.getNome());
			entity.setApelido(contato.getApelido());
			entity.setDtNasc(contato.getDtNasc());
			entity.setTelefone(contato.getTelefone());
			entity.setTipo(contato.getTipo());
			entity.setEmail(contato.getEmail());
 
			repository.Alterar(entity);
 
			return "Registro alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o registro " + e.getMessage();
 
		}
 
	}
	/**
	 * Esse método lista todos contatos cadastrados no banco
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listaContatos")
	public List<Contato> ListaContatos(){
 
		List<Contato> contatos =  new ArrayList<Contato>();
 
		List<ContatoEntidade> listaEntityContatos = repository.Listar();
 
		for (ContatoEntidade entity : listaEntityContatos) {
 
			contatos.add(new Contato(entity.getIdContato(),
			entity.getNome(),
			entity.getApelido(),
			entity.getDtNasc(),
			entity.getTelefone(),
			entity.getTipo(),
			entity.getEmail()));
		}
 
		return contatos;
	}
 
	/**
	 * Esse método busca uma pessoa cadastrada pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getContato/{idContato}")
	public Contato GetContato(@PathParam("idContato") Integer id){
 
		ContatoEntidade entity = repository.GetContato(id);
 
		if(entity != null)
			return new Contato(entity.getIdContato(),
					entity.getNome(),
					entity.getApelido(),
					entity.getDtNasc(),
					entity.getTelefone(),
					entity.getTipo(),
					entity.getEmail());
 
		return null;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getContatoNome/{nome}")
	public List<Contato> GetContatoNome(@PathParam("nome") String nome){
 
		List<Contato> contatos =  new ArrayList<Contato>();
		 
		List<ContatoEntidade> listaEntityContatos = repository.GetContatoNome(nome);
		
		if(listaEntityContatos != null){
			for (ContatoEntidade entity : listaEntityContatos) {
				 
				contatos.add(new Contato(entity.getIdContato(),
				entity.getNome(),
				entity.getApelido(),
				entity.getDtNasc(),
				entity.getTelefone(),
				entity.getTipo(),
				entity.getEmail()));
			}
			return contatos;
		}else{
			return null;
		}
 	}
	
 
	/**
	 * Excluindo uma pessoa pelo código
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{idContato}")	
	public String Excluir(@PathParam("idContato") Integer id){
 
		try {
 
			repository.Excluir(id);
 
			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
 
	}
 
}