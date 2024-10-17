package BlownAway.Main;

import java.util.*;

import BlownAway.Exception.PiezaSeRompeException;
import BlownAway.pojo.Participante;
import BlownAway.pojo.Prueba;
import BlownAway.pojo.PruebaFinal;
import BlownAway.pojo.PruebaIndividual;

public class ConcursoMain {
    static Scanner sc = new Scanner(System.in);
    public final static String[] HABILIDADES_SOPLADO_VIDRIO = { "Tecnica", "Escultura", "Realismo", "Creatividad",
            "UsoColor", "Texturas" };
    public static ArrayList<Participante> participantesConcurso;

    public static void main(String[] args) throws PiezaSeRompeException {
        participantesConcurso = new ArrayList<Participante>();

        int respuesta = 0;
        do {
            System.out.println("---------- MENÚ ----------\n");
            System.out.println("1. Mostrar los participantes del concurso\n2. Añadir participante nuevo\n3. Empezar el concurso"
                    + "\n4. Mostrar los resultados del concurso\n5. Salir del programa");

            try {
                respuesta = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ERROR, no has introducido un número");
            }
            switch (respuesta) {
                case 1:
                    System.out.println("\n1. PARTICIPANTES DEL CONCURSO:");
                    for (Participante participante : participantesConcurso) {
                        participante.mostrarInfoParticipante();
                    }
                    break;
                case 2:
                    System.out.println("\n2. AÑADE UN PARTICIPANTE NUEVO:");
                    crearParticipante();
                    break;
                case 3:
                    System.out.println("\n3. EMPIEZA EL CONCURSO:");
                    empezarConcurso();
                    break;
                case 4:
                    System.out.println("\n4. MOSTRANDO LOS RESULTADOS DEL CONCURSO:");
                    break;
            }
        } while (respuesta != 5);
        System.out.println("5. SALIENDO DEL PROGRAMA...");
    }

    /**
     * metodo para crear participantes
     */
    public static void crearParticipante() {
        int edad;
        int añosExperiencia;

        System.out.println("Creación de nuevo participante:");
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        do {
            System.out.print("Edad: ");
            edad = sc.nextInt();
            if (edad < 18) {
                System.out.println("Debes ser mayor de edad para participar");
            }
        } while (edad < 18);

        int minExperiencia = 0;
        do {
            System.out.print("Años de experiencia: ");
            añosExperiencia = sc.nextInt();
            minExperiencia = edad - añosExperiencia;

            if (minExperiencia < 10) {
                System.out.println("Tu experiencia no es acorde con tu edad");
            }
        } while (minExperiencia < 10);

        Participante p = new Participante(nombre, edad, añosExperiencia);
        participantesConcurso.add(p);

        System.out.println("Participante creado!!");
    }

    /**
     * metodo que ejecuta todos los metodos necesarios para las pruebas
     * @throws PiezaSeRompeException
     */
    public static void empezarConcurso() throws PiezaSeRompeException {
        if (participantesConcurso.size() < 2) {
            System.out.println("Debe haber al menos 2 participantes para empezar el concurso.");
            return;
        }

        System.out.println("\nEMPEZANDO EL CONCURSO:");
        
        
        
        PruebaIndividual pruebaIndividual = new PruebaIndividual("Prueba Individual");
        pruebaIndividual.setParticipantesConcurso(participantesConcurso);
        pruebaIndividual.mostrarInfoPrueba();
        pruebaIndividual.Preparacion();
        pruebaIndividual.generarHabilidadesPrueba();
        pruebaIndividual.planificacion();
        pruebaIndividual.ejecucion();
//        for (Participante participante : participantesConcurso) {
//        	participante.pesoDelConcurso();
//        	
//        }
        pruebaIndividual.evaluacionPruebaIndiv();
        pruebaIndividual.evaluacionResultadosPruebaIndiv();
        // Crear instancia de PruebaFinal fuera del bloque if
        PruebaFinal pruebaFinal = new PruebaFinal("Prueba Final", HABILIDADES_SOPLADO_VIDRIO, Prueba.HORAS_FINAL);

        if (!participantesConcurso.isEmpty()) {
            Participante restante1 = participantesConcurso.get(0);
            Participante restante2 = participantesConcurso.get(1);
            //llamo a los métodos de evaluación para la prueba final
            pruebaFinal.evaluacionPruebaFinal();
} else {
            System.out.println("No hay suficientes participantes para realizar la prueba final.");
        }
    }
    
    
    

}
