package classe;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
	static classe c1 = new classe();

	public static void menuBase() {
		System.out.println("1 : Ajouter Etudient");
		System.out.println("2 : Supprimer Etudient");
		System.out.println("3 : Attribuer une note a un élève");
		System.out.println("4 : Afficher Moyenne global");
		System.out.println("0 : Quitter");
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		if(menu == 0) {
			
		}
		else if (menu == 1) {
			System.out.println("Entrez un nom : ");
			String nom = sc.next();
			System.out.println("Entrez un prenom : ");
			String prenom = sc.next();
			System.out.println("Entrez un age : ");
			int age = sc.nextInt();
			System.out.println("Entrez un sexe : ");
			char sexe = sc.next().toCharArray()[0];
			c1.add(new etudient(nom, prenom, age, sexe));
			menuBase();
		}
		else if(menu == 2) {
			menuSup();
		}
		else if(menu == 3) {
			menuNote();
		}
		else if(menu == 4) {
			System.out.println("moyenne : " + c1.getMoyenne());
			menuBase();
		}
		else {
			menuBase();
		}
	}
	
	public static void menuSup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez ne N° correspondant a l'étudient que vous voulez supprimer : ");
		ArrayList al = c1.getListe();
		al.forEach((item)->System.out.println(al.indexOf(item)+" : "+((etudient) al.get(al.indexOf(item))).getNom()));
		System.out.println("-1 : Quitter");
		int menu = sc.nextInt();
		if(menu == -1) {
			menuBase();
		}
		else {
			al.remove(menu);
			menuBase();
		}
	}
	
	public static void menuNote() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez ne N° de l'élève dont vous voulez attribuer une note : ");
		ArrayList al = c1.getListe();
		al.forEach((item)->System.out.println(al.indexOf(item)+" : "+((etudient) al.get(al.indexOf(item))).getNom()));
		System.out.println("-1 : Quitter");
		int menu = sc.nextInt();
		if(menu == -1) {
			menuBase();
		}
		else {
			System.out.println("Entrez une note : ");
			int note = sc.nextInt();
			((etudient)al.get(menu)).addNote(note);
			menuBase();
		}
	}
	
	public static void main(String[] args) {
		menuBase();
		
	}

}
