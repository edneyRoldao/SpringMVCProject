package com.springTutorial.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springTutorial.model.Produto;

public class ProdutoValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		
		Produto produto = (Produto) obj;

		/**
		 * Validando campo titulo
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "titulo", "field.required");

		/**
		 * Validando campo descrição
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "descricao", "field.required");
		
		/**
		 * Validando campo paginas
		 */
		if(produto.getPaginas() == 0)
			err.rejectValue("paginas", "field.required");
		
	}

}
