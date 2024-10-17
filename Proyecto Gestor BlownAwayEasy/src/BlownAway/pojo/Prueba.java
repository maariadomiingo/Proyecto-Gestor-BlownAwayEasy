package BlownAway.pojo;

import java.util.*;

import javax.annotation.processing.SupportedSourceVersion;

import BlownAway.Exception.PiezaSeRompeException;
import BlownAway.Main.*;
import BlownAway.pojo.Participante;



public class Prueba {
	public static final int HORAS_INDIV = 4;
	public static final int HORAS_FINAL = 6;
	public String nombrePrueba;
	int horasPrueba;
	String[] habilidades;
	public ArrayList<Participante> participantesConcurso;
	HashMap<Participante, Integer> puntuaciones;
	int puntuacion = 0;

	public Prueba(String nombrePrueba, int horasPrueba) {
		this.nombrePrueba = nombrePrueba;
		this.horasPrueba = horasPrueba;
		this.habilidades =  new String[3];
		this.puntuaciones = new HashMap<>();
		
		generarHabilidadesPrueba();
		
	}

	/**
	 * A cada participante se le suma un punto por cada habilidad que tenga y que la
	 * prueba requiera.
	 */
	public void Preparacion() {
		for (Participante participante : participantesConcurso) {
			participante.habilidades.size();
		}
	}

	/**
	 * Este método genera las habilidades aleatorias.
	 */
	public void generarHabilidadesPrueba() {
		 Random random = new Random();
	        Set<String> tresHabilidadesRandom = new HashSet<>();
	        int numHabilidades = ConcursoMain.HABILIDADES_SOPLADO_VIDRIO.length;
	        int i = 0;
	        while (i < habilidades.length) {
	            String habilidad = ConcursoMain.HABILIDADES_SOPLADO_VIDRIO[random.nextInt(numHabilidades)];
	            if (!tresHabilidadesRandom.contains(habilidad)) {
	                habilidades[i] = habilidad;
	                tresHabilidadesRandom.add(habilidad);
	                i++;
	            }
	        }
	    }

	/**
	 * Esta es la fase de diseño de la obra de vidrio. Se le suma un número
	 * aleatorio de puntos a cada artista (entre 1 y 10).
	 */
	public void planificacion() {
		Random random = new Random();
		for (Participante participante : participantesConcurso) {
			int puntos = random.nextInt(10) + 1; // genera un número aleatorio entre 1 y 10
			puntuaciones.put(participante, puntos); // asigna los puntos al participante con el hashmap
			System.out.println("FASE DE DISEÑO DE LA OBRA DE VIDRIO DE: " + participante.getNombre());
			System.out.println("puntuacion asignada:" + puntos);
			System.out.println();
		}
	}

	/**
	 * Ejecución: Metodo que por cada hora de la prueba, a cada
	 * participante se le suma un número aleatorio de puntos (entre 1 y 10), y luego
	 * a cada uno se le aplica el peso del concurso (se llama al método
	 * pesoDelConcurso) y se pinta su avance en esa hora. Si la pieza se rompe, le
	 * restamos a los puntos del participante un número aleatorio entre 0 y los
	 * puntos que lleva (puede haberse roto un poquito, y que pueda recuperarse, y
	 * puede haberse reventado la pieza en la última hora y que no le dé tiempo a
	 * crear una nueva).
	 *
	 * @throws PiezaSeRompeException
	 */
	public void ejecucion() throws PiezaSeRompeException {
	    for (int i = 1; i <= horasPrueba; i++) {
	        for (Participante participante : participantesConcurso) {
	            Random random = new Random();
	            int puntos = random.nextInt(10) + 1;
	            System.out.println("Asignando puntos al participante " + participante.getNombre());
	            puntuacion += puntos;

	            try {
	                participante.pesoDelConcurso();
	            } catch (PiezaSeRompeException e) {
	                //simulación de la pieza que se rompe
	                int restarPuntos = random.nextInt(puntuacion + 1);
	                //resta entre 0 y los puntos que tiene el participante
	                System.out.println("¡La pieza de " + participante.getNombre() + " se ha roto! Se restarán "
	                        + restarPuntos + " puntos.");
	                puntuacion -= restarPuntos;
	            }

	            System.out.println(participante.getNombre()+ " Tu avance en el concurso es de: " + puntuacion + " puntos.");
	            System.out.println();

	            puntuaciones.put(participante, puntuacion);
	        }
	    }
	}


	void evaluacion() {
	}

	public void mostrarInfoPrueba() {
		System.out.println("-------Información-------");
		System.out.println("Nombre: " + nombrePrueba);
		System.out.println("Habilidades necesarias:");
		for (String habilidad : habilidades) {
			System.out.println(habilidad);
		}
		System.out.println();
	}
}
