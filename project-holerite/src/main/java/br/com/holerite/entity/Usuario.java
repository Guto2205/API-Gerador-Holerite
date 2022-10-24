package br.com.holerite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="usuario")
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String funcionario;
	private String mes;
	private Double salario;
	private Double desconto;
	private Double salarioliquido;
	private Integer matricula;
	private String cargo;
	
	@ManyToOne// muitos usuarios para uma empresas
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
}
