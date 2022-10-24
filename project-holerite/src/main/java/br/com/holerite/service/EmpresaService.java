package br.com.holerite.service;

import java.util.List;

import br.com.holerite.entity.Empresa;

public interface EmpresaService {
	
	public Empresa salvar(Empresa empresa);
	public List<Empresa> listar();
	public void deleteById(Long id);
	public Empresa updateEmpresa(Empresa empresa);

}
