package br.com.holerite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.holerite.entity.Empresa;

public interface EmpresaDao extends JpaRepository<Empresa, Long> {
	
	@Query("select a from Empresa a")
	public List<Empresa> listar();
	
	@Query("select a from Empresa a")
	public void deleteById();

}
