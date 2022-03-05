package com.one.FirstProject.Entity;

import org.springframework.stereotype.Component;

@Component
public class LogicClass {
	
	private State state;
	
	private District district;

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return "LogicClass [state=" + state + ", district=" + district + "]";
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}
