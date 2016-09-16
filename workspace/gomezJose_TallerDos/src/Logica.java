import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Logica {

	PApplet app = MainApp.app;
	private ArrayList<Elemento> celula;
	// private LinkedList<Elemento> particulas;
	private ArrayList<Particula> particula;
	private ArrayList<Elemento> enemigo;
	private double porcentajeVida = 1;
	private PVector cell;
	private float angulo;
	private boolean rojo, azul, verde, naranja, violeta;

	public Logica() {
		angulo = PConstants.TWO_PI / 15;
		celula = new ArrayList<Elemento>();
		particula = new ArrayList<Particula>();
		enemigo = new ArrayList<Elemento>();
		// particulas = new LinkedList<Elemento>();

		celula.add(new Celula(app.width / 2, app.height / 2, 50));
		particula.add(new Particula(app.width / 2, app.height / 2));
		for (int i = 0; i < 16; i++) {
			enemigo.add(new Enemigo(app.width / 2 + PApplet.cos(angulo * i) * 300,
					app.height / 2 + PApplet.sin(angulo * i) * 300, 25));
		}
		/*
		 * Iterator<Elemento> it = particulas.iterator(); while (it.hasNext()) {
		 * Elemento elemento = (Elemento) it.next(); elemento.pintar(4); }
		 */
		rojo = false;
		verde = false;
		azul = false;
		naranja = false;
		violeta = false;

	}

	public void pintar() {
		cell = new PVector(app.mouseX, app.mouseY);

		// porcentajeVida -= 0.01;
		for (Particula par : particula) {
			par.pintar(3);
		}

		for (int i = 0; i < particula.size(); i++) {
			particula.get(i).pintar(i);
		}

		for (Elemento cel : celula) {
			cel.pintar();
			cel.mover(app.mouseX, app.mouseY);
			cel.pintarVida(porcentajeVida, app.mouseX, app.mouseY);
		}

		for (int i = 0; i < enemigo.size(); i++) {
			Enemigo ene = (Enemigo) enemigo.get(i);
			if (rojo == true) {
				if (i == 5 || i == 10 || i == 15) {
					ene.pintar(0);
				}
			} else {
				ene.pintar(5);
			}
			if (verde == true) {
				if (i == 4 || i == 9 || i == 14) {
					ene.pintar(1);
				}
			} else {
				ene.pintar(5);
			}
			if (azul == true) {
				if (i == 3 || i == 8 || i == 13) {
					ene.pintar(2);
				}
			} else {
				ene.pintar(5);
			}
			if (naranja == true) {
				if (i == 2 || i == 7 || i == 12) {
					ene.pintar(3);
				}
			} else {
				ene.pintar(5);
			}
			if (violeta == true) {
				if (i == 1 || i == 6 || i == 11) {
					ene.pintar(4);
				}
			} else {
				ene.pintar(5);
			}

			((Enemigo) ene).seek(cell);
			((Enemigo) ene).location();
		}
	}

	public void key() {
		switch (app.key) {
		case '1':
			rojo = true;
			verde = false;
			azul = false;
			naranja = false;
			violeta = false;
			break;
		case '2':
			rojo = false;
			verde = true;
			azul = false;
			naranja = false;
			violeta = false;
			break;
		case '3':
			rojo = false;
			verde = false;
			azul = true;
			naranja = false;
			violeta = false;
			break;
		case '4':
			rojo = false;
			verde = false;
			azul = false;
			naranja = true;
			violeta = false;
			break;
		case '5':
			rojo = false;
			verde = false;
			azul = false;
			naranja = false;
			violeta = true;
			break;
		case '0':
			rojo = false;
			verde = false;
			azul = false;
			naranja = false;
			violeta = false;
			break;
		default:
			break;
		}

	}

}
