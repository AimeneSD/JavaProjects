import java.util.Scanner;

public class navale {
	
	//4.
	public static void affichagetab(int tab[][], int nbcase) {
	    System.out.println("");
	    // 4.3 : Affichage des numéros de colonnes
	    System.out.print("   "); 
	    for (int k = 1; k <= nbcase; k++) {
	        System.out.print(k + " ");
	    }
	    System.out.println("");

	    // 4.5 : Boucle pour les lignes (doit être < nbcase)
	    for (int i = 0; i < nbcase; i++) {
	        // 4.4 : Numéro de ligne
	        System.out.print((i + 1) + " ");
	        if (i < 9) System.out.print(" "); // Petit ajustement pour aligner le 10

	        for (int j = 0; j < nbcase; j++) {
	            // 4.4 : Affichage pion (1) ou vague (0)
	            if (tab[i][j] == 1) {
	                System.out.print("o ");
	            } else {
	                System.out.print("~ ");
	            }
	        }
	        System.out.println("");
	    }
	}
	
	public static void affichagetabCache(int tab[][], int nbcase) {
	    System.out.println("");
	    // En-tête des colonnes
	    System.out.print("   ");
	    for (int k = 1; k <= nbcase; k++) {
	        System.out.print(k + " ");
	    }
	    System.out.println("");

	    for (int i = 0; i < nbcase; i++) {
	        System.out.print((i + 1) + " ");
	        if (i < 9) System.out.print(" ");

	        for (int j = 0; j < nbcase; j++) {
	            switch (tab[i][j]) {
	                case 0: // Aucune action 
	                case 1: // Pion non découvert
	                    System.out.print("? ");
	                    break;
	                case 2: // Pion découvert
	                    System.out.print("o ");
	                    break;
	                case 3: // Case vide découverte
	                    System.out.print("x ");
	                    break;
	            }
	        }
	        System.out.println("");
	    }
	}
	
	public static boolean pawncheck(int tab[][], int nbcase) { //Permet de vérifier s'il reste un pion sur un des tableau des joueurs
		
		
		for(int i = 0; i < nbcase; i++) {
			for(int j = 0; j < nbcase; j++) {
				if(tab[i][j]==1) {
					return true;
				}
			}
		}
		return false;
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		int choix = 1;
		do {
			//1.
			int t=5;  //TAILLE DES JEUX
			
			
			int[][] tabplayer  = new int [t][t];
			int[][] tabordi = new int [t][t];
			int i=0, j=0;
			for(i = 0; i<t ;i++ ) {
				for(j = 0; j<t; j++) {
					tabplayer[i][j]=0;
					tabordi[i][j]=0;
					}
			}
				
			//2.
				
			int stock = 5;
	
			while (stock > 0) { // On utilise stock > 0 pour plus de clarté
				affichagetab(tabplayer, t);
			    System.out.println("\nIl vous reste " + stock + " jetons à placer.");
			    System.out.println("Veuillez selectionner une case vide (min 1 | max 10)");
				    
			    System.out.print("Ligne : ");
				int rowplayer = scanner.nextInt() - 1;
				    
				System.out.print("Colonne : ");
				int colplayer = scanner.nextInt() - 1;
	
			    // 1. Vérification du périmètre
				if (rowplayer >= (t-t) && rowplayer < t && colplayer >= (t-t) && colplayer < t) {
				        
				// 2. Vérification si la case est déjà prise
		        if (tabplayer[rowplayer][colplayer] == 0) {
		            tabplayer[rowplayer][colplayer] = 1; // On place le pion
		            stock--; // ON NE DÉCREMENTE QUE SI TOUT EST VALIDE
				            System.out.println("Pion placé !");
				        } else {
				            System.out.println("ERREUR : Cet emplacement est déjà occupé. Recommencez.");
				        }
				        
				    } else {
				        System.out.println("ERREUR : Coordonnées hors du plateau (doivent être entre 1 et 10).");
				    }
				}
			affichagetab(tabplayer, t);
			System.out.println("Tous les pions du joueur sont placés !");
				
			//3.
			
			
			int botstock = 5;
			while(botstock>0) {
				int rowbot = (int)(Math.random()*t);
				int colbot = (int)(Math.random()*t);
	
				if(rowbot >= (t-t) && rowbot < t && colbot >= (t-t) && colbot < t) {
					if(tabordi[rowbot][colbot]==0) {
						tabordi[rowbot][colbot]=1;
						botstock--;
					}
					
				}
			}
			System.out.println("_______________________________");
			System.out.println("Les pions du bot ont été placés");
			
			
			//4.
			do {
				System.out.println("");
				System.out.println("À vous de jouer !\n");
				
				affichagetabCache(tabordi, t);
				
				System.out.println("Sélectionner la ligne à viser");
				int rowplayer = scanner.nextInt()-1;
				
				System.out.println("Sélectionner la colonne à viser");
				int colplayer = scanner.nextInt()-1;
				
				System.out.println("Tir en cours..\n");
				Thread.sleep(2*1000);//Délai de tir
				
				if(tabordi[rowplayer][colplayer]==1) { // vérification de l'exactitude du tir et si pion touché
					System.out.println("Touché !");
					tabordi[rowplayer][colplayer]=2;
				}
				else if(tabordi[rowplayer][colplayer]==0){
					System.out.println("Raté");
					tabordi[rowplayer][colplayer]=3;
				}
				else {
					System.out.println("Tir à blanc !\n");
				}
				
				affichagetabCache(tabordi, t); // On affiche l'état du tableau du bot
				}while(pawncheck(tabplayer, t) && pawncheck(tabordi, t));
				
			
				do {
				System.out.println("Tour de l'ordinateur..\n");
				Thread.sleep(5*1000);
				
				int rowbot, colbot;
				do {
					
				rowbot = (int)(Math.random()*t);
				colbot = (int)(Math.random()*t);
				
				}while(tabplayer[rowbot][colbot]>1);
				
				System.out.println("Le bot tire en " + (rowbot+1) + ", " + (colbot+1) + "\n");
				Thread.sleep(3*1000);
				
				if(tabplayer[rowbot][colbot]==1) {
					System.out.println("Touché ! Un de vos pions à été découvert.\n");
					tabplayer[rowbot][colbot]=2;
				}
				
				if(tabplayer[rowbot][colbot]==0) {
					System.out.println("Raté ! Le bot à tiré dans l'eau\n");
					tabplayer[rowbot][colbot]=3;
				}
				
				affichagetabCache(tabplayer, t);
				
				
			}while(pawncheck(tabplayer, t) && pawncheck(tabordi, t));
			
			System.out.println("Partie terminée !");
			if(pawncheck(tabplayer, t)){
				System.out.println("Vous avez gagné la partie !");
			}
			else{
				System.out.println("Vous avez perdu la partie !");
			}
			System.out.println("Voulez vous rejouer à la bataille navale ? (1 : oui | 2 : non)");
			choix = scanner.nextInt();
		}while(choix==1);
		System.out.println("Merci d'avoir joué !");
		scanner.close();
		
		
		
		
		
		
		
	}

	}
