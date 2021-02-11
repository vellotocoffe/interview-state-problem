package com.li.interview.hospital.states;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * Fever state.
 * <p>
 * Can move to {@link HealthyState} or {@link DeadState} under certain
 * conditions.
 * 
 * @author Hao LI
 */
public class FeverState extends PatientState {

	private final PatientStateConst state = PatientStateConst.F;

	@Override
	public boolean toDead(List<Drugs> drugsList) {
		return super.toDead(drugsList);
	}

	@Override
	public boolean toFever(List<Drugs> drugsList) {
		return super.toFever(drugsList);
	}

	@Override
	public boolean toHealthy(List<Drugs> drugsList) {
		return drugsList.contains(Drugs.As) || drugsList.contains(Drugs.P);
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
