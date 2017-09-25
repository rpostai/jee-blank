package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.TestEntity;
import br.com.rp.repository.TestEntityRepository;

@Stateless
public class TestEntityRepositoryImpl extends AbstractRepositoryImpl<TestEntity> implements TestEntityRepository {

	public TestEntityRepositoryImpl() {
		super(TestEntity.class);
	}
}
