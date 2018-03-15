import java.util.Scanner;

public class AutomataParidad {
	
	boolean aceptado;
	int cont;
	char[] car;

	public void inicio() {
		cont = 0;
		aceptado = false;
		q0();
	}

	public void q0() {
		System.out.println("q0 es el estado inicial");
		if (cont < car.length) {
			if (car[cont] == '1') {
				cont++;
				q1();
			} else if (car[cont] == '0') {
				cont ++;
				q3();
			}
		}
	}

	public void q1() {
		System.out.println("En q1");
		if (cont < car.length) {
			if (car[cont] == '0') {
				cont++;
				q2();
			} else if (car[cont] == '1') {
				cont ++;
				q0();
			}
		}		
	}

	public void q2() {
		System.out.println("En q2");
		if (cont < car.length) {
			if (car[cont] == '1') {
				cont++;
				q3();
			} else if (car[cont] == '0') {
				cont ++;
				q1();
			}
		}		
	}

	public void q3() {
		System.out.println("q3 es el estado final");
		aceptado = true;
		if (cont < car.length) {
			if (car[cont] == '0') {
				cont++;
				q0();
			} else if (car[cont] == '1') {
				cont ++;
				q2();
			}
		}		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AutomataParidad a = new AutomataParidad();
		System.out.println("Dame una cadena con ceros y unos: ");
		String cadena = s.next();
		a.car = cadena.toCharArray();
		a.inicio();
		if (a.aceptado) 
			System.out.println("La cadena fue aceptada");	
		else
			System.out.println("La cadena no fu aceptada");
	}

}