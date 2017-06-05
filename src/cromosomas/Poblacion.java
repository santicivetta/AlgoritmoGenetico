package cromosomas;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Poblacion {

	private ArrayList<Individuo> individuos;
	private Individuo clave;

	// Constructores
	public Poblacion(Integer tamanoPob, Integer tamanoIndividuo) {
		this.setIndividuos(new ArrayList<Individuo>());
		for (int i = 0; i < tamanoPob; i++) {
			Individuo nuevoIndividuo = new Individuo(tamanoIndividuo);
			this.getIndividuos().add(nuevoIndividuo);
		}
		this.setSolucion(new Individuo(tamanoIndividuo));
	}

	// G&S
	public ArrayList<Individuo> getIndividuos() {
		return this.individuos;
	}

	private void setIndividuos(ArrayList<Individuo> individuos) {
		this.individuos = individuos;
	}

	public Individuo getSolucion() {
		return this.clave;
	}

	public void setSolucion(Individuo solucion) {
		this.clave = solucion;
	}

	// Metodos
	public Individuo obtenerSolucion() {
		for (int i = 0; i < this.getIndividuos().size(); i++) {
			if (this.getIndividuos().get(i).getFitness(this.getSolucion()) == this.getSolucion()
					.getFitness(this.getSolucion())) {
				return this.getIndividuos().get(i);
			}
		}
		return null;
	}

	public void seleccionarParejas() {
		ArrayList<Individuo> newIndividuos = new ArrayList<Individuo>();
		for (int i = 0; i < this.getIndividuos().size(); i++) {
			int randomId = (int) (Math.random() * this.getIndividuos().size());
			Individuo indiv1 = this.getIndividuos().get(randomId);
			int randomId2 = (int) (Math.random() * this.getIndividuos().size());
			Individuo indiv2 = this.getIndividuos().get(randomId2);
			// System.out.println("IND" + randomId + " Hexa: " +
			// indiv1.getHexa() + "||| Bin: " + indiv1.getBin() + "||| Fitness:
			// " + indiv1.getFitness(this.getSolucion()));
			// System.out.println("vs.");
			// System.out.println("IND" + randomId2 + " Hexa: " +
			// indiv2.getHexa() + "||| Bin: " + indiv2.getBin() + "||| Fitness:
			// " + indiv2.getFitness(this.getSolucion()));System.out.println();
			if (indiv1.getFitness(this.getSolucion()) > indiv2.getFitness(this.getSolucion())) {
				newIndividuos.add(indiv1);
			} else {
				newIndividuos.add(indiv2);
			}
		}
		this.setIndividuos(newIndividuos);
	}

	public void mutarPob(Integer maximoAMutar) {
		Random rand = new Random();
		int individuosAMutar = rand.nextInt(this.getIndividuos().size());
		int individuo;
		// recorre toda la poblacion pero puede ser que haya individuos que no
		// muten
		for (int i = 0; i < individuosAMutar; i++) {
			individuo = rand.nextInt(this.getIndividuos().size());
			this.getIndividuos().get(individuo).mutar(maximoAMutar);
		}
	}

	public Individuo getFittest() {
		Individuo fittest = this.getIndividuos().get(0);
		for (int i = 0; i < this.getIndividuos().size(); i++) {
			if (fittest.getFitness(this.getSolucion()) <= this.getIndividuos().get(i).getFitness(this.getSolucion())) {
				fittest = this.getIndividuos().get(i);
			}
		}
		return fittest;
	}

	public void cruce() {
		Boolean valorDisponible = false;
		String aux, aux1, aux2;
		int usados[] = new int[100];
		int indi1 = 0, indi2 = 0, puntoCruce = 0;
		Random rand = new Random();
		for (int i = 0; i < this.getIndividuos().size(); i = i + 2) {
			valorDisponible = false;
			while (!valorDisponible) {
				indi1 = rand.nextInt(this.getIndividuos().size());
				if (usados[indi1] != 1) {
					valorDisponible = true;
					usados[indi1] = 1;
				}
			}
			valorDisponible = false;
			while (!valorDisponible) {
				indi2 = rand.nextInt(this.getIndividuos().size());
				if (usados[indi2] != 1) {
					valorDisponible = true;
					usados[indi2] = 1;
				}
			}
			// System.out.println("Cruce entre: Cromosoma " + indi1 + "
			// Cromosoma " + indi2);
			puntoCruce = rand.nextInt(40);
			// System.out.println("Punto de Cruce: " + puntoCruce);
			// System.out.println("Anter Cromosoma " + indi1 + " " +
			// this.getIndividuos().get(indi1).getBin() );
			// guardo cromosomas originales
			aux1 = this.getIndividuos().get(indi1).getBin();
			aux2 = this.getIndividuos().get(indi2).getBin();

			// genero nuevo cromosoma1 y se lo asigno al ind1
			aux = aux1.substring(0, puntoCruce) + aux2.substring(puntoCruce, 40);
			this.getIndividuos().get(indi1).setBin(aux);
			this.getIndividuos().get(indi1).setHexa(this.getIndividuos().get(indi1).toHexa());

			// System.out.println("Nuevo Cromosoma " + indi1 + " " +
			// this.getIndividuos().get(indi1).getBin() );
			// System.out.println("Anter Cromosoma " + indi2 + " " +
			// this.getIndividuos().get(indi2).getBin() );

			// genero nuevo cromosoma2 y se lo asigno al ind2
			aux = aux2.substring(0, puntoCruce) + aux1.substring(puntoCruce, 40);
			this.getIndividuos().get(indi2).setBin(aux);
			this.getIndividuos().get(indi2).setHexa(this.getIndividuos().get(indi1).toHexa());

			// System.out.println("Nuevo Cromosoma " + indi2 + " " +
			// this.getIndividuos().get(indi2).getBin() );
		}
	}

	public void imprimirPoblacion() {
		System.out.println("SOLUCION Hexa: " + this.getSolucion().getHexa() + "||| Bin: " + this.getSolucion().getBin()
				+ "||| Fitness: " + this.getSolucion().getFitness(this.getSolucion()));
		for (int i = 0; i < this.getIndividuos().size(); i++) {
			System.out.println("INDIVID" + i + " Hexa: " + this.getIndividuos().get(i).getHexa() + "||| Bin: "
					+ this.getIndividuos().get(i).getBin() + "||| Fitness: "
					+ this.getIndividuos().get(i).getFitness(this.getSolucion()));
		}
		System.out.println();
	}
	
}