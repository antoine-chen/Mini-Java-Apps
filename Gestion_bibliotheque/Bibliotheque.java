import java.util.ArrayList;

public class Bibliotheque {
    private ArrayList<Livre> livres;
    private ArrayList<Lecteur> lecteurs;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.lecteurs = new ArrayList<>();
    }

    public void ajouterLivre(String titre, String auteur, String isbn){
        Livre nouveauLivre = new Livre(titre, auteur, isbn, true );
        livres.add(nouveauLivre);
    }
    public void ajouterLecteur(String nom, int id ){
        Lecteur nouveauLecteur = new Lecteur(nom, id );
        lecteurs.add(nouveauLecteur);
    }

    public void supprimerLivre(String isbn){
        for (int i=livres.size()-1; i>=0; i--){
            if (livres.get(i).getIsbn().equals(isbn)){
                livres.remove(i);
            }
        }
    }
    public void supprimerLecteurAFK(){
        for (int i=lecteurs.size()-1; i>=0; i--){
            if (lecteurs.get(i).getLivreEmprunter().isEmpty()){
                lecteurs.remove(i);
            }
        }
    }


    public void afficherLivres(){
        for (int i=0; i<livres.size(); i++){
            System.out.println("Les livres de la bibliotheque : "+livres.get(i).getTitre());
        }
    }
    public void afficherLivresDisponible(){
        for (Livre livre : livres) {
            if (livre.isDisponible()) {
                System.out.println("Voici les livres diso : " + livre.getTitre());
            }
        }
    }

    public boolean rechercherLivre(String titre){
        for (int i=0; i<livres.size(); i++){
            if (livres.get(i).getTitre().equals(titre) ){
                return true;
            }
        }
        return false;
    }
    public boolean rechercherAuteur(String auteur){
        for (int i=0; i<livres.size(); i++){
            if (livres.get(i).getAuteur().equals(auteur) ){
                return true;
            }
        }
        return false;
    }

    public void rechercherLecteur(int id){
        Lecteur lecteur= null;
        for (int i=0; i<lecteurs.size(); i++){
            if (lecteurs.get(i).getId()==id){
                lecteur = lecteurs.get(i);
                System.out.println("Information sur le Lecteur : "+lecteur.getNom()+" son id : "+lecteur.getId()+" sa liste de livre : "+lecteur.getLivreEmprunter());
            }
        }
    }

    public Lecteur trouverLecteur(int idLecteur ){
        boolean lecteurTrouve = false;
        Lecteur lecteur = null;
        for (int i = 0; i < lecteurs.size() && !lecteurTrouve; i++) {
            if (lecteurs.get(i).getId() == idLecteur) {
                lecteurTrouve = true;
                lecteur = lecteurs.get(i);
            }
        }
        return lecteur;
    }
    public Livre trouvreLivre(String isbn){
        boolean livreTrouve = false;
        Livre livre = null;
        for (int i = 0; i < livres.size() && !livreTrouve; i++) {
            if (livres.get(i).getIsbn().equals(isbn)) {
                livreTrouve = true;
                livre = livres.get(i);
            }
        }
        return livre;
    }


    public void emprunterLivre(int idLecteur, String isbnLivre) {
        Lecteur lecteur = trouverLecteur(idLecteur);
        Livre livre = trouvreLivre(isbnLivre);

        if (lecteur == null || livre == null) {
            System.out.println("introuvable");
            return;
        }
        if (!livre.isDisponible()) {
            System.out.println("Le livre " + livre.getTitre() + " est déjà emprunté.");
            return;
        }
        lecteur.emprunterLivre(livre);
        livre.emprunter();
        System.out.println(lecteur.getNom() + " a emprunté " + livre.getTitre());
    }

    public void rendreLivre(int idLecteur, String isbnLivre) {
        Lecteur lecteur = trouverLecteur(idLecteur);
        Livre livre = trouvreLivre(isbnLivre);

        if (lecteur == null || livre == null) {
            System.out.println("introuvable");
            return;
        }
        lecteur.rendreLivre(livre);
        livre.rendre();
        System.out.println(lecteur.getNom() + " a rendu " + livre.getTitre());

        if (!livre.getFileDattente().isEmpty()){
            Lecteur prochain  = livre.getFileDattente().remove(0);
            prochain.emprunterLivre(livre);
            System.out.println(prochain.getNom()+" a emprumté "+livre.getTitre());
        }
    }

}