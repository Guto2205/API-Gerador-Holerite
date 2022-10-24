package br.com.holerite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.holerite.dao.EmpresaDao;
import br.com.holerite.entity.Empresa;
import br.com.holerite.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	EmpresaDao empresaDao;
	
	@Override
	public Empresa salvar(Empresa empresa) {
		return empresaDao.save(empresa);
	}

	@Override
	public List<Empresa> listar() {
		return empresaDao.listar();
	}

	@Override
	public void deleteById(Long id) {
		empresaDao.deleteById(id);
	}

	@Override
	public Empresa updateEmpresa(Empresa empresa) {
		return salvar(empresa);
	}
	
	
	

}
