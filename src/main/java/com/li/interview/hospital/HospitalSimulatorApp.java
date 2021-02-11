package com.li.interview.hospital;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.states.PatientState;

/**
 * Different states could co-exist, but there is no specific requirement for
 * this point. So i consider that a patient only has one state at a given time.
 * <p>
 * The algorithm is based on state severity, the checking starts from most "grave" states
 * Dead -> Diabetes -> Tuberculosis -> Fever -> Healthy
 * <p>
 * There are three possible state transition : 
 * A patient can move to a more grave state.
 * A patient can still be in same state.
 * A patient can move to a less grave state if current state can be curved firstly.
 * <p> 
 * For example, a diabetes patient receives I and An, as diabetes is more sever
 * than Fever, so he will still be in diabetes state. 
 * other example, a Tuberculosis received An,As,I, he can be curved by An, but due to I, he will be fever finally.
 * 
 * @author Hao
 */
public class HospitalSimulatorApp {

	private static HospitalSimulator simulator = new HospitalSimulator();
	
	public static void main(String[] args) {
		if (args.length < 1) {
			throw new IllegalArgumentException("please provide args.");
		}
		String patientsList = args[0];
		String drugsList = args.length < 2 ? "" : args[1];
		List<Drugs> drugs = Drugs.toList(drugsList);
		List<PatientState> patients = PatientState.toList(patientsList);
		simulator.simulate(drugs, patients);
		simulator.printResult();
	}

}
