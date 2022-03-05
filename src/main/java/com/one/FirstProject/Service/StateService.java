package com.one.FirstProject.Service;

import com.one.FirstProject.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.FirstProject.Dao.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository repository;

	public List<State> getTotalValues() {

		List<State> list = new ArrayList<State>();

		list = repository.findAll();

		return list;

	}

	public State save(State s) {

		repository.save(s);
		return s;
	}

	public State findByStateId(int id) {

		State state = repository.findByStateId(id);

		return state;

	}

}
