package com.li.interview.hospital.enums;

public enum PatientStateConst {
	F("Fever", 2), D("Diabetes", 4), T("Tuberculosis", 3), X("Dead", 5), H("Healthy", 1);

	private String fullName;
	private Integer severityOrder;

	private PatientStateConst(String fullName, Integer severityOrder) {
		this.fullName = fullName;
		this.severityOrder = severityOrder;
	}

	public Integer getSeverityOrder() {
		return severityOrder;
	}

}
