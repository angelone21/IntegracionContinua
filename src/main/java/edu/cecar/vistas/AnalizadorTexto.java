/**
 * Clase: AnalizadorTexto
 *
 * @version: 0.1
 *
 * @since: 24/08/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone Salgado
 *
 * Copyrigth: CECAR
 */
package edu.cecar.vistas;

import edu.cecar.controladores.ControladorOpcionesTexto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class AnalizadorTexto {
//-d -l -c -s archivoprueba.txt

    public static void main(String[] argumentos) {
        //analizadorTexto -d -c p -l 2 archivoprueba.txt
        ControladorOpcionesTexto controladorOpcionesTexto = new ControladorOpcionesTexto();
        int i = 1;
        boolean bandera_l = false;
        boolean bandera_s = false;
        for (int j = 1; j < argumentos.length; j++) {
            if (argumentos[j].equals("-l")) {
                bandera_l = true;
            }
            if (argumentos[j].equals("-s")) {
                bandera_s = true;
            }
        }
            try {
                HashMap<String, String> parametros = new HashMap<String, String>();
                if (argumentos[0].equals("analizadorTexto") == false) {
                    System.out.println("Comando erroneo o incompleto");
                } else if (argumentos[1].endsWith(".txt")) {
                    controladorOpcionesTexto.mostrarContenido(argumentos[1]);
                    controladorOpcionesTexto.opcionSinOpcion(argumentos[1]);
                } else {
                    for (int j = 1; j < argumentos.length; j++) {
                        switch (argumentos[j]) {
                            case "-d":
                                try {
                                    Integer.parseInt(argumentos[j + 1]);
                                    parametros.put("-d", argumentos[j + 1]);
                                } catch (NumberFormatException e) {
                                    parametros.put("-d", "1");
                                }
                                break;
                            case "-s":
                                try {
                                    Integer.parseInt(argumentos[j + 1]);
                                    parametros.put("-s", argumentos[j + 1]);
                                } catch (NumberFormatException e) {
                                    parametros.put("-s", "1");
                                }                                
                                break;
                            case "-l":
                                try {
                                    Integer.parseInt(argumentos[j + 1]);
                                    parametros.put("-l", argumentos[j + 1]);
                                } catch (NumberFormatException e) {
                                    parametros.put("-l", "1");
                                }                                
                                break;
                            case "-c":
                                try {
                                    break;
                                } catch (NumberFormatException e) {
                                    parametros.put("-c", argumentos[j+1]);
                                }                                
                                break;
                        }
                    }
                }
                Iterator it = parametros.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Comando erroneo o incompleto 72");
            }
        }
    }

