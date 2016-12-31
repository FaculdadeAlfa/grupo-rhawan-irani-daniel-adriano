package br.alfa.labcliente.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alfa.labcliente.entity.Cliente;
import br.alfa.labcliente.entity.Endereco;
import br.alfa.labcliente.entity.Telefone;
import br.alfa.labcliente.entity.TipoPessoa;
import br.alfa.labcliente.entity.UF;
import br.alfa.labcliente.form.validator.ClienteFormValidator;
import br.alfa.labcliente.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteFormValidator clienteFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(clienteFormValidator);
	}
	
	@PostConstruct
	public void init() {
		//Populando clientes de teste
		Cliente cliente1 = new Cliente();
		cliente1.setNome("João Maria");
		cliente1.setCpfCnpj("12345678901");
		cliente1.setTipoPessoa(TipoPessoa.FISICA);
		
		Telefone telefone1 = new Telefone();
		telefone1.setFixo("33215476");
		
		Endereco endereco1 = new Endereco();
		endereco1.setCidade("GOIANIA");
		endereco1.setUf(UF.GO);
		endereco1.setCep("74000000");
		cliente1.setTelefone(telefone1);
		cliente1.setEndereco(endereco1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Transportadora super rápido");
		cliente2.setCpfCnpj("95591723012206");
		cliente2.setTipoPessoa(TipoPessoa.JURIDICA);
		
		Telefone telefone2 = new Telefone();
		telefone2.setFixo("23214543");
		
		Endereco endereco2 = new Endereco();
		endereco2.setCidade("SÃO PAULO");
		endereco2.setUf(UF.SP);
		endereco2.setCep("11000000");
		cliente2.setTelefone(telefone2);
		cliente2.setEndereco(endereco2);
		
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
	}
	
	@RequestMapping("/")
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);
		return "pesquisaCliente";
	}
	
	@RequestMapping("/cadastroCliente")
	public String cadastroCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("tiposPessoa", TipoPessoa.values());
		model.addAttribute("ufs", UF.values());
		return "cadastroCliente";
	}
	
	@PostMapping(value="/clientes")
	public String salvarCliente(@Valid Cliente cliente,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "cadastroCliente";
		} else {
			logger.info("Salvando cliente: {}", cliente);
			clienteRepository.save(cliente);
			redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
		}
		
		return listarClientes(model);
	}

}
