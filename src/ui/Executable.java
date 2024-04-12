package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

	// Atributos de la clase Ejecutable
	private Scanner reader;
	private Controladora cont;
	private static boolean flag;

	private Executable() {
		reader = new Scanner(System.in);
		cont = new Controladora();
	}
	
	

	public void run(boolean flag)
	{

		flag = false;

		while (!flag) {

			System.out.println("\n \n Bienvenido al menu:\n");
			System.out.println("Opciones:\n" + "1. Registrar estudiante \n" + "2. Imprimir estudiantes\n"
					+ "3. Crear semestre a estudiante \n" + "4. Mostrar semestres de un estudiante \n" + "5. Salir del programa \n");

			int option = reader.nextInt();

			reader.nextLine();

			switch (option) {
					case 1:
						registrarEstudiante();
						break;
					case 2:
						imprimirEstudiantes();
						break;
					case 3:
						crearSemestreAEstudiante();
						break;
					case 4:
						imprimirSemestresDeEstudiante();
						break;
					case 5:
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

	}

	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run(flag);
	}

	public void registrarEstudiante() {
		
		String nombreEstudiante, codigoEstudiante;
		int edadEstudiante, decisionBarrrioEstudiante;
		
		System.out.println("Ingrese nombre del estudiante: ");
		
		nombreEstudiante = reader.nextLine();
		
		System.out.println("Ingrese edad del estudiante: ");
		
		edadEstudiante = reader.nextInt();
		
		reader.nextLine(); // Limpiar el buffer
		
		System.out.println("Ingrese codigo del estudiante: ");
		
		codigoEstudiante = reader.nextLine();
		
		System.out.println("Ingrese el código del barrio del estudiante, 1: Norte, 2: Sur, 3: Oriente, 4: Occidente, 5: Fuera de cali ");
		
		barrioEstudiante = reader.nextInt();
		//System.out.println("Datos del estudiante: \n" + 
		//"Nombre: " + nombreEstudiante + "\n" + 
		//"Edad: " + edadEstudiante + "\n" + 
		//"Codigo: " + codigoEstudiante);
		
		
		cont.agregarEstudiante(cont.crearEstudiante(nombreEstudiante, edadEstudiante, codigoEstudiante, cont.retornaTipoDeBarrio(decisionBarrioEstudiante))); // cont es controladora, se llama para usar los metodos de la controladora
		// Llamamos al metodo agregarEstudiante de la controladora, en el otro parentesis se vuelve a llamar a la controladora con el método de crearEstudiante, ya que ese es el metodo que nos retorna al estudiante ya creado. 
	}

	public void imprimirEstudiantes() {

		int cantidadEstudiantes = cont.obtenerCantidadEstudiantes(); // Se reciben el total de estudiantes

		for(int i = 0; i <= cantidadEstudiantes; i++) { // Se repite el ciclo hasta el total de estudiantes que hay registrados
			String impresionEstudiante = cont.listarEstudiante(i); // Se llama al método que ya creamos en la controladora para buscar los estudiantes
			if(impresionEstudiante != "") { // != "" significa que es un null (revisar el metodo que hay en controladora)
				System.out.println(impresionEstudiante); // Se imprime la información de cada estudiante
			} else { 
				break; // Se rompe el ciclo si la condición no se cumple, pues significaria que no hay más estudiantes (null)
			}
			
		}
		
	}

	public void crearSemestreAEstudiante() {

		String codigoEstudiante;


		System.out.println("Ingrese el codigo del estudiante al que le vamos a crear el semestre: ");

		codigoEstudiante = reader.nextLine();

		String nombrePeriodoSemestre;

		System.out.println("Ingrese el nombre del periodo del semestre: ");

		nombrePeriodoSemestre = reader.nextLine();

		cont.asociarSemestreConEstudiante(cont.buscarEstudiantePorCodigo(codigoEstudiante), cont.crearSemestre(nombrePeriodoSemestre));



	}

	public void imprimirSemestresDeEstudiante() {

		String codigoEstudiante;

		System.out.println("Ingrese el codigo del estudiante al que le vamos a averiguar el semestre: ");

		codigoEstudiante = reader.nextLine();



		for(int i = 0; i <= cont.buscarEstudiantePorCodigo(codigoEstudiante).cuantosSemestres(); i++) {
			String impresionEstudiante = cont.listarSemestre(i, cont.buscarEstudiantePorCodigo(codigoEstudiante));
			if(impresionEstudiante != "") {
				System.out.println(impresionEstudiante);
			} else {
				break;
			}
			
		}
		
	}



	

	
}