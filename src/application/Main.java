package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payer;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Lista onde os objetos serão instanciados
		List<Payer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		//Instanciar cada objeto por meio da herança
		
		for(int i = 1; i<= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double income = sc.nextDouble();
			
			//Checagem
			if(Character.toLowerCase(ch) == 'i') {
				System.out.print("Health expenditures: ");
				double helthExp = sc.nextDouble();
				
				list.add(new Individual(name, income, helthExp));
			}
			else if(Character.toLowerCase(ch) == 'c') {
				System.out.print("Number of employees: ");
				int numEmp = sc.nextInt();
				
				list.add(new Company(name, income, numEmp));
			}
			else {
				System.out.println("Choose 'Individual' or 'Company'!!!");
				i--;
				System.out.println();
				continue;
			}

		}
		
		//Mostrar os dados na tela
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(Payer payer : list) {
			System.out.println(payer.getName() + ": $" + String.format("%.2f", payer.taxes()));
		}
		
		double total = 0;
		for(Payer payer : list) {
			total += payer.taxes();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", total));
		sc.close();
	}

}
