import java.util.Scanner;

public class navale {
	
	public static int affichagetab(int tab[][], int nbcase) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//1.
		
		int[][] tabjoueur  = new int [10][10];
		int[][] tabordi = new int [10][10];
		int i=0, j=0;
		for(i = 0; i<10 ;i++ ) {
			
			
			
			for(j = 0; j<10; j++) {
				tabjoueur[i][j]=0;
				tabordi[i][j]=0;
				}
			
		//2.
			
		int stock = 5;
		
		do {	
			System.out.println("Veuillez selectionner une case vide et dans la portée du jeu (min 1 | max 10) \nIl vous reste " + stock + " jetons.");
			System.out.println("Selectionnez la ligne où placer votre pion :");
			int rowplayer = scanner.nextInt() - 1;
			System.out.println("Selectionnez la colonne où placer votre pion :");
			int colplayer = scanner.nextInt() - 1;
			if(tabjoueur[rowplayer][colplayer] == 0) {
				tabjoueur[rowplayer][colplayer] = 1;
			}
			else {
				System.out.println("Cet emplacement est déjà occupé, choisissez-en un autre.");
			}
			stock--;
		}while(stock!=0);
		
		
		//à retirer
		scanner.close();
		
		
		
		
		
		
	}

	}
	}
