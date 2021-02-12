package com.li.interview.hospital;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;
import com.li.interview.hospital.rules.AntibioticCurTuberRule;
import com.li.interview.hospital.rules.AspirinCurveFeverRule;
import com.li.interview.hospital.rules.CalculatePatientSateRule;
import com.li.interview.hospital.rules.InsulinMixAntiRule;
import com.li.interview.hospital.rules.InsulinPreventDeadRule;
import com.li.interview.hospital.rules.ParaMixAspirinRule;
import com.li.interview.hospital.rules.ParacetamolCurFeverRule;

public class HispitalRulesEngine {

	private static final Map<PatientStateConst, Long> PRINT_TEMPLATE = new LinkedHashMap<>();

	static {
		PRINT_TEMPLATE.put(PatientStateConst.F, 0L);
		PRINT_TEMPLATE.put(PatientStateConst.H, 0L);
		PRINT_TEMPLATE.put(PatientStateConst.D, 0L);
		PRINT_TEMPLATE.put(PatientStateConst.T, 0L);
		PRINT_TEMPLATE.put(PatientStateConst.X, 0L);
	}

	public static List<CalculatePatientSateRule> buildRules(List<Drugs> drugsList) {

		return Stream
				.of(new AntibioticCurTuberRule(), new AspirinCurveFeverRule(), new InsulinMixAntiRule(),
						new InsulinPreventDeadRule(), new ParacetamolCurFeverRule(), new ParaMixAspirinRule())
				.filter(rule -> rule.isRuleActive(drugsList)).collect(Collectors.toList());

	}

	public static void calculatePatientState(List<PatientStateConst> states, List<Drugs> drugsList) {
		List<Patient> patients = states.stream().map(state -> new Patient(state, drugsList))
				.collect(Collectors.toList());

		List<CalculatePatientSateRule> ruleList = buildRules(drugsList);
		patients.forEach(patient -> {
			ruleList.forEach(rule -> {
				rule.executeRule(patient);
			});
		});

		patients.stream().collect(Collectors.groupingBy(Patient::getCurrentState, Collectors.counting())).entrySet()
				.forEach(entry -> PRINT_TEMPLATE.put(entry.getKey(), entry.getValue()));
		System.out.println(PRINT_TEMPLATE);
	}

}
