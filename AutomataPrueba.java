import java.util.Scanner;

public class AutomataPrueba {
	
	boolean aceptado;
	int cont;
	char[] car;

	public void inicio() {
		cont = 0;
		aceptado = true;
		q0();
	}

	public void q0() {
		System.out.println("q0 es el estado inicial");
		if (cont < car.length) {
			if (car[cont] == 'b') {
				cont ++;
				q0();
			} else if (car[cont] == 'a') {
				cont ++;
				q1();
			}
		}
	}

	public void q1() {
		System.out.println("q1 es el estado final");
		aceptado = true;
		if (cont < car.length) {
			if (car[cont] == 'b') {
				cont ++;
				q2();
			} else if (car[cont] == 'a') {
				cont ++;
				q3();
			}
		}		
	}

	public void q2() {
		System.out.println("En q2");
		if (cont < car.length) {
			if (car[cont] == 'b') {
				cont ++;
				q2();
			} else if (car[cont] == 'a') {
				cont ++;
				q0();
			}
		}		
	}

	public void q3() {
		System.out.println("En q3");
		System.out.println("Se ciclara para siempre");
		if (cont < car.length) {
			if (car[cont] == 'a' && car[cont] == 'b') {
				cont ++;
				q3();
			} 
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AutomataPrueba a = new AutomataPrueba();
		System.out.println("Dame una cadena de a's y b's: ");
		String cadena = s.next();
		a.car = cadena.toCharArray();
		a.inicio();
		if (a.aceptado)
			System.out.println("La cadena fue aceptada");
		else
			System.out.println("La cadena no fue aceptada");
	}
}