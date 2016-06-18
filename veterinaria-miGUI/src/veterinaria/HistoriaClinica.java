package veterinaria;

import java.util.LinkedList;

public class HistoriaClinica {
	String nombre;
	String matricula;
	LinkedList<Registro> registro = null;
	
	public HistoriaClinica( String nombre, String matricula) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.registro = new LinkedList<Registro>();
	}
	
	public void setRegistro(Registro registro) {
		if(this.registro != null)
			this.registro.add(registro);
		else 
			this.registro.add(registro);
			
	}

	public LinkedList<Registro> getRegistro() {
		return this.registro;
	}
}
