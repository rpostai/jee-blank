package br.com.rp.repository.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import br.com.rp.domain.Estado;
import br.com.rp.repository.EstadoRepository;

@Stateless
public class EstadoRepositoryImpl implements EstadoRepository {

	public List<Estado> getEstados() {
		try {
			List<String> estados = Files.readAllLines(Paths.get("d:/rpostai/estados.txt"));
			return estados.stream().map(linha -> {
				String[] estado = linha.split(";");
				Estado e = new Estado();
				e.setSigla(estado[0]);
				e.setNome(estado[1]);
				return e;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("Arquivo de estados nao encontrado");
		}

	}

}
