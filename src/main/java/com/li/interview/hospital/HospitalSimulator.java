package com.li.interview.hospital;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.li.interview.hospital.enums.Drugs;
import com.li.interview.hospital.enums.PatientStateConst;
import com.li.interview.hospital.states.PatientState;

public class HospitalSimulator {

	private final Map<PatientStateConst, Long> statesResult = new HashMap<>();

	private static final Map<PatientStateConst, String> stateCheckingNameMapping = new HashMap<>();
	static {
		stateCheckingNameMapping.put(PatientStateConst.F, "toFever");
		stateCheckingNameMapping.put(PatientStateConst.D, "toDiabetes");
		stateCheckingNameMapping.put(PatientStateConst.T, "toTuberculosis");
		stateCheckingNameMapping.put(PatientStateConst.X, "toDead");
		stateCheckingNameMapping.put(PatientStateConst.H, "toHealthy");
	}

	/**
	 * find next possible state.
	 * see {@link HospitalSimulatorApp} for more details.
	 * @param currentState current patient state.
	 * @param a drugs list be provided to patient.
	 * @return next possible state constant.
	 */
	public PatientStateConst findNextState(PatientState currentState, List<Drugs> drugsList) {
		PatientStateConst nextState = Stream.of(PatientStateConst.values())
				.sorted(Comparator.comparing(PatientStateConst::getSeverityOrder).reversed()).filter(stateConst -> {
					Boolean result = false;
					try {
						result = (Boolean) currentState.getClass()
								.getDeclaredMethod(stateCheckingNameMapping.get(stateConst), List.class)
								.invoke(currentState, drugsList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return result;
				}).findFirst().orElse(currentState.getCurrentState());
		return nextState;
	}

	public void simulate(List<Drugs> drugs, List<PatientState> patients) {
		Map<PatientStateConst, Long> computed = patients.stream()
				.collect(Collectors.groupingBy(patient -> findNextState(patient, drugs), Collectors.counting()));
		Stream.of(PatientStateConst.values()).forEach(state -> {
			Long counter = computed.get(state);
			statesResult.put(state, counter == null ? 0 : counter);
		});
	}

	public void printResult() {
		System.out.println(statesResult);
	}

}
