package unPaquete;

public class Categoria {
	private int edadMinima;
	private int edadMaxima;
	public Categoria(int edadMinima, int edadMaxima) {
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public int getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
}
