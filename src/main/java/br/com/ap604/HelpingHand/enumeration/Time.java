package br.com.ap604.HelpingHand.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Time {

	VALOR("time.valor"), MYSTIC("time.mystic"), INSTINCT("time.instinct");

	private String					label;
	private static List<Time>	enumerations	= new ArrayList<Time>();

	private Time(String label) {
		this.label = label;
	}

	public String getValue() {
		return this.name();
	}

	public String getlabel() {
		return this.label;
	}

	public static List<Time> enumerations() {
		return enumerations;
	}

	static {
		for (Time prioridade : Time.values()) {
				enumerations.add(prioridade);
		}
	}
}
