package br.com.rp.repository;

import java.util.List;

import br.com.rp.domain.Pessoa;

public interface PessoaRepository extends Repository<Pessoa> {
	
	List<Pessoa> findPessoaPorNome(String nome);

}
