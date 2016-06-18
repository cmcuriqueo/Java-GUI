package veterinaria;

import java.util.Date;


public class Registro {
	Date fecha;
	double peso;
	double medida;
	
	public Registro( Date fecha, double peso, double medida) {
		this.fecha = fecha;
		this.peso = peso;
		this.medida = medida;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setMedida(double medida) {
		this.medida = medida;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public double getMedida() {
		return medida;
	}
	
	public double getPeso() {
		return peso;
	}
	
	@Override
	public String toString() {
		return fecha.toString()+" - "+peso+" - "+medida;
	}
	
	
}
