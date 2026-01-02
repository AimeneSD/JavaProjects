import java.util.Scanner;

public class JavaTPEXO3 {


    public static void main(String[] args) {
        Scanner masaisie = new Scanner(System.in);
        System.out.println("Que souhaitez vous faire : 1 = factorielle ; 2 = table de multiplication");
        int choix = masaisie.nextInt();


        if (choix == 1) {
            System.out.println("Saisir un nombre pour afficher sa table de multiplication : ");
            int j = masaisie.nextInt();
            System.out.println("jusqu'où souhaitez vous aller ? : ");
            int k = masaisie.nextInt();
            Tableperso(j, k);
        }
        if (choix==2) {
            System.out.println("Ecrire un nombre pour créer sa factorielle");
            int j = masaisie.nextInt();
            System.out.println(factorielle(j));
            masaisie.close();
        }


        }
    public static void Tableperso(int n,int nb) {
        for (int i=1;i<=nb; i++) {
            System.out.println(i + " * " + n +" = " + (i*n));
        }
    }
    public static int factorielle(int n) {
        int total = 1;
        while (n!=1) {
            total = total*n;
            n-=1;
        }
        return total;
    }

    }