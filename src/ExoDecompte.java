import java.util.Scanner;

public class ExoDecompte {

	
	public static void decompte(int nb) {
		while (nb!=-1) {
			System.out.println(nb + "!");
			nb--;
		}
	}
	public static float HT(float TVA) {
		float ValeurHT = (float) (TVA * 1.2);
		
		return ValeurHT;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner masaisie = new Scanner(System.in);
		int reponse;
		do {
			System.out.println("Entrez votre choix : 1=Decompte ; 2=ValeurHT");
			int choix = masaisie.nextInt();
			if (choix == 1) {
				System.out.println("entrez une valeur de décompte :");
				int dec = masaisie.nextInt();
				decompte(dec);
			}
			if (choix == 2) {
				System.out.println("Entrez une valeur TVA à afficher HT :");
				int tva = masaisie.nextInt();
				System.out.println(HT(tva));
			}
			System.out.println("souahitez vous continuer ? : 1=OUI | 2=NON");
			reponse = masaisie.nextInt();
		}while(reponse == 1);
		masaisie.close();
		System.out.println("FIN DU PROGRAMME");
	}

}
