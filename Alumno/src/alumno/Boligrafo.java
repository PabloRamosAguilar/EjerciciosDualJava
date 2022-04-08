package alumno;

public class Boligrafo extends Producto {
	public Boligrafo() {
		super();
		this.stock = 200;
		this.precio = 0.75;

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
