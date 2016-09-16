import processing.core.PApplet;

public class Particula {

	PApplet app = MainApp.app;
	float x, y, size, other;
	private int particulaX;

	public Particula(float x, float y) {
		this.x = x;
		this.y = y;
		size=35;
	}

	public void pintar(int particulaX) {
		this.particulaX=particulaX;
		app.noStroke();
		switch (particulaX) {
		case 0:
			app.fill(255, 0, 0, 75);
			app.ellipse(x, y, other, other);
			app.fill(255, 0, 0);
			app.stroke(255);
			app.ellipse(x, y, size, size);
			break;

		case 1:
			app.fill(0, 255, 0, 75);
			app.ellipse(x, y, other, other);
			app.fill(0, 255, 0);
			app.stroke(255);
			app.ellipse(x, y, size, size);
			break;

		case 2:
			app.fill(0, 0, 255, 75);
			app.ellipse(x, y, other, other);
			app.fill(0, 0, 255);
			app.stroke(255);
			app.ellipse(x, y, size, size);
			break;

		case 3:
			app.fill(255, 130, 0, 75);
			app.ellipse(x, y, other, other);
			app.fill(255, 130, 0);
			app.stroke(255);
			app.ellipse(x, y, size, size);
			break;

		case 4:
			app.fill(100, 0, 200, 75);
			app.ellipse(x, y, other, other);
			app.fill(100, 0, 200);
			app.stroke(255);
			app.ellipse(x, y, size, size);
			break;

		default:
			break;
		}

		other+=0.5;
		if (other > 50) {
			other = 25;
		}

	}
	
	@Override
	public String toString() {
		return "posX "+x+"posY "+y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getParticulaX() {
		return particulaX;
	}
	
	

}
