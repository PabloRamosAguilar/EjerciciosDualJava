package alumno;

import java.util.Scanner;

public class MainProducto {

	private static void preguntarPorStock(Producto producto, Scanner input) {
		String controladorExcepcionInputMismatch = "";
		int comprobadorDeStock = 0;
		final String CUANTO_QUIERES_COMPROBAR = "¿Cuanto quieres comprobar si hay?: ";
		final String REGEX_INPUT_IGUAL_LETRAS = "[a-zA-Z]+";
		final String MENSAJE_ERROR_SCANNER = "¡Introduzca un valor numérico!\n";
		final String HAY_STOCK_SUFICIENTE = "Hay Stock suficiente para realizar dicha operación";
		final String NO_HAY_STOCK_SUFICIENTE = "No hay Stock suficiente para realizar dicha operación";

		System.out.print(CUANTO_QUIERES_COMPROBAR);
		controladorExcepcionInputMismatch = input.nextLine();
		if (controladorExcepcionInputMismatch.matches(REGEX_INPUT_IGUAL_LETRAS)) {
			System.out.print(MENSAJE_ERROR_SCANNER);

		} else {
			comprobadorDeStock = Integer.parseInt(controladorExcepcionInputMismatch);
			System.out.println("\n");

			if (producto.hayStock(comprobadorDeStock)) {
				System.out.println(HAY_STOCK_SUFICIENTE);
			} else {
				System.out.println(NO_HAY_STOCK_SUFICIENTE);
			}
		}
	}

	private static void menu() {
		System.out.println("\tMENU");
		System.out.println("--------------------------");
		System.out.println("1.Comprobar si hay x Stock libretas");
		System.out.println("2.Comprobar si hay x Stock boligrafos");
		System.out.println("3.Comprobar si hay x Stock agenda");
		System.out.println("4.Comprar libretas");
		System.out.println("5.Comprar boligrafos");
		System.out.println("6.Comprar agenda");
		System.out.println("0.Salir del Programa");
		System.out.print("Elige una opción: ");
	}

	private static int recogerCantidadProductosAVender(Scanner input) {
		boolean cantidadValida = false;
		int cantidad = 0;
		do {

			System.out.print("\nElige que cantidad quiere comprar: ");
			try {
				cantidad = Integer.parseInt(input.nextLine());
				cantidadValida = true;
			} catch (Exception e) {
				System.out.print("\nIntroduce un valor numérico como cantidad.\n");
				cantidadValida = false;
			}

		} while (!cantidadValida);

		return cantidad;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Producto libreta = new Libreta();
		Producto boligrafo = new Boligrafo();
		Producto agenda = new Agenda();
		final int SENTINEL = 0;
		String controladorExcepcionMenu = "";
		Integer eleccion = 0;
		final int DESVIAR_EXCEPCION_A_DEFAULT = 7;
		final String MENSAJE_ERROR_SCANNER = "¡Introduzca un valor numérico!\n";
		final String REGEX_INPUT_IGUAL_LETRAS = "[a-zA-Z]+";

		do {

			menu();

			controladorExcepcionMenu = input.nextLine();
			if (controladorExcepcionMenu.matches(REGEX_INPUT_IGUAL_LETRAS)) {
				System.out.print(MENSAJE_ERROR_SCANNER);
				eleccion = DESVIAR_EXCEPCION_A_DEFAULT;
			} else {

				eleccion = Integer.parseInt(controladorExcepcionMenu);
				System.out.println("\n");
			}
			switch (eleccion) {
			case 1:

				preguntarPorStock(libreta, input);

				break;
			case 2:

				preguntarPorStock(boligrafo, input);

				break;
			case 3:

				preguntarPorStock(agenda, input);

				break;
			case 4:

				libreta.vender(recogerCantidadProductosAVender(input));
				break;
			case 5:
				boligrafo.vender(recogerCantidadProductosAVender(input));
				break;
			case 6:
				agenda.vender(recogerCantidadProductosAVender(input));
				break;
			case 0:
				System.out.println("Gracias por usar el programa.\n");
				break;

			default:
				System.out.println("Ha ocurrido un error, intentelo de nuevo.\n");
				break;

			}

		} while (eleccion != SENTINEL);

		input.close();
	}
}
