import java.util.Scanner;

public class Factorielle {
	public static int factorielle(int n) {
		int total = 1;
		while (n!=1) {
			total = total * n;
			n-=1;
		}
		
		
		return total;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Ecrire un nombre pour créer sa factorielle");
		Scanner masaisie = new Scanner(System.in);
		int j = masaisie.nextInt();
		System.out.println("La factorielle de "+j + " vaut "+ factorielle(j));
		masaisie.close();
		
	}

}
