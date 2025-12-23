import java.util.Scanner;

public class Chifumi {

    public static void main(String[] args){
    	
    }
    
    public static void chifumi(String[] args) throws InterruptedException {
    	Scanner scanner = new Scanner(System.in);
        String relancer; // Déclaré ici pour être visible dans le while

        do {
            // Réinitialisation des variables pour ch	aque NOUVELLE partie complète
            int pscore = 0, aiscore = 0, manche = 1, hitselect = 0;
            int maxpoints = 0;

            System.out.println("En combien de points doit se dérouler la partie ?");
            // Validation simple pour s'assurer qu'on entre un entier
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            maxpoints = scanner.nextInt();

            do {
                System.out.println("\nDébut de la manche " + manche);
                System.out.println("________________________");
                System.out.println("Entrer 1:Pierre 2:Feuille 3:Ciseau");
                System.out.println("________________________");

                boolean saisieValide = false;
                do {
                    if (scanner.hasNextInt()) {
                        hitselect = scanner.nextInt();
                        if (hitselect >= 1 && hitselect <= 3) {
                            switch (hitselect) {
                                case 1: System.out.println("Vous avez choisi Pierre ¤"); break;
                                case 2: System.out.println("Vous avez choisi Feuille __"); break;
                                case 3: System.out.println("Vous avez choisi Ciseau >"); break;
                            }
                            saisieValide = true;
                        } else {
                            System.out.println("L'entrée doit être entre 1 et 3 inclus");
                            // Pas de scanner.next() ici, car nextInt a déjà lu le mauvais chiffre
                        }
                    } else {
                        System.out.println("L'entrée doit être un CHIFFRE entre 1 et 3 inclus");
                        scanner.next(); // Ici c'est bon : on vide la mauvaise saisie (ex: "abc")
                    }
                } while (!saisieValide);

                int ordi = (int) (Math.random() * 3) + 1;
                // Petite pause pour le suspense
                Thread.sleep(3000); 

                switch (ordi) {
                    case 1: System.out.println("L'ordinateur a choisi Pierre ¤"); break;
                    case 2: System.out.println("L'ordinateur a choisi Feuille __"); break;
                    case 3: System.out.println("L'ordinateur a choisi Ciseau >"); break;
                }

                System.out.println("________________________");

                // Logique de victoire
                if (hitselect == ordi) {
                    System.out.println("Egalité ! Pas de points.");
                    // Note: En général au Chifumi, une égalité ne donne de point à personne
                } else if ((hitselect == 1 && ordi == 3) || 
                           (hitselect == 2 && ordi == 1) || 
                           (hitselect == 3 && ordi == 2)) {
                    pscore++;
                    System.out.println("Gagné cette manche !");
                } else {
                    aiscore++;
                    System.out.println("Perdu cette manche !");
                }

                System.out.println("Score -> Ordi : " + aiscore + " | Joueur : " + pscore);
                System.out.println("________________________");
                manche++;

            // CORRECTION IMPORTANTE : && au lieu de ||
            } while (pscore < maxpoints && aiscore < maxpoints);

            if (pscore == maxpoints) {
                System.out.println("\nBRAVO ! Vous avez gagné la partie !");
            } else {
                System.out.println("\nDOMMAGE ! Vous avez perdu la partie !");
            }

            // Nettoyage du tampon Scanner avant de demander du texte
            scanner.nextLine(); 

            System.out.println("Voulez-vous rejouer au Chifumi ? O/N");
            relancer = scanner.nextLine();

        // CORRECTION IMPORTANTE : .equals() pour les Strings
        } while (relancer.equalsIgnoreCase("O")); // equalsIgnoreCase accepte "o" et "O"
        scanner.close();
        System.out.println("Merci d'avoir joué !");
        
    	
    }
    
}