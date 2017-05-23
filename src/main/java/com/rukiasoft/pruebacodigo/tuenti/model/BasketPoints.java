package com.rukiasoft.pruebacodigo.tuenti.model;

import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public class BasketPoints {
	
	private static final String GUARD = "G";
	private static final String FORWARD = "F";
	private static final String CENTER = "C";

	public static Integer getPointsFromScoredPoints(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		switch (position) {
		case GUARD:
			return 2;
		case FORWARD:
			return 2;
		case CENTER:
			return 2;
		default:
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
		
	}

	public static Integer getPointsFromRebounds(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		if(GUARD.equals(position)) {
			return 3;
		}else if (FORWARD.equals(position)) {
			return 2;
		}else if(CENTER.equals(position)) {
			return 1;
		}else {
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
	}

	public static Integer getPointsFromAssists(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		if(GUARD.equals(position)) {
			return 1;
		}else if (FORWARD.equals(position)) {
			return 2;
		}else if(CENTER.equals(position)) {
			return 3;
		}else {
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
	}
	
	
}

/*Guard (G) 2 3 1
Forward (F) 2 2 2
Center (C) 2 1 3*/