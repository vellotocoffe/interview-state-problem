package com.li.interview.hospital.enums;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PatientStateConst {
	F("Fever"), D("Diabetes"), T("Tuberculosis"), X("Dead"), H("Healthy");

	private String fullName;

	private PatientStateConst(String fullName) {
		this.fullName = fullName;
	}

	public static List<PatientStateConst> toList(String statesStr) {
		if (statesStr.isEmpty()) {
			return Collections.<PatientStateConst>emptyList();
		} else {
			return Stream.of(statesStr.split(",")).map(state -> PatientStateConst.valueOf(state)).collect(Collectors.toList());
		}

	}

}
