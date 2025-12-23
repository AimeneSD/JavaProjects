import java.util.Scanner;

public class Executable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int relancer = 1;
		int choix;
		Scanner scanner= new Scanner(System.in);
		do{
			System.out.println("Que voulez vous faire ?");
			System.out.println("1: Table multiplication \n2: Factorielle \n3: Chifumi");
			choix = scanner.nextInt();
			switch(choix) {
			case 1:
				Tablemulti.main(args);
				break;
			case 2:
				Factorielle.main(args);;
				break;
			case 3:
				Chifumi.chifumi(args);
				break;
			}
			System.out.println("Voulez-vous relancer un programme ?\nOui: 1 | Non :0");
			relancer = scanner.nextInt();
		
		}while(relancer==1);
		scanner.close();
		}
		
	
}
