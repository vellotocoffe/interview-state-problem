package com.li.interview.hospital.rules;

import java.util.List;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

public class ParaMixAspirinRule extends CalculatePatientSateRule {

	@Override
	public void caculateState(Patient patient) {
		patient.setCurrentState(PatientStateConst.X);
	}

	@Override
	public Boolean isRuleActive(List<Drugs> list) {
		return list.contains(Drugs.P) && list.contains(Drugs.As);
	}

}
