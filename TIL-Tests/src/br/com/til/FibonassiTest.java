package br.com.til;

import java.util.Scanner;

public class FibonassiTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe uma sequecia.");
		int teste = scanner.nextInt();
		int[] fibo = new int[teste];
		
		for(int i = 0; i < teste; i++) {
			if(i == 0) {
				fibo[i] = 0;
			}else if (i == 1){
				fibo[i] = 1;
			} else {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		
		for (int i : fibo) {
			System.out.print(i+", ");
		}
		scanner.close();
	}

}
