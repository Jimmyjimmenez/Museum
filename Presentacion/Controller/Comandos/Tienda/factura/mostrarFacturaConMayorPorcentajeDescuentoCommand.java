package Presentacion.Controller.Comandos.Tienda.factura;

import java.util.List;

import Presentacion.Controller.Context;
import Presentacion.Controller.Eventos;
import Presentacion.Controller.comandos.commandFactory.Command;
import negocio.SAFactoria.SAFactoria;
import negocio.descuento.TDescuento;
import negocio.factura.TFacturaTienda;

public class mostrarFacturaConMayorPorcentajeDescuentoCommand implements Command{

	public Context execute(Object data) {
		Context context;
		try{
			List<TFacturaTienda> facturas = SAFactoria.getInstancia().generarSAFactura().mostrarFacturaConMayorPorcentajeDescuento();
			
			if (facturas != null){
				context = new Context(Eventos.MOSTRAR_FACTURA_CON_MAYOR_PORCENTAJE_DESCUENTO_OK, facturas);
			}
			else{
				context = new Context(Eventos.MOSTRAR_FACTURA_CON_MAYOR_PORCENTAJE_DESCUENTO_KO, "No hay facturas o descuentos");
			}
		}
		catch(Exception e){
			context = new Context(Eventos.MOSTRAR_FACTURA_CON_MAYOR_PORCENTAJE_DESCUENTO_KO, e.getMessage());
		}
		return context;
	}

}
