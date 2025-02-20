import java.util.Scanner;

public class Menu {
    public static void afficherMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue au jeu du pendu !");
        System.out.println("Choisissez votre niveau de difficulté :");
        System.out.println("1. Facile (première et dernière lettre révélées)");
        System.out.println("2. Plus dur (aucune lettre révélée)");

        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            Pendule.jouer(true); // Mode facile
        } else if (choix == 2) {
            Pendule.jouer(false); // Mode plus dur
        } else {
            System.out.println("Choix invalide. Veuillez relancer le jeu.");
        }

        scanner.close();
    }
}