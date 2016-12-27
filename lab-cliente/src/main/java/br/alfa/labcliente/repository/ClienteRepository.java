package br.alfa.labcliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alfa.labcliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
