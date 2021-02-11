package com.li.interview.hospital.states;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * Healthy state.
 * <p>
 * Can move to {@link FeverState} or {@link DeadState} under certain conditions.
 * 
 * @author Hao LI
 */
public class HealthyState extends PatientState {

	private final PatientStateConst state = PatientStateConst.H;
	
	@Override
	public boolean toHealthy(List<Drugs> drugsList) {
		return false;
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
	public boolean toDead(List<Drugs> drugsList) {
		return super.toDead(drugsList);
	}
	
	@Override
	public boolean toFever(List<Drugs> drugsList) {
		return super.toFever(drugsList);
	}

	@Override
	public PatientStateConst getCurrentState() {
		return state;
	}

}
