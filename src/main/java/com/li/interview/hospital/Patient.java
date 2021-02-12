package com.li.interview.hospital;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

public class Patient {

	private PatientStateConst currentState;
	private List<Drugs> receivedDrugs;

	public Patient(PatientStateConst currentState, List<Drugs> receivedDrugs) {
		super();
		this.currentState = currentState;
		this.receivedDrugs = receivedDrugs;
	}
	
	public Patient(PatientStateConst currentState) {
		super();
		this.currentState = currentState;
	}

	public boolean isDrugUsed(Drugs drug) {
		return this.receivedDrugs.contains(drug);
	}

	public boolean isInState(PatientStateConst state) {
		return this.currentState.equals(state);
	}

	public PatientStateConst getCurrentState() {
		return currentState;
	}

	public void setCurrentState(PatientStateConst currentState) {
		this.currentState = currentState;
	}

	public List<Drugs> getReceivedDrugs() {
		return receivedDrugs;
	}

	public void setReceivedDrugs(List<Drugs> receivedDrugs) {
		this.receivedDrugs = receivedDrugs;
	}

}
