package br.com.holerite.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.holerite.dto.UsuarioDTO;
import br.com.holerite.entity.Usuario;
import br.com.holerite.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("holerite/Usuario")
@Slf4j
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("listar")
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> listaUsuario = this.usuarioService.listar();
		log.info("Operaction End");
		return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
	}
	
	@PostMapping("salvar")
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody 	UsuarioDTO usuarioDTO, @Context HttpServletRequest request) {
		Usuario usuario = new Usuario();
		
		usuario.setFuncionario(usuarioDTO.getFuncionario());
		usuario.setMes(usuarioDTO.getMes());
		usuario.setSalario(usuarioDTO.getSalario());
		usuario.setDesconto(usuarioDTO.getDesconto());
		usuario.setSalarioliquido(usuarioDTO.getSalarioliquido());
		usuario.setMatricula(usuarioDTO.getMatricula());
		usuario.setCargo(usuarioDTO.getCargo());
		usuario.setEmpresa(usuario.getEmpresa());
		
		
		usuario = usuarioService.salvar(usuario);
		log.info("Fim da operação salvar Usuario");
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	
	}
	
	@DeleteMapping("deletar/{id}")
	public void deleteUsuarioById(@PathVariable ("id")Long id) {
		
		usuarioService.deleteById(id);
		
	}
	
	@PutMapping("atualizar")
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuario);
	}
	
	
	
}
