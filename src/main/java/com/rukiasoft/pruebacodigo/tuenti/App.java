package com.rukiasoft.pruebacodigo.tuenti;

import com.rukiasoft.pruebacodigo.tuenti.io.IoMethods;
import com.rukiasoft.pruebacodigo.tuenti.model.BasketPlayer;
import com.rukiasoft.pruebacodigo.tuenti.model.HandballPlayer;
import com.rukiasoft.pruebacodigo.tuenti.utils.TuentiException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        
        IoMethods ioMethods = new IoMethods();
        //simulo leer dos ficheros
        //esto iría en un bucle o similar que fuera llamando a la función pasándo el path del fichero correspondiente
        //como se explica en el cuerpo de la función, en vez de paths, envío el contenido del fichero separado por |
        ioMethods.readFile("BASKETBALL|player 1;nick1;4;Team A;G;10;2;7|player 2;nick2;8;Team A;F;0;10;0|player 3;nick3;15;Team A;C;15;10;4|player 4;nick4;16;Team B;G;20;0;0|player 5;nick5;23;Team B;F;4;7;7|player 6;nick6;42;Team B;C;8;10;0");
        
        ioMethods.readFile("HANDBALL|player 1;nick1;4;Team A;G;0;20|player 2;nick2;8;Team A;F;25;20|player 3;nick3;15;Team A;F;10;20|player 4;nick4;16;Team B;G;1;25|player 5;nick5;23;Team B;F;12;25|player 6;nick6;42;Team B;F;8;25");
        
        //obtener el mvp
        System.out.println("El MVP es: " + ioMethods.getMvp());
        
        
        }catch(TuentiException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }

    }
}
