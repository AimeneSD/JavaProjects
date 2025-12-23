import java.util.Scanner;

public class JavaTPfonctions {
	
	public static void TABLEN(int n) {
		
		for (int i=0; i<=10; i++) {
			System.out.println(i + " * " + n + " = " + (i*n));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner masaisie = new Scanner(System.in);
		System.out.println("Entrer une valeur");
		int j = masaisie.nextInt();
		TABLEN(j);
		masaisie.close();
		
	}

}
