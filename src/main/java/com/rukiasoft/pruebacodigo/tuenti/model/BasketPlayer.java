package com.rukiasoft.pruebacodigo.tuenti.model;

import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public class BasketPlayer extends Player {

	private Integer scoredPoints;
	private Integer rebounds;
	private Integer assists;
	

	public BasketPlayer() {
		super();
	}
	
	@Override
	public void setStats(String stats) throws TuentiException{
		super.setStats(stats);
		
		//split stats and save values
		String[] info = stats.split(";");
		
		try {
			scoredPoints = Integer.valueOf(info[5]);
			rebounds = Integer.valueOf(info[6]);
			assists = Integer.valueOf(info[7]);
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
				scoredPoints * BasketPoints.getPointsFromScoredPoints(position) + 
				rebounds * BasketPoints.getPointsFromRebounds(position) +
				assists * BasketPoints.getPointsFromAssists(position)
			;
	}

	@Override
	public int getPointsForWinningTheMatch() {
		return scoredPoints;
	}

	
}
