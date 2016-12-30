package br.alfa.labcliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alfa.labcliente.entity.Cliente;
import br.alfa.labcliente.entity.Endereco;
import br.alfa.labcliente.entity.Telefone;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNome(String nome);
	Cliente findByCpfCnpj(String cpfCnpj);
	Cliente findByEndereco(Endereco endereco);
	Cliente findByTelefone(Telefone telefone);
	
}
