package br.com.rpatetti.dao;

import java.util.Collection;

import br.com.rpatetti.domain.Cliente;

public interface IClienteDAO {

	public Boolean cadastrar(Cliente cliente);
	
	public void excluir(Long cpf);
	
	public void alterar(Cliente cliente);
	
	public Cliente consultar(long cpf);
	
	public Collection<Cliente> buscarTodos();
	
}
