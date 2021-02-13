package com.li.interview.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * New version based on rules engine design-pattern.
 * 
 * @author Hao
 */

@SpringBootApplication
public class HospitalSimulatorApp implements CommandLineRunner {

	@Autowired
	private HispitalRulesEngine rulesEngine;

	public static void main(String[] args) {
		SpringApplication.run(HospitalSimulatorApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 1) {
			throw new IllegalArgumentException("please provide args.");
		}
		String patientsList = args[0];
		String drugsList = args.length < 2 ? "" : args[1];
		List<Drugs> drugs = Drugs.toList(drugsList);
		List<PatientStateConst> states = PatientStateConst.toList(patientsList);
		rulesEngine.calculatePatientState(states, drugs);
	}

}
