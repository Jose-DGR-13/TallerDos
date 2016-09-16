import javax.swing.plaf.ProgressBarUI;

import processing.core.PApplet;

public class Celula extends Elemento {

	PApplet app = MainApp.app;
	private float x, y;
	private double porcentajeVida;

	public Celula(float x, float y, int radio) {
		super(x, y, radio);
		this.x = x;
		this.y = y;
	}

	public void pintar() {
		x += 5;
		app.noFill();
		app.stroke(255);

		app.ellipse(x - 15, y + 15, app.random(40, 60), app.random(40, 60));

		// app.quad(x-app.random(0,20), y+app.random(0,20),
		// x+app.random(0,20), y+app.random(0,20),
		// x+app.random(0,20), y-app.random(0,20),
		// x-app.random(0,20), y-app.random(0,20));

		// app.triangle(x-app.random(0,20),
		// y+app.random(0,20), x+app.random(0,20),
		// y+app.random(0,20), x+app.random(0,20),
		// y-app.random(0,20));

	}

	public void pintarVida(double porcentaje, float mx, float my) {
		this.x=mx;
		this.y=my;
		this.porcentajeVida = porcentaje;
		app.stroke(255);
		app.noFill();
		app.rect(x - 55, y + 55, 80, 5);
		app.fill(0, 255, 0);
		app.rect(x - 55, y + 55, (float) (80 * porcentajeVida), 5);

	}

	public void mover(float mx, float my) {
		this.x = mx;
		this.y = my;
	}
	
}
