package br.alfa.labcliente.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.alfa.labcliente.entity.Cliente;

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

}
