package com.patrones;

public class Principal {

	public static void main(String[] args) {
		Fila fila = Fila.getIntsnce();
		
		Thread hilo = new Thread(new Runnable() {
			int contador = 1;
			
			@Override
			public void run() {
				while (contador<=10) {
					try {
						Thread.sleep(1000);
						System.out.println(fila.numeroEnFila());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					contador++;
				}
			}
		});
		
		hilo.start();
		
	}

}
