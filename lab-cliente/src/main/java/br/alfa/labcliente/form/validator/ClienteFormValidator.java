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
		Cliente cliente = (Cliente) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "NotEmpty.clienteForm.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpfCnpj", "NotEmpty.clienteForm.cpfCnpj");
	}

}
