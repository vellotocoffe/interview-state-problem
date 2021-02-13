package com.li.interview.hospital;

import java.util.List;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

import lombok.Data;

@Data
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

}
