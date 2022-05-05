package com.leo.dio.santander.backlineapi.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.dio.santander.backlineapi.dto.NovaMovimentacao;
import com.leo.dio.santander.backlineapi.model.Correntista;
import com.leo.dio.santander.backlineapi.model.Movimentacao;
import com.leo.dio.santander.backlineapi.model.MovimentacaoTipo;
import com.leo.dio.santander.backlineapi.repository.CorrentistaRepository;
import com.leo.dio.santander.backlineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;

	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();

		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor()
				: novaMovimentacao.getValor() * -1;

		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista !=null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		movimentacaoRepository.save(movimentacao);
	}
}
