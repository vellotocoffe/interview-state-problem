package com.li.interview.hospital.states;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * Tuberculosis state.
 * <p>
 * Can move to {@link FeverState}, {@link DeadState}, or {@link HealthyState}
 * under certain conditions.
 * 
 * @author Hao LI
 */
public class TuberculosisState extends PatientState {

	private final PatientStateConst state = PatientStateConst.T;

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
		return drugsList.contains(Drugs.An);
	}

	@Override
	public boolean toTuberculosis(List<Drugs> drugsList) {
		return !toHealthy(drugsList) && !toDead(drugsList);
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
