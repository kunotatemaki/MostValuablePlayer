package com.rukiasoft.pruebacodigo.tuenti.model;

import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public abstract class Player {
	protected String sportName;
	protected String playerName;
	protected String nickname;
	protected Integer number;
	protected String teamName;
	protected String position;
	protected Integer mvpPoints;
	
	public Player() {
		super();
	}

	public Integer getMvpPoints(Boolean winner) {
		if(winner) {
			return 10 + mvpPoints;
		}else {
			return mvpPoints;
		}
	}

	public void setStats(String stats) throws TuentiException{
		//split stats and save values
		String[] info = stats.split(";");
		
		try {
			playerName = info[0];
			nickname = info[1];
			number = Integer.valueOf(info[2]);
			teamName = info[3];
			position = info[4];
			
		}catch(NumberFormatException e) {
			TuentiException.throwTuentiException("formáto de número no válido en basketPlayer", e.getStackTrace());
		}catch(IndexOutOfBoundsException e) {
			TuentiException.throwTuentiException("se han recibido menos parámetros de los esperados", e.getStackTrace());
		}catch(Exception e) {
			TuentiException.throwTuentiException("error indeterminado", e.getStackTrace());
		}
	}
	
	abstract void calculateMvpPoints() throws TuentiException;
	
	public abstract int getPointsForWinningTheMatch();

	public String getNickname() {
		return nickname;
	}

	public String getTeamName() {
		return teamName;
	}
}
