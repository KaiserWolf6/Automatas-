public class Automata {
	
	//iterador
	int cont;
	//arreglo de caracteres
	char[] car;
	//Bandera que permite saber si el automata fue aceptado
	boolean aceptado;

	public static void main(String[] args) {
		//Instancia del automata
		Automata a = new Automata();
		//Cadena que recibe
		String cadena = "aaabaabab";
		//Cada elemento de la cadena se va a copiar una posicion de los caracteres
		a.car = cadena.toCharArray();
		a.inicio();
		if (a.aceptado) 
			System.out.println("Cadena aceptada");
		else
			System.out.println("Cadena no aceptada");

	}

	public void inicio() {
		cont = 0;
		aceptado = false;
		q0();
	}
	public void q0(){
		System.out.println("En q0");
		if (cont < car.length) {
			if (car[cont] == 'a') {
				cont ++;
				q0();
			}else if (car[cont] == 'b') {
				cont++;
				q1();
			}
		}
	}

	public void q1(){
		System.out.println("En q1");
		if (cont < car.length) {
			if (car[cont] == 'a') {
				cont ++;
				q1();
			}else if (car[cont] == 'b') {
				cont++;
				q2();
			}
		}
	}

	public void q2(){
		System.out.println("En q2");
		if (cont < car.length) {
			if (car[cont] == 'a') {
				cont ++;
				q2();
			}else if (car[cont] == 'b') {
				cont++;
				q3();
			}
		}		
	}

	public void q3(){
		System.out.println("En q3 es el estado de aceptacion");
		aceptado = true;
		if (cont < car.length) {
			if (car[cont] == 'a') {
				cont ++;
				q3();
			}else if (car[cont] == 'b') {
				cont++;
				qError();
			}
		}		
	}

	public void qError(){
		System.out.println("En estado de error");
		aceptado = false;
		return;
	}		
}