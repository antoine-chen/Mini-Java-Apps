public class Main {
    public static void main(String[] args) {
        // Création d'un client
        Client client1 = new Client("Antoine", "Rue Barbara");
        System.out.println(client1);

        // Modification de l'adresse
        client1.setAdresse("Rue des Lilas");
        System.out.println(client1);

        // Création d'une banque
        Banque banque = new Banque("Le Crédit Montreuillois");
        banque.ajouterClient(client1);

        // Création d'un compte
        Compte compte1 = new Compte(101, 1000, client1);
        banque.ajouterCompte(compte1);
        System.out.println(compte1);

        // Création d'autres clients et comptes
        Client client2 = new Client("Barbara", "Rue de Paris");
        banque.ajouterClient(client2);

        Compte compte2 = new Compte(102, 500, client2);
        Compte compte3 = new Compte(103, 2500, client2);
        Compte compte4 = new Compte(104, -5000, client2);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);

        // Effectuer des opérations
        compte1.crediter(200);
        System.out.println(compte1);

        compte2.debiter(100);
        System.out.println(compte2);

        banque.afficherClients();
        banque.afficherComptes();
        banque.compteADecouvert(); 
    }
}