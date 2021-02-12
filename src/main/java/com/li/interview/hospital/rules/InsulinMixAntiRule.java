package com.li.interview.hospital.rules;

import java.util.List;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

public class InsulinMixAntiRule extends CalculatePatientSateRule {

	@Override
	public void caculateState(Patient patient) {
		if (patient.isInState(PatientStateConst.H)) {
			patient.setCurrentState(PatientStateConst.F);
		}
	}

	@Override
	public Boolean isRuleActive(List<Drugs> list) {
		return list.contains(Drugs.I) && list.contains(Drugs.An);
	}

}
