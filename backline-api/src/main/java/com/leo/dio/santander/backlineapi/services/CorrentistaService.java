package com.leo.dio.santander.backlineapi.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.dio.santander.backlineapi.dto.NovoCorrentista;
import com.leo.dio.santander.backlineapi.model.Conta;
import com.leo.dio.santander.backlineapi.model.Correntista;
import com.leo.dio.santander.backlineapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {

	@Autowired
	private CorrentistaRepository repository;

	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentista.getCpf());
		correntista.setNome(novoCorrentista.getNome());

		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());

		correntista.setConta(conta);
		repository.save(correntista);
	}
}
