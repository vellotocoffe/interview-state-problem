package com.li.interview.hospital.states;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;

/**
 * All implementation classes are immutable.
 * <p>
 * {@link FeverState} {@link HealthyState} {@link DiabetesState}
 * {@link TuberculosisState} {@link DeadState}
 * 
 * @author Hao LI
 */
public abstract class PatientState {
	
	public boolean toFever(List<Drugs> drugsList) {
		return drugsList.contains(Drugs.I) && drugsList.contains(Drugs.An);
	}
	
	public boolean toDead(List<Drugs> drugsList) {
		return drugsList.contains(Drugs.As) && drugsList.contains(Drugs.P);
	}
	
	abstract public PatientStateConst getCurrentState();

	abstract public boolean toHealthy(List<Drugs> drugsList);

	abstract public boolean toTuberculosis(List<Drugs> drugsList);

	abstract public boolean toDiabetes(List<Drugs> drugsList);
	

	public static List<PatientState> toList(String labels) {
		if (labels.isEmpty()) {
			return Collections.<PatientState>emptyList();
		} else {
			return Stream.of(labels.split(",")).map(label -> getInstance(label)).collect(Collectors.toList());
		}
	}
	
	/*
	 * A factory method for creating PatientState instance.
	 * */
	public static PatientState getInstance(String label) {
		switch (PatientStateConst.valueOf(label)) {
		case F:
			return new FeverState();
		case D:
			return new DiabetesState();
		case T:
			return new TuberculosisState();
		case X:
			return new DeadState();
		default:
			return new HealthyState();
		}
	}

}
