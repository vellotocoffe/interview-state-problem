package com.li.interview.hospital.states;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.li.interview.hospital.Patient;
import com.li.interview.hospital.enums.PatientStateConst;
import com.li.interview.hospital.rules.AntibioticCurTuberRule;
import com.li.interview.hospital.rules.AspirinCurveFeverRule;
import com.li.interview.hospital.rules.CalculatePatientSateRule;
import com.li.interview.hospital.rules.InsulinMixAntiRule;
import com.li.interview.hospital.rules.InsulinPreventDeadRule;
import com.li.interview.hospital.rules.ParaMixAspirinRule;
import com.li.interview.hospital.rules.ParacetamolCurFeverRule;

public class PatientStateTests {

	@Test
	public void testWhenPatientIsDead() {
		Patient patient = new Patient(PatientStateConst.X);
		Stream.of(new AntibioticCurTuberRule(), new AspirinCurveFeverRule(), new InsulinMixAntiRule(),
				new InsulinPreventDeadRule(), new ParacetamolCurFeverRule(), new ParaMixAspirinRule()).forEach(rule -> {
					rule.caculateState(patient);
					assertTrue(patient.getCurrentState().equals(PatientStateConst.X));
				});
	}

	@Test
	public void testAntibioticCurTuberRule() {
		Patient patient = new Patient(PatientStateConst.T);
		CalculatePatientSateRule rule = new AntibioticCurTuberRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.H));
	}

	@Test
	public void testAspirinCurveFeverRule() {
		Patient patient = new Patient(PatientStateConst.F);
		CalculatePatientSateRule rule = new AspirinCurveFeverRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.H));
	}

	@Test
	public void testInsulinMixAntiRule() {
		Patient patient = new Patient(PatientStateConst.H);
		CalculatePatientSateRule rule = new InsulinMixAntiRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.F));
	}

	@Test
	public void testParacetamolCurFeverRule() {
		Patient patient = new Patient(PatientStateConst.F);
		CalculatePatientSateRule rule = new ParacetamolCurFeverRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.H));
	}

	@Test
	public void testParaMixAspirinRule() {
		Patient patient = new Patient(PatientStateConst.F);
		CalculatePatientSateRule rule = new ParaMixAspirinRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.X));
	}

	@Test
	public void testInsulinPreventDeadRule() {
		Patient patient = new Patient(PatientStateConst.D);
		CalculatePatientSateRule rule = new InsulinPreventDeadRule();
		rule.executeRule(patient);
		assertTrue(patient.getCurrentState().equals(PatientStateConst.X));
	}

}
