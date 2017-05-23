package com.rukiasoft.pruebacodigo.tuenti.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.rukiasoft.pruebacodigo.tuenti.model.BasketPlayer;
import com.rukiasoft.pruebacodigo.tuenti.model.HandballPlayer;
import com.rukiasoft.pruebacodigo.tuenti.model.Player;
import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

public class IoMethods {
	
	private final static String BASKETBALL = "BASKETBALL";
	private final static String HANDBALL = "HANDBALL";
	Map<String, Integer> mvpList = new HashMap<String, Integer>();
	
	public void readFile(String file) throws TuentiException {
		//esta función recibiría el path de un fichero y lo leería, pero para simplificar, lo que va a recibir es un string
		//con el contenido del fichero, de tal forma que cada línea está separada de otra por "|"
		String[] content = file.split("\\|"); 
		if(content == null || content.length == 0 || 
				(!content[0].equals(BASKETBALL) && !content[0].equals(HANDBALL))) {
			TuentiException.throwTuentiException("error en el formato del fichero");
		}
		
		List<Player> list = new ArrayList<>();
		Map<String, Integer> winner = new HashMap<String, Integer>();
		for(int i=1; i<content.length; i++) {
			Player player = null;
			switch (content[0]) {
			case BASKETBALL:
				player = new BasketPlayer();
				break;
			case HANDBALL:
				player = new HandballPlayer();
				break;
			default:
				TuentiException.throwTuentiException("error en el nombre del deporte");
				break;
			}
			
			player.setStats( content[i]);
			list.add(player);
			if(winner.containsKey(player.getTeamName())) {
				int win = winner.get(player.getTeamName());
				winner.put(player.getTeamName(), win + player.getPointsForWinningTheMatch());
			}else {
				winner.put(player.getTeamName(), player.getPointsForWinningTheMatch());
			}
		}
		//si no hay justo dos equipos es que los datos están mal introducidos
		if(winner.size() != 2) {
			TuentiException.throwTuentiException("número erróneo de equipos");
		}
		String teamWinner = getMaxValueNameFromMap(winner);
		
		for(Player lPlayer : list) {
			int mvpPoints = 0;
			if(mvpList.containsKey(lPlayer.getNickname())) {
				mvpPoints = mvpList.get(lPlayer.getNickname());
			}
			mvpList.put(lPlayer.getNickname(), mvpPoints + lPlayer.getMvpPoints(lPlayer.getTeamName().equals(teamWinner)));
		}
		
	}
	
	public String getMvp() {
		return getMaxValueNameFromMap(mvpList);
	}
	
	private String getMaxValueNameFromMap(Map<String, Integer> map) {
		
		String maxKey = "";
		int maxValue = -1;
		final Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
		
			String key = it.next(); //en n tenemos la clave
			int points = map.get(key);
			if(points > maxValue) {
				maxKey = key;
				maxValue = points;
			}
		}
		return maxKey;
	}
	
}