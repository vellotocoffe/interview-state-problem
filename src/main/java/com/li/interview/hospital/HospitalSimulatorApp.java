package com.li.interview.hospital;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * New version based on rules engine design-pattern.
 * @author Hao
 */
public class HospitalSimulatorApp {

	public static void main(String[] args) {
		if (args.length < 1) {
			throw new IllegalArgumentException("please provide args.");
		}
		String patientsList = args[0];
		String drugsList = args.length < 2 ? "" : args[1];
		List<Drugs> drugs = Drugs.toList(drugsList);
		List<PatientStateConst> states = PatientStateConst.toList(patientsList);
		HispitalRulesEngine.calculatePatientState(states, drugs);
	}

}
