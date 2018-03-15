public class AutomataPar  {
	
	boolean aceptado;
	char[] car;
	int cont;

	public void inicio() {
		cont = 0;
		aceptado = false;
		q0();
	}

	public void q0() {
		System.out.println("Estado inicial q0");
		if (cont < car.length) {
			if (car[cont] == '0') {
				cont ++;
				q0();
			} else if (car[cont] == '1') {
				cont ++;
				q1();
			}
		}
	}

	public void q1() {
		System.out.println("Estado final q1");
		aceptado = true;
		if (cont < car.length) {
			if (car[cont] == '0') {
				cont ++;
				q1();
			} else if (car[cont] == '1') {
				cont ++;
				q0();
			}
		}
	}

	public static void main(String[] args) {
		AutomataPar a = new AutomataPar();
		String cadena = "000100001";
		a.car = cadena.toCharArray();
		a.inicio();
		if (a.aceptado) 
			System.out.println("La cadena fue aceptada");
		else 
			System.out.println("La cadena no fue aceptada");
	}
}