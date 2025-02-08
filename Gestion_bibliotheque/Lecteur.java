import java.util.ArrayList;

public class Lecteur {
    private String nom;
    private int id;
    private ArrayList<Livre> livresEmpruntes; // Ex : max 3 livres pour un lecteur !

    public Lecteur(String nom, int id){
        this.nom = nom;
        this.id = id;
        this.livresEmpruntes = new ArrayList<>();
    }
    public String getNom(){
        return this.nom;
    }
    public int getId(){
        return this.id;
    }
    public ArrayList<Livre> getLivreEmprunter(){
        return this.livresEmpruntes;
    }

    public void emprunterLivre(Livre livre) {
        if (livresEmpruntes.size() < 3) {
            livresEmpruntes.add(livre);
            livre.emprunter();
            System.out.println(nom + " a emprunté " + livre.getTitre());
        } else {
            System.out.println(nom + " ne peut pas emprunter plus de 3 livres !");
        }
    }

    public void rendreLivre(Livre livre) {
        if (livresEmpruntes.contains(livre)) {
            livresEmpruntes.remove(livre);
            livre.rendre();
            System.out.println(nom + " a rendu " + livre.getTitre());
        } else {
            System.out.println(nom + " n'a pas emprunté ce livre !");
        }
    }
    public void afficherLivresEmpruntes(){
        for (int i = 0; i< livresEmpruntes.size(); i++){
            System.out.println("livre : "+ livresEmpruntes.get(i).getTitre());
        }
    }
}