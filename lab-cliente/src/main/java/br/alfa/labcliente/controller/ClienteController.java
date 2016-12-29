package br.alfa.labcliente.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alfa.labcliente.entity.Cliente;
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
	
	@RequestMapping(value="/clientes", method=RequestMethod.POST)
	public String salvarCliente(@ModelAttribute("cliente") Cliente cliente,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("Salvando cliente: {}", cliente);
		
		if(result.hasErrors()) {
			
		} else {
			clienteRepository.save(cliente);
			redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
		}
		
		return listarClientes(model);
	}

}
