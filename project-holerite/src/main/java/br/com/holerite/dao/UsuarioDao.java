package br.com.holerite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.holerite.entity.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	@Query("select a from Usuario a")
	public List<Usuario> listar();
	
	@Query("select a from Usuario a")
	public void deleteById();
	
}
