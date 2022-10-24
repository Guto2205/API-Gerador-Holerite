package br.com.holerite.dto;

import lombok.Data;

@Data
public class EmpresaDTO {

	private String nome;
	private String cep;
	private String cnpj;
	private String telefone;
	private String estado;
	private String cidade;
	private String endereco;
	
}