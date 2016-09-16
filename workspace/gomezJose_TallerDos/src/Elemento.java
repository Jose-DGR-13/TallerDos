

public abstract class Elemento {
	
	private float x, y, radio;
	
	public Elemento(float x, float y, int radio) {
		this.x=x;
		this.y=y;
		this.radio=radio;
	}
	
	public void pintar(){
		
	}
	
	public void pintarVida(double porcentajeVida, float mx, float my){}
	
	public void mover(double d, double e){
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public void pintar(int i) {}
	
}
