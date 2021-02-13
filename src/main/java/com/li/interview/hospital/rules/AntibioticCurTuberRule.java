package com.li.interview.hospital.rules;

import java.util.List;

import org.springframework.stereotype.Service;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

@Service
public class AntibioticCurTuberRule extends CalculatePatientSateRule {

	@Override
	public void caculateState(Patient patient) {
		if (patient.isInState(PatientStateConst.T)) {
			patient.setCurrentState(PatientStateConst.H);
		}
	}
	
	@Override
	public Boolean isRuleActive(List<Drugs> list) {
		return list.contains(Drugs.An);
	}

}
