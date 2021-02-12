package com.li.interview.hospital.rules;

import java.util.List;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

public abstract class CalculatePatientSateRule {

	public abstract void caculateState(Patient patient);
	public abstract Boolean isRuleActive(List<Drugs> list);
	public void executeRule(Patient patient) {
		if(!patient.isInState(PatientStateConst.X)) {
			caculateState(patient);
		}
	}
}
