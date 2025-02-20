class Compte {
    private int numero;
    private int solde;
    private Client proprietaire;

    public Compte(int numero, int solde, Client proprietaire) {
        this.numero = numero;
        this.solde = solde;
        this.proprietaire = proprietaire;
    }
    public int getSolde(){
        return this.solde;
    }
    public void crediter(int montant) {
        this.solde += montant;
    }
    public void debiter(int montant) {
        this.solde -= montant;
    }
    @Override
    public String toString() {
        return "Compte N°" + numero + " | Solde: " + solde + " | Titulaire: " + proprietaire;
    }
}