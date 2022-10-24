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

import br.com.holerite.dto.EmpresaDTO;
import br.com.holerite.entity.Empresa;
import br.com.holerite.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("holerite/Empresa")
@Slf4j
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	// listando usuarios
	@GetMapping("listar")
	public ResponseEntity<List<Empresa>> listar() {
		List<Empresa> listaEmpresa = this.empresaService.listar();
		log.info("Operaction End");
		return new ResponseEntity<>(listaEmpresa, HttpStatus.OK);
	}
	// savando dados da empresa
	@PostMapping("salvar")
	public ResponseEntity<Empresa> salvar(@Valid @RequestBody 	EmpresaDTO empresaDTO, @Context HttpServletRequest request) {
		Empresa empresa = new Empresa();
		
		empresa.setNome(empresaDTO.getNome());
		empresa.setCep(empresaDTO.getCep());
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setCidade(empresaDTO.getCidade());
		empresa.setEndereco(empresaDTO.getEndereco());
		empresa.setTelefone(empresaDTO.getTelefone());
		empresa.setEstado(empresaDTO.getEstado());
		empresa.setUsuarios(empresa.getUsuarios());
		
		empresa = empresaService.salvar(empresa);
		log.info("Fim da operação salvar empresa");
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	
	}
	// deletando uma empresa
	@DeleteMapping("deletar/{id}")
	public void deleteempresaById(@PathVariable ("id")Long id) {
		
		empresaService.deleteById(id);
		
	}
	// atualizando dados da empresa
	@PutMapping("atualizar")
	public Empresa updateempresa(@RequestBody Empresa empresa) {
		return empresaService.updateEmpresa(empresa);
	}
	

}
