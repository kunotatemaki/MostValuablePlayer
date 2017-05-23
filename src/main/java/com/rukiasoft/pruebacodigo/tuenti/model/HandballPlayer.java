package com.rukiasoft.pruebacodigo.tuenti.model;

import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public class HandballPlayer extends Player {

	private Integer goalsMade;
	private Integer goalsReceived;
	
	public HandballPlayer() {
		super();
	}
	
	@Override
	public void setStats(String stats)  throws TuentiException {
		super.setStats(stats);
		//split stats and save values
		String[] info = stats.split(";");
		try {
			goalsMade = Integer.valueOf(info[5]);
			goalsReceived = Integer.valueOf(info[6]);
			
			//calculate mvp points (without victory)
			calculateMvpPoints();
			
		}catch(NumberFormatException e) {
			TuentiException.throwTuentiException("formáto de número no válido en basketPlayer", e.getStackTrace());
		}catch(IndexOutOfBoundsException e) {
			TuentiException.throwTuentiException("se han recibido menos parámetros de los esperados", e.getStackTrace());
		}catch(Exception e) {
			TuentiException.throwTuentiException("error indeterminado", e.getStackTrace());
		}
	}
	
	@Override
	public void calculateMvpPoints() throws TuentiException {
		mvpPoints =
				HandballPoints.getInitialPoints(position) + 
				goalsMade * HandballPoints.getPointsFromGoalsMade(position) +
				goalsReceived * HandballPoints.getPointsFromGoalsReceived(position)
			;
	}

	@Override
	public int getPointsForWinningTheMatch() {
		
		return goalsMade;
	}
	
	
}
