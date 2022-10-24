package br.com.holerite.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private String funcionario;
	private String mes;
	private Double salario;
	private Double desconto;
	private Double salarioliquido;
	private Integer matricula;
	private String cargo;
}
