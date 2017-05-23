package com.rukiasoft.pruebacodigo.tuenti.model;

import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public class HandballPoints {

	private static String GOALKEEPER = "G";
	private static String FIELDPLAYER = "F";

	public static Integer getInitialPoints(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		if(GOALKEEPER.equals(position)) {
			return 50;
		}else if (FIELDPLAYER.equals(position)) {
			return 20;
		}else {
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
	}

	public static Integer getPointsFromGoalsMade(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		if(GOALKEEPER.equals(position)) {
			return 5;
		}else if (FIELDPLAYER.equals(position)) {
			return 1;
		}else {
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
	}

	public static Integer getPointsFromGoalsReceived(String position) throws TuentiException {
		if(position == null || position.isEmpty()) {
			TuentiException.throwTuentiException("Posición desconocida");
		}
		if(GOALKEEPER.equals(position)) {
			return -2;
		}else if (FIELDPLAYER.equals(position)) {
			return -1;
		}else {
			TuentiException.throwTuentiException("Posición desconocida");
			return 0;
		}
	}
	
	
	
	
}

/*					Initial rating points 	Goal made 	Goal received
Goalkeeper (G) 		50 						5 			-2
Field player (F) 	20 						1 			-1*/
