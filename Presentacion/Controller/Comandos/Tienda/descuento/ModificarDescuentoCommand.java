package Presentacion.Controller.Comandos.Tienda.Descuento;

import Presentacion.Controller.Context;
import Presentacion.Controller.Eventos;
import Presentacion.Controller.Comandos.CommandFactory.*;
import Negocio.SAFactoria.SAFactoria;
import Negocio.Descuento.TDescuento;

public class ModificarDescuentoCommand implements Command {

	@Override
	public Context execute(Object data) {
		Context context = null;
		int res;
		
		try {
			res = SAFactoria.getInstancia().generarSADescuento().modificarDescuento((TDescuento) data);
			
			if (res > 0)
				context = new Context(Eventos.MODIFICAR_DESCUENTO_OK, "Descuento modificado");
			else
				context = new Context(Eventos.MODIFICAR_DESCUENTO_KO, "Descuento no encontrado");
		} catch (Exception e) {
			context = new Context(Eventos.MODIFICAR_DESCUENTO_KO, e.getMessage());
		}
		
		return context;
	}

}
