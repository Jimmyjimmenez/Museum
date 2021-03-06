package Presentacion.Controller.Comandos.Tienda.Fabricante;

import Presentacion.Controller.Context;
import Presentacion.Controller.Eventos;
import Presentacion.Controller.Comandos.CommandFactory.Command;
import Negocio.SAFactoria.SAFactoria;

public class BorrarFabricanteCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try{
			int fabricante = SAFactoria.getInstancia().generarSAFabricante().borrarFabricante((Integer) data);
			if (fabricante > 0){
				context = new Context(Eventos.BORRAR_FABRICANTE_OK, "Fabricante borrado con exito");
			}
			else{
				context = new Context(Eventos.BORRAR_FABRICANTE_KO, "Fabricante no encontrado");
			}
		}
		catch(Exception e){
			context = new Context(Eventos.BORRAR_FABRICANTE_KO, e.getMessage());
		}
		return context;
	}
}