package com.leo.dio.santander.backlineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.dio.santander.backlineapi.dto.NovoCorrentista;
import com.leo.dio.santander.backlineapi.model.Correntista;
import com.leo.dio.santander.backlineapi.repository.CorrentistaRepository;
import com.leo.dio.santander.backlineapi.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;

	@GetMapping
	public List<Correntista> findaAll() {
		return repository.findAll();
	}

	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}
}
