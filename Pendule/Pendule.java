import java.util.Scanner;

public class Pendule {
    public static void jouer(boolean modeFacile) {
        String[] mots = {"ordinateur", "java", "programmation", "pendu", "tableau", "alternance"};
        String motADeviner = mots[(int) (Math.random() * mots.length)];

        char[] lettresDevinees = new char[motADeviner.length()];
        for (int i = 0; i < lettresDevinees.length; i++) {
            lettresDevinees[i] = '_';
        }

        // Mode facile
        if (modeFacile) {
            lettresDevinees[0] = motADeviner.charAt(0);
            lettresDevinees[lettresDevinees.length - 1] = motADeviner.charAt(motADeviner.length() - 1);
        }

        int essaisRestants = 4;
        Scanner scanner = new Scanner(System.in);

        while (essaisRestants > 0 && !motEstDevine(lettresDevinees)) {
            afficherEtat(lettresDevinees, essaisRestants);
            System.out.println("Entrez une lettre :");
            char lettre = scanner.nextLine().charAt(0);

            if (!traiterLettre(lettre, motADeviner, lettresDevinees)) {
                essaisRestants--;
                System.out.println("Mauvaise lettre ! Essais restants : " + essaisRestants);
            }
        }
        if (motEstDevine(lettresDevinees)) {
            System.out.println("Félicitations ! Vous avez deviné le mot : " + motADeviner);
        } else {
            System.out.println("Vous avez perdu. Le mot était : " + motADeviner);
        }

        scanner.close();
    }

    public static boolean traiterLettre(char lettre, String motADeviner, char[] lettresDevinees) {
        boolean trouve = false;
        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre && lettresDevinees[i] == '_') {
                lettresDevinees[i] = lettre;
                trouve = true;
            }
        }
        return trouve;
    }

    public static boolean motEstDevine(char[] lettresDevinees) {
        for (char lettre : lettresDevinees) {
            if (lettre == '_') {
                return false;
            }
        }
        return true;
    }

    public static void afficherEtat(char[] lettresDevinees, int essaisRestants) {
        System.out.print("Mot à deviner : ");
        for (char lettre : lettresDevinees) {
            System.out.print(lettre + " ");
        }
        System.out.println("\nEssais restants : " + essaisRestants);
    }
}