package com.li.interview.hospital.states;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * Diabetes state.
 * <p>
 * Can move to {@link FeverState} or {@link DeadState} under certain conditions.
 * 
 * @author Hao LI
 */
public class DiabetesState extends PatientState {

	private final PatientStateConst state = PatientStateConst.D;

	@Override
	public boolean toDead(List<Drugs> drugsList) {
		return !drugsList.contains(Drugs.I) || super.toDead(drugsList);
	}
	
	@Override
	public boolean toFever(List<Drugs> drugsList) {
		return super.toFever(drugsList);
	}

	@Override
	public boolean toDiabetes(List<Drugs> drugsList) {
		return !toDead(drugsList);
	}

	@Override
	public boolean toHealthy(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public boolean toTuberculosis(List<Drugs> drugsList) {
		return false;
	}

	@Override
	public PatientStateConst getCurrentState() {
		return state;
	}

}
