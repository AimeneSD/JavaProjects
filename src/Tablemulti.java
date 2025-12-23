import java.util.Scanner;

public class Tablemulti {
	
	public static void Tablemultiplication(int n, int nb) {
		for (int i=1;i<=nb; i++) {
			System.out.println(i + " * " + n +" = " + (i*n));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner masaisie = new Scanner(System.in);
		System.out.println("Saisir un nombre pour afficher sa table de multiplication : ");
		int j = masaisie.nextInt();
		System.out.println("jusqu'où souhaitez vous aller ? : ");
		int k = masaisie.nextInt();
		Tablemultiplication(j,k);
		masaisie.close();
		
	}

}