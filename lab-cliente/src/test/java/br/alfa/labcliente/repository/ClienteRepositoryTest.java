package br.alfa.labcliente.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.alfa.labcliente.entity.Cliente;
import br.alfa.labcliente.entity.Endereco;
import br.alfa.labcliente.entity.Telefone;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ClienteRepository repository;
	
	@Test
	public void findByNome() {
		Cliente cliente = new Cliente();
		cliente.setNome("Joao Pedro");
		cliente.setCpfCnpj("12345678901");
		this.entityManager.persist(cliente);
		
		Cliente clienteConsulta = this.repository.findByNome("Joao Pedro");
		
		assertEquals("12345678901", clienteConsulta.getCpfCnpj());
	}
	
	@Test
	public void findByCpfCnpj() {
		Cliente cliente = new Cliente();
		cliente.setNome("Joao Marcos");
		cliente.setCpfCnpj("12345678901");
		this.entityManager.persist(cliente);
		
		Cliente clienteConsulta = this.repository.findByCpfCnpj("12345678901");
		
		assertEquals("Joao Marcos", clienteConsulta.getNome());
	}
	
	@Test
	public void findByEndereco() {
		
		Endereco endereco = new Endereco();
		
		endereco.setBairro("St. Oeste");
		endereco.setLogradouro("logradouro");
		endereco.setNumero("41");
		endereco.setCidade("Goiania");
		endereco.setCep("74000000");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Pedro Paulo");
		cliente.setCpfCnpj("12345678901");
		cliente.setEndereco(endereco);
		
		this.entityManager.persist(cliente);
		
		Cliente clienteConsulta = this.repository.findByEndereco(endereco);
		
		assertEquals("Pedro Paulo", clienteConsulta.getNome());
	}

	@Test
	public void findByTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setFixo("33333022");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Joao Marcos");
		cliente.setCpfCnpj("12345678901");
		cliente.setTelefone(telefone);
		
		this.entityManager.persist(cliente);
		
		Cliente clienteConsulta = this.repository.findByTelefone(telefone);
		
		assertEquals("Joao Marcos", clienteConsulta.getNome());
	}
	
}
