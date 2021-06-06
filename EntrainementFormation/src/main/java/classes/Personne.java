package classes;

import enums.Sexe;

public class Personne {

    private Integer id;
    private String nom;
    private String prenom;
    private Sexe sexe;
    private String adresse;
    private Double salaire;

    public double getImpot() throws TaxeSalaireException {
        TaxeSalaire tSalaire = new TaxeSalaire();
        return tSalaire.calculerImposition(this.salaire);
    }

   public TaxeSalaire tSalaire;

    public Personne(String nom, String prenom, Sexe sexe, String adresse, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.salaire = salaire;
        this.tSalaire = new TaxeSalaire();
    }

    public Personne(Integer id, String nom, String prenom, Sexe sexe, String adresse, Double salaire) {
        this(nom, prenom, sexe, adresse, salaire);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

}
