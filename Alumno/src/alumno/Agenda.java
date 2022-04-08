package alumno;

public class Agenda extends Producto {
	public Agenda() {
		super();
		this.stock = 50;
		this.precio = 1.90;

	}

	@Override
	public boolean hayStock(int num) {
		System.out.println(
				"El numero total de stock actual es: " + this.stock + " y se pretende sacar " + num + " boligrafos"
				);
		boolean hayStockSuficiente = true;
		if (((this.stock - num) < 0)) {
			hayStockSuficiente = false;

			return hayStockSuficiente;
		}

		return hayStockSuficiente;

	}
}
