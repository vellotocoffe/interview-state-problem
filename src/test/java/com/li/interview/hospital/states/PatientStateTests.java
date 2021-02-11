package com.li.interview.hospital.states;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;
import com.li.interview.hospital.states.PatientState;

public class PatientStateTests {

	@Test
	public void shouldBeDead_whenDiabetesAndNoInProvided() {
		// given
		PatientState dState = PatientState.getInstance("D");
		List<Drugs> drugs = new ArrayList<>();
		// then
		assertTrue(dState.toDead(drugs));
	}

	@Test
	public void shouldNotBeCurved_whenDiabetes() {
		// given
		PatientState dState = PatientState.getInstance("D");
		// then
		Stream.of(Drugs.values()).forEach(drug -> {
			assertFalse(dState.toHealthy(Arrays.asList(drug)));
		});

	}

	@Test
	public void shouldBeFever_whenBothInAndAnProvided() {
		// given
		PatientState dState = PatientState.getInstance("H");
		List<Drugs> drugs = Arrays.asList(Drugs.I, Drugs.An);
		// then
		assertTrue(dState.toFever(drugs));
	}

	@Test
	public void shouldBeDead_whenBothPAndAsProvided() {
		// given
		List<Drugs> drugs = Arrays.asList(Drugs.P, Drugs.As);
		// then
		Stream.of(PatientStateConst.values()).forEach(stateConst -> {
			PatientState dState = PatientState.getInstance(stateConst.toString());
			assertTrue(dState.toDead(drugs));
		});
	}

}
