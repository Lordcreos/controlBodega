package bodegaControl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uisrael.bodegaControl.controlador.EquipoControlador;
import com.uisrael.bodegaControl.controlador.impl.EquipoControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Equipo;

public class testBodega1 {

	private EquipoControlador equipoControlador;
	@Test
	public void test() {
		Equipo nuevoEquipo = new Equipo();
		nuevoEquipo.setNombreEquipo("Computador");
		nuevoEquipo.setCaracteristicaEquipo("Core I5 de 2 ge");
		equipoControlador = new EquipoControladorImpl();
		equipoControlador.insertarEquipo(nuevoEquipo);
	
	}
}
