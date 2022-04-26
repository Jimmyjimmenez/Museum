package Presentacion.Controller.Comandos.Tienda.descuento;

import Presentacion.Controller.Context;
import Presentacion.Controller.Eventos;
import Presentacion.Controller.comandos.commandFactory.Command;
import negocio.SAFactoria.SAFactoria;
import negocio.descuento.TDescuento;

public class RegistrarDescuentoCommand implements Command {

	@Override
	public Context execute(Object data) {
		Context context = null;
		int res;
		
		try {
			res = SAFactoria.getInstancia().generarSADescuento().añadirDescuento((TDescuento) data);
			
			if (res > 0)
				context = new Context(Eventos.REGISTRAR_DESCUENTO_OK, "Descuento registrado con ID: " + res);
			else
				context = new Context(Eventos.REGISTRAR_DESCUENTO_KO, "No se ha podido registrar el descuento");
			
		} catch (Exception e) {
			context = new Context(Eventos.REGISTRAR_DESCUENTO_KO, e.getMessage());
		}
		return context;
	}
	
}
