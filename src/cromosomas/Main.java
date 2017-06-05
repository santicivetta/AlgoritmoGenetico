package cromosomas;

public class Main {

	public static void main(String[] args) {
		Integer configuraciones[], tamanoPoblacion, tamanoIndividuos, maximoAMutar;
		// tamanoIndividuo es en Hexa
		configuraciones = Archivos.cargarConfiguraciones("src/cromosomas/cromosomas.txt");
		tamanoPoblacion = configuraciones[0];
		tamanoIndividuos = configuraciones[1];
		maximoAMutar = configuraciones[2];

		// Creo poblacion inicial
		Poblacion poblacion = new Poblacion(tamanoPoblacion, tamanoIndividuos);
		poblacion.imprimirPoblacion();
		// System.out.println(miPob.getFittest().getFitness(miPob.getSolucion()).toString());
		/*
		 * miPob.imprimirPoblacion(); miPob.cruce(); miPob.imprimirPoblacion();
		 * miPob.seleccion(); miPob.imprimirPoblacion(); miPob.mutarPob();
		 * miPob.imprimirPoblacion();
		 */
		// Evolve our Poblacion until we reach an optimum solution
		int cantidadDeGeneraciones = 0;
		while (poblacion.obtenerSolucion() == null) {
			// while (cant<15) {
			// System.out.println("solucion: " + miPob.getSolucion().getHexa());
			poblacion.seleccionarParejas();
			// System.out.println("vuelta");
			poblacion.cruce();
			// System.out.println("vuelta");
			poblacion.mutarPob(maximoAMutar);
			// System.out.println("actual: " + miPob.getFittest().getHexa() + "
			// " +
			// miPob.getFittest().getFitness(miPob.getSolucion()).toString());

			System.out.println(cantidadDeGeneraciones + "|||||  " + poblacion.getFittest().getFitness(poblacion.getSolucion()).toString());
			cantidadDeGeneraciones++;
		}
		/*
		 * Individuo miej = new Individuo(); System.out.println(miej.getBin());
		 * System.out.println(miej.alterarNumBin(2, miej.getBin()));
		 * System.out.println(miej.getBin()); miej.mutar();
		 * System.out.println(miej.getBin()); miej.mutar();
		 * System.out.println(miej.getBin()); miej.mutar();
		 * System.out.println(miej.getBin());
		 */
		System.out.println("Solution found!");
		System.out.println("Genes:");
		// System.out.println(miPob.fitTest());
	}
	
}