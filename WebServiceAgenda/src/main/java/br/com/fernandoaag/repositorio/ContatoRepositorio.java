package br.com.fernandoaag.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fernandoaag.entidade.ContatoEntidade;

public class ContatoRepositorio{
	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public ContatoRepositorio(){
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_agenda");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(ContatoEntidade contatoEntidade){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(contatoEntidade);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(ContatoEntidade contatoEntidade){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(contatoEntidade);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * LISTA TODOS OS CONTATOS CADASTRADOS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<ContatoEntidade> Listar(){
 
		return this.entityManager.createQuery("SELECT c FROM ContatoEntidade c ORDER BY c.nome").getResultList();
	}
 
	/**
	 * CONSULTA UMA PESSOA PELO ID
	 * */
	public ContatoEntidade GetContato(Integer id){
 
		return this.entityManager.find(ContatoEntidade.class, id);
	}
	
	/**
	 * CONSULTA UMA PESSOA PELO NOME
	 */
	@SuppressWarnings("unchecked")
	public List<ContatoEntidade> GetContatoNome(String nome){
		return (List<ContatoEntidade>) this.entityManager.createQuery("SELECT c FROM ContatoEntidade c WHERE nome LIKE '"+nome+"%'").getResultList();
	}
	
 
	/**
	 * EXCLUINDO UM REGISTRO PELO ID
	**/
	public void Excluir(Integer id){
 
		ContatoEntidade contato = this.GetContato(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(contato);
		this.entityManager.getTransaction().commit();
 
	}

}
