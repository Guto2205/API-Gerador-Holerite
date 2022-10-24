package br.com.holerite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.holerite.dao.UsuarioDao;
import br.com.holerite.entity.Usuario;
import br.com.holerite.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public Usuario salvar(Usuario usuario) {
		usuario = usuarioDao.save(usuario);
		log.info("Persistindo LogAcesso id: " + usuario.getId());
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		return usuarioDao.listar();
	}

	@Override
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
		
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		
		return salvar(usuario);
	}
	

}
