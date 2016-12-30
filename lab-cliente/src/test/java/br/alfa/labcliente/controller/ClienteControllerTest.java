package br.alfa.labcliente.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClienteControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void cadastroCliente() {
		String body = this.testRestTemplate.getForEntity("/cadastroCliente", String.class).getBody();
		assertTrue(body.contains("containerCadastro"));
	}
	
	

}
