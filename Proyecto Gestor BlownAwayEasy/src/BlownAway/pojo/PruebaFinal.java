/**
 * 
 */
package BlownAway.pojo;

import java.util.ArrayList;

/**
 * 
 */
public class PruebaFinal extends Prueba{

	Participante ganador;
	Participante perdedor;
	
	
	public PruebaFinal(String nombre, String[] habilidades, int HORAS_FINAL) {
		super(nombre, HORAS_FINAL);
		this.habilidades = habilidades;
		this.participantesConcurso = new ArrayList<>();
	}

	public void evaluacionPruebaFinal() {
        // seleccionar al ganador y al perdedor de la prueba final
        int maxPuntuacion = Integer.MIN_VALUE;
        int minPuntuacion = Integer.MAX_VALUE;

        for (Participante participante : participantesConcurso) {
            int puntosParticipante = puntuaciones.get(participante);

            if (puntosParticipante > maxPuntuacion) {
                maxPuntuacion = puntosParticipante;
                ganador = participante;
            }

            if (puntosParticipante < minPuntuacion) {
                minPuntuacion = puntosParticipante;
                perdedor = participante;
            }
        }
    }
	
	  public void evaluacionResultadosPruebaFinal() {
	        System.out.println("El ganador de la prueba final es: " + ganador.getNombre());
	        System.out.println();
	        System.out.println("El perdedor de la prueba final es: " + perdedor.getNombre());
	    }
	}
	
//	public void PruebaFinal crearPruebaFinal() {
//	    String nombrePrueba = "Prueba Final";
//	    
//	    String[] habilidades = generarHabilidades();
//	    PruebaFinal pruebaFinal = new PruebaFinal(nombrePrueba, habilidades, Prueba.HORAS_FINAL);
//	    pruebaFinal.participantesConcurso = participantesConcurso;
//	    pruebaFinal.mostrarInfoPrueba();
//	    return pruebaFinal;
//	}

