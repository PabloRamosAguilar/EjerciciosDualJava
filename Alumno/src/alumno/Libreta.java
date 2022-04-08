package alumno;


public class Libreta extends Producto {

	public Libreta() {
		super();
		this.stock = 25;
		this.precio = 1.10;

	}

	@Override
	public boolean hayStock(int num) {
		System.out.println(
				"El numero total de stock actual es: " + this.stock + " y se pretende sacar " + num + " libretas");
		boolean hayStockSuficiente = true;
		if (((this.stock - num) < 0)) {
			hayStockSuficiente = false;

			return hayStockSuficiente;
		}

		return hayStockSuficiente;

	}

}
