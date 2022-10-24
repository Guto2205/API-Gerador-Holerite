package br.com.holerite.service;

import java.util.List;

import br.com.holerite.entity.Usuario;


public interface UsuarioService {

	public Usuario salvar(Usuario usuario);
	public List<Usuario> listar();
	public void deleteById(Long id);
	public Usuario updateUsuario(Usuario usuario);
	

}
