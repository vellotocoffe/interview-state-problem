package com.li.interview.hospital.enums;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Drugs {

	As("Aspirin"), An("Antibiotic"), I("Insulin"), P("Paracetamol");

	@SuppressWarnings("unused")
	private String fullName;

	private Drugs(String fullName) {
		this.fullName = fullName;
	}

	public static List<Drugs> toList(String drugsStr) {
		if (drugsStr.isEmpty()) {
			return Collections.<Drugs>emptyList();
		} else {
			return Stream.of(drugsStr.split(",")).map(drug -> Drugs.valueOf(drug)).collect(Collectors.toList());
		}

	}
}
