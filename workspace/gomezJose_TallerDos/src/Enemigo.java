import processing.core.PApplet;
import processing.core.PVector;

public class Enemigo extends Elemento {

	private PApplet app = MainApp.app;

	private float maxspeed, maxforce;
	private int radio;
	private PVector location, vel, aceleracion;

	public Enemigo(float x, float y, int radio) {
		super(x, y, radio);
		this.radio = radio;
		aceleracion = new PVector(0, 0);
		vel = new PVector(0, -2);
		location = new PVector(x, y);
		maxspeed = 4;
		maxforce = 0.1f;
	}

	public void pintar(int enemigoX) {
		//System.out.println("posX " + location.x + "posY " + location.y);
		// x += 5;
		app.noFill();

		switch (enemigoX) {
		case 0:
			app.stroke(255, 0, 0);	//Rojo
			break;
		case 1:
			app.stroke(0, 255, 0);	//Verde
			break;
		case 2:
			app.stroke(0, 0, 255);	//Azul
			break;
		case 3:
			app.stroke(255, 130, 0);	//Naranja
			break;
		case 4:
			app.stroke(100, 0, 200);	//Violeta
			break;
		case 5:
			app.stroke(255);
			break;

		default:
			break;
		}

		app.quad(location.x - app.random(0, radio), location.y + app.random(0, radio), location.x + app.random(0, radio), location.y + app.random(0, radio),
				location.x + app.random(0, radio), location.y - app.random(0, radio), location.x - app.random(0, radio), location.y - app.random(0, radio));

	}

	public void location() {
		vel.add(aceleracion);
		vel.limit(maxspeed);
		location.add(vel);
		aceleracion.mult(0);
	}

	public void aplicarFuerza(PVector fuerza) {
		aceleracion.add(fuerza);
	}

	public void seek(PVector objetivo) {
		PVector cel = PVector.sub(objetivo, location);
		cel.setMag(maxspeed);
		PVector menVel = PVector.sub(cel, vel);
		menVel.limit(maxforce);
		aplicarFuerza(menVel);
	}

}
