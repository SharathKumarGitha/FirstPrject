package com.one.FirstProject.Controller;

import java.util.List;
import java.util.Optional;

import com.one.FirstProject.Entity.District;
import com.one.FirstProject.Entity.LogicClass;
import com.one.FirstProject.Entity.State;
import com.one.FirstProject.Service.*;

import org.springframework.http.HttpHeaders;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.one.FirstProject.Service.StateService;

@Controller
public class StateController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StateService service;

	@GetMapping("/getTotal")
	@ResponseBody
	public ResponseEntity<List<State>> getTotal() {

		List<State> values = service.getTotalValues();

		if (values.size() >= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		else {
			return ResponseEntity.of(Optional.of(values));
		}

	}

	@PostMapping("/saveValues")
	@ResponseBody
	public ResponseEntity<State> saveState(@RequestBody State state) {

		State s1 = null;

		try {
			s1 = service.save(state);

			System.out.println(s1);

			return ResponseEntity.ok(s1);

		}

		catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/values/{id}")

	@ResponseBody

	public ResponseEntity<State> getById(@PathVariable("id") int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "StateController");

		State state = null;

		state = service.findByStateId(id);

		if (state == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		else {

			// return ResponseEntity.of(Optional.of(state));

			return ResponseEntity.accepted().headers(headers).body(state);
		}

	}

	@PutMapping("/updateState/{id}")
	@ResponseBody

	public State update(@RequestBody State state, @PathVariable("id") int id) {

		State s1 = null;

		s1 = service.findByStateId(id);

		if (s1 == null) {
			System.out.println("object is not there");
		}

		s1.setDistrictId(state.getDistrictId());
		s1.setStateId(id);

		s1.setStateName(state.getStateName());

		// System.out.println(s1.getDistrictId()+" "+s1.getStateName()+"
		// "+s1.getStateId());

		service.save(s1);

		return s1;

	}

	@GetMapping("/access/{id}")

	@ResponseBody

	public LogicClass getValues(@PathVariable("id") int id) {

		LogicClass class1 = new LogicClass();

		State state = service.findByStateId(id);

		District dist = null;

		dist = restTemplate.getForObject("http://localhost:9002/getDistrictValues/" + state.getDistrictId(),
				District.class);

		class1.setDistrict(dist);

		class1.setState(state);

		return class1;

	}

}
