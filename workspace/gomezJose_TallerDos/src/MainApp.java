import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;

public class MainApp extends PApplet {

	static PApplet app;
	Logica logica;
	private int value = 100, x, y, tam, tamDos;
	private PImage fondo;

	public void settings() {
		size(1280, 720);
		// fullScreen();
	}

	public void setup() {
		fondo = loadImage("../data/bg.jpg");
		app = this;
		logica = new Logica();
		// x = (int) app.random(0, app.width);
		// y = (int) app.random(0, app.height);
		tam = 0;
	}

	public void draw() {
		// app.image(fondo, 0, 0, app.width, app.height);
		// background(fondo);
		logica.pintar();
		backgroundFx();
	}

	public void backgroundFx() {
		app.fill(0, value);
		app.rect(-1, -1, app.width + 1, app.height + 1);
		value -= 0.2;
		if (value <= 70) {
			value += 02;
		}
		for (int i = 0; i < 10; i++) {
			wave();
		}

	}

	public void wave() {
		int contador = 0, cambio = 0;
		int tamañoUno = 100, tamañoDos = 70, tamañoTres = 30;
		x = (int) app.random(0, app.width);
		y = (int) app.random(0, app.height);
		tam++;
		app.noFill();
		app.stroke(255, 2);
		for (int i = 0; i < 16; i++) {
			app.ellipse(app.width / 2 + PApplet.cos((PConstants.TWO_PI / 15) * i) * 600,
					app.height / 2 + PApplet.sin((PConstants.TWO_PI / 15) * i) * 600, tamañoUno + tam, tamañoUno + tam);
		}
		if (tam >= tamañoUno / 0.1f && tam >= tamañoDos / 0.1f && tam >= tamañoTres / 0.1f) {
			tam = 0;
		}
	}

	public void keyPressed() {
		logica.key();
	}

	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

}
