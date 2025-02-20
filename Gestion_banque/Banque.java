import java.util.ArrayList;
class Banque {

    private String nom;
    private ArrayList<Client> clients;
    private ArrayList<Compte> comptes;

    public Banque(String nom) {
        this.nom = nom;
        this.clients = new ArrayList<>();
        this.comptes = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void afficherClients() {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void afficherComptes() {
        for (Compte compte : comptes) {
            System.out.println(compte);
        }
    }

    public int getNombreClients() {
        return clients.size();
    }

    public int getNombreComptes() {
        return comptes.size();
    }

    public void effectuerDebit(int numero, int montant) {
        for (Compte compte : comptes) {
            if (compte.toString().contains("N°" + numero)) {
                compte.debiter(montant);
            }
        }
    }

    public void modifierAdresseClient(String nom, String nouvelleAdresse) {
        for (Client client : clients) {
            if (client.getNom().equals(nom)) {
                client.setAdresse(nouvelleAdresse);
            }
        }
    }
    public void compteADecouvert() {
        for (int i = 0; i < comptes.size(); i++) {
            Compte compte = comptes.get(i); 
            if (compte.getSolde() < 0) { 
                System.out.println("Le compte est à découvert.");
            }
        }
    }
}