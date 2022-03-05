package com.one.FirstProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.FirstProject.Entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
	
	public State findByStateId(int id);
	
	
	

}
