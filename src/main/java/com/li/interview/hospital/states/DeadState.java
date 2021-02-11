package com.li.interview.hospital.states;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * Dead state.
 * <p>
 * Final state, no more transition is possible.
 *
 */
public class DeadState extends PatientState {

	private final PatientStateConst state = PatientStateConst.X;
	
	@Override
	public boolean toHealthy(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public boolean toFever(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public boolean toDead(List<Drugs> drugsList) {
		return true;
	}

	@Override
	public boolean toTuberculosis(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public boolean toDiabetes(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public PatientStateConst getCurrentState() {
		return state;
	}
}
