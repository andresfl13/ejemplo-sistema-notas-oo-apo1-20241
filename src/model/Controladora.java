package model;
import model.*;

// En la controladora no pueden haber ni prints ni scanners
// En vez de hacer print , se empaqueta un mensaje, es decir se haace un string larguito y se retorna, para el ejemplo ver el metodo listarSemestre
public class Controladora {
    private Estudiante[] estudiantes;

    public Controladora() {
        this.estudiantes = new Estudiante[29];
    }
// El orden de creación de estos metodos no importa, el orden en que se ejecutan en la clase ejecutable sí.
    public Profesor crearProfesor(String nombre, int edad, String cedula) {
    	Profesor profesor = new Profesor(nombre, edad, cedula);
    	return profesor;
    }

    public Curso crearCurso(String nombreCurso, int creditos, String facultad) {
    	Curso curso = new Curso(nombreCurso, creditos, facultad);
    	return curso;
    }

    public Semestre crearSemestre(String nombrePeriodo) {
    	Semestre semestre = new Semestre(nombrePeriodo);
    	return semestre;
    }

    public void asociarCursoConSemestre(Curso curso, Semestre semestre) {
    	semestre.agregarCurso(curso);
    }

    public Estudiante crearEstudiante(String nombre, int edad, String codigoEstudiante, Barrio barrioEstudiante) { // Los parametros son los mismos que Estudiante.java
    	Estudiante estudiante = new Estudiante(nombre, edad, codigoEstudiante, barrioEstudiante);
    	return estudiante;
    }
		// Luego de crear al estudiante se mete en el arreglo
    public void agregarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public void asociarSemestreConEstudiante(Estudiante estudiante, Semestre semestre) {
    	estudiante.agregarSemestre(semestre); // Se llama al metodo agregarSemestre de la clase estudiante
    }

    public void asociarCursoConProfesor(Curso curso, Profesor profesor) {
        curso.setProfesor(profesor);
    }

    public String listarEstudiante(int indice) { // Metodo buscador que busca un estudiante y que de ese muestre la informacion, para posteriormente en el ejecutable hacer un ciclo para que muestre a todos
        if (indice >= 0 && indice < estudiantes.length && estudiantes[indice] != null) { // != null significa que SI hay un estudiante
            Estudiante estudiante = estudiantes[indice];
            return "Nombre: " + estudiante.getNombre() + "\n" +			// Se retorna un string con la informacion del estudiante
                   "Edad: " + estudiante.getEdad() + "\n" +
                   "Código de Estudiante: " + estudiante.getCodigoEstudiante(); + "\n" +
				   "Zona: " + estudiante.getBarrio().toString(); 
        } else {
            return ""; 		// Se retorna un string vacio en caso de que no encuentre a ningun estudiante
        }
    }

    public int obtenerCantidadEstudiantes() { // Método para saber la cantidad de estudiantes que hay en el arreglo ( los que no son null)
        return estudiantes.length;
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.getCodigoEstudiante().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public String listarSemestre(int indice, Estudiante estudiante) {
        Semestre[] semestresEstudiante = estudiante.getSemestres();
        if (indice >= 0 && indice < estudiante.getSemestres().length && semestresEstudiante[indice] != null) {
            Semestre semestre = semestresEstudiante[indice];
            return "Nombre del periodo: " + semestre.getNombrePeriodo();
        } else {
            return "";
        }
    }

	public Barrio retornaTipoDeBarrio(int decision) {
		Barrio barrioEnum;
		switch (decision): {
			case 1:
				barrioEnum = Barrio.NORTE;
		case 2:
				barrioEnum = Barrio.SUR;
		case 3:
				barrioEnum = Barrio.ORIENTE;
		case 4:
				barrioEnum = Barrio.OCCIDENTE;
		case 5:	
				barrioEnum = Barrio.FUERA_DE_CALI;
		default:
		System.out.println("El barrio ingresado NO EXISTE");
		}
		return barrioEnum;
	}
	
}