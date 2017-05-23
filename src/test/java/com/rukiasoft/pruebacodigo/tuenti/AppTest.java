package com.rukiasoft.pruebacodigo.tuenti;

import com.rukiasoft.pruebacodigo.tuenti.model.BasketPlayer;
import com.rukiasoft.pruebacodigo.tuenti.model.HandballPlayer;
import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBasketNoWinner()
    {
    	try {
	    	BasketPlayer player = new BasketPlayer();
	        player.setStats("player 1;nick1;4;Team A;C;10;5;0");
	        assertTrue(player.getMvpPoints(false) == 25);
    	}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        
    }
    public void testHandballNoWinner()
    {
    	HandballPlayer player = new HandballPlayer();
    	try {
		    player.setStats("player 1;nick1;4;Team A;G;1;10");
			assertTrue(player.getMvpPoints(false) == 35);
		}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
    public void testBasketWinner()
    {
    	try {
	    	BasketPlayer player = new BasketPlayer();
	        player.setStats("player 1;nick1;4;Team A;C;10;5;0");
	        assertTrue(player.getMvpPoints(true) == 35);
    	}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        
    }
    public void testHandballWinner()
    {
    	HandballPlayer player = new HandballPlayer();
    	try {
		    player.setStats("player 1;nick1;4;Team A;G;1;10");
			assertTrue(player.getMvpPoints(true) == 45);
		}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
    public void testBasketBadFormat()
    {
    	try {
	    	BasketPlayer player = new BasketPlayer();
	        player.setStats("player 1;nick1;4;Team A;C;10;5");
	        assertTrue(false);
    	}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertTrue(true);
		}
        
    }
    public void testHandballBadFormat()
    {
    	HandballPlayer player = new HandballPlayer();
    	try {
		    player.setStats("player 1;nick1;4;Team A;G;XXXXX;10");
			assertTrue(false);
		}catch(TuentiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			assertTrue(true);
		}
    }
}
