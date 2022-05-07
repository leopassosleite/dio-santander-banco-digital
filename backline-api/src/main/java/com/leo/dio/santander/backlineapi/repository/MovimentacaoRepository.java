package com.leo.dio.santander.backlineapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.dio.santander.backlineapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

	public List<Movimentacao>findByIdConta(Integer idConta);
}
