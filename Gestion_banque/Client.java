import java.util.ArrayList;

class Client {
    private String nom;
    private String adresse;

    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client: " + nom + ", Adresse: " + adresse;
    }
}