package com.generation.ljgames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ljgames.model.ProdutoModel;
import com.generation.ljgames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<ProdutoModel> GetById(@PathVariable Long id){
		 return repository.findById(id)
				 .map(resp -> ResponseEntity.ok(resp))
				 .orElse(ResponseEntity.notFound().build());
}
	 @GetMapping("/nome/{nome}")
	 public ResponseEntity<List<ProdutoModel>> GetByNome(@PathVariable String nome){
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	 }
}
