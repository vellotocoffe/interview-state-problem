package com.li.interview.hospital.rules;

import java.util.List;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

@PatientStateRule
public class InsulinPreventDeadRule extends CalculatePatientSateRule {

	@Override
	public void caculateState(Patient patient) {
		if (patient.isInState(PatientStateConst.D) ) {
			patient.setCurrentState(PatientStateConst.X);
		}
	}

	@Override
	public Boolean isRuleActive(List<Drugs> list) {
		return !list.contains(Drugs.I);
	}

}
