package com.leo.dio.santander.backlineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.dio.santander.backlineapi.dto.NovaMovimentacao;
import com.leo.dio.santander.backlineapi.model.Movimentacao;
import com.leo.dio.santander.backlineapi.repository.MovimentacaoRepository;
import com.leo.dio.santander.backlineapi.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;

	@GetMapping
	public List<Movimentacao> findaAll() {
		return repository.findAll();
	}

	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}
}
