/**
 * 
 */
package BlownAway.pojo;

import java.util.*;
import BlownAway.Main.ConcursoMain;
import BlownAway.Exception.PiezaSeRompeException;


/**
 * @author Maria Domingo
 */
public class Participante {

	public String nombre;
	public int edad;
	public int añosExperiencia;
	ArrayList<String> habilidades;
	public double nivelEstres;
	
	public static final int NIVEL_ESTRES_BASE = 2;
	public static final int NIVEL_ESTRES_PELIGRO = 8;
	
	public int numeroAcertar;
	public static ArrayList<Participante> participantesConcurso;

	Scanner sc = new Scanner(System.in);

	public Participante() {
		this("", 0, 0);
	}

	/**
	 * constructor participante
	 */
	public Participante(String nombre, int edad, int añosExperiencia) {
		this.nombre = nombre;
		this.edad = edad;
		this.añosExperiencia = añosExperiencia;
		this.habilidades = new ArrayList<String>();
		this.nivelEstres = NIVEL_ESTRES_BASE ;
		generarHabilidadesParticipante();

	}
/**
 * este metodo genera habilidades random a los participantes segun los años de experiencia que tengan
 */
	public void generarHabilidadesParticipante() {

		int cantidadHabilidades = añosExperiencia / 3;
		Random random = new Random();

		for (int i = 0; i < cantidadHabilidades; i++) {
            habilidades.add(ConcursoMain.HABILIDADES_SOPLADO_VIDRIO[i % ConcursoMain.HABILIDADES_SOPLADO_VIDRIO.length]);

		}
	}

	/**
	 * este metodo aumenta el nivel de estres de cada participante y si este nivel supera el
	 *  nivel de peligro, sale un numero aletorio del 1-20 y si coincide con mi numero 
	 *  introducido la pieza se rompe y vuelve al nivel de estres base
	 * @throws PiezaSeRompeException
	 */
	public void pesoDelConcurso() throws PiezaSeRompeException {
		if (nivelEstres >= NIVEL_ESTRES_PELIGRO) {
			Random random = new Random();
		
			nivelEstres += random.nextDouble(1, 2);
			System.out.println("el nivel de estres de" + getNombre() + " es "+ nivelEstres);
			int numAleatorio = random.nextInt(20);

			if (numAleatorio == 5) {
				nivelEstres = NIVEL_ESTRES_BASE;
				throw new PiezaSeRompeException("La pieza del participante: "+ getNombre() + "se ha roto.");
			}
		}
	}

	/**
	 * al ganar una prueba se reinicia el nivel de estres
	 */
	public void ganaPrueba() {
		nivelEstres = NIVEL_ESTRES_BASE;
	}

	/**
	 * cuando terminan una prueba, su nivel de estrés vuelve a NIVEL_ESTRES_BASE*2
	 */
	public void descansoEntrePruebas() {
		nivelEstres = NIVEL_ESTRES_BASE;
	}

	/**
	 * este método muestra la informacion del participante
	 */
	public void mostrarInfoParticipante() {
		System.out.println("Información del participante ");
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Años Experiencia: " + añosExperiencia);
		System.out.println("Habilidades: " + habilidades);

	}
	
	public String getNombre() {
		return nombre;
	}

}
