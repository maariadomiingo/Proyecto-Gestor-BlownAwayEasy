/**
 * 
 */
package BlownAway.pojo;

import java.util.*;

import BlownAway.Exception.PiezaSeRompeException;

/**
 * 
 */
public class PruebaIndividual extends Prueba {
	Participante ganador;
	Participante perdedor;

	public PruebaIndividual(String nombre) {
		super(nombre, HORAS_INDIV);
//		this.habilidades = habilidades;
		this.participantesConcurso = new ArrayList<>();
	}

	/**
	 * En la evaluación comprobamos quién ha ganado, y guardamos el valor en nuestro
	 * atributo, y comprobamos quién ha perdido, y lo quitamos del ArrayList de
	 * participantes.
	 */
	public void evaluacionPruebaIndiv() {
		// seleccionar al ganador y al perdedor de la prueba individual

		
        int maxPuntuacion=0;
		int minPuntuacion=100;
        
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
	/**
	 * metodo para acceder a los participantes
	 * @param participantes
	 */
    public void setParticipantesConcurso(ArrayList<Participante> participantes) {
        this.participantesConcurso = participantes;
    }
	
	
	public void evaluacionResultadosPruebaIndiv() {
		System.out.println();
		System.out.println("El ganador de la prueba individual es: " + ganador.nombre);
		System.out.println();
		System.out.println("El perdedor de la prueba individual es: " + perdedor.nombre);
		//elimino aqui al perdedor para que primero se pueda mostrar su nombre
		puntuaciones.remove(perdedor);
	}

}

	    
	    
	

