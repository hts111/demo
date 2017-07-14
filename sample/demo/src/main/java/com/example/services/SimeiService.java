package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.SimeiRepository;
import com.example.entity.Simei;

@Service
@Transactional
public class SimeiService {

	@Autowired
	SimeiRepository repository;

	@Transactional(readOnly = true, timeout = 10)
	public List<Simei> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true, timeout = 10)
	public Simei find(final Long id) {
		return repository.findOne(id);
	}

	@Transactional(rollbackFor = {Exception.class}, timeout = 3)
	public Simei save(final Simei simei) {
		return repository.save(simei);
	}

	@Transactional(rollbackFor = {Exception.class}, timeout = 3)
	public void delete(final Long id) {
		repository.delete(id);
	}
}