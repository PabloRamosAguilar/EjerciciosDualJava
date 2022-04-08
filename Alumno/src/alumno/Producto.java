package alumno;




public abstract class Producto implements IVendible {

	protected Double precio;
	protected Integer stock;

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	
	public void vender(int cantidad) {
		Double precioFinal = 0d;
		precioFinal = this.precio * cantidad;
		Integer stockDisponible = this.stock - cantidad;
		if (stockDisponible < 0) {
			System.out.println("\nEl stock es inferior a la cantidad a comprar");
		} else {
			this.stock = stockDisponible;
			System.out.println("\nSe han comprado " + cantidad + " por " + precioFinal + " euros y quedan "
					+ stockDisponible + " Unidades");
		}

	}

}
