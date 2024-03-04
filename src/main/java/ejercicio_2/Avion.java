package ejercicio_2;

public class Avion extends Volador implements IAterrizaje {
	
	private Integer identificacion;

	public Avion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public boolean puedeAterrizar() {
		return true;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}


}
