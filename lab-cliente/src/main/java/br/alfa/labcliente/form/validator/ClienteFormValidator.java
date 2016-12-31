package br.alfa.labcliente.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.alfa.labcliente.entity.Cliente;

@Component
public class ClienteFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "NotEmpty.clienteForm.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpfCnpj", "NotEmpty.clienteForm.cpfCnpj");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoPessoa", "NotEmpty.clienteForm.tipoPessoa");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefone.fixo", "NotEmpty.clienteForm.telefoneFixo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.cidade", "NotEmpty.clienteForm.cidade");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.uf", "NotEmpty.clienteForm.uf");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.cep", "NotEmpty.clienteForm.cep");
	}

}
