package br.com.holerite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="empresa")
@Data
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cep;
	private String cnpj;
	private String telefone;
	private String estado;
	private String cidade;
	private String endereco;
	
	// uma empresa para muitos usuarios
	@OneToMany(mappedBy = "empresa")//minha classe usuario será mapeada por empresa
	private List<Usuario> usuarios;

}
