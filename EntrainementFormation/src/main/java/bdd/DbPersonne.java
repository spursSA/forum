package bdd;


import classes.Personne;
import interfaces.PersonneDao;
import enums.Sexe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbPersonne implements PersonneDao {

    private ResultSet rset = null;

    private final static String QUERY_FIND_PERSONNES = "SELECT * FROM personne ";


    @Override
    public List<Personne> findPersonnes() throws SQLException {

        GestionBDD gBDD = new GestionBDD();

        gBDD.openConnection();

        List<Personne> personnes = new ArrayList<Personne>();

        try {

            rset = gBDD.getStmt().executeQuery(QUERY_FIND_PERSONNES);

            while (rset.next()) {
               // Personne personne = rsetToPersonne(rset);
                Integer id = rset.getInt("id");
                String nom = rset.getString("nom");
                String prenom = rset.getString("prenom");
                String adresse = rset.getString("adresse");
                String sexeStr = rset.getString("sexe");
                Sexe sexe = Sexe.valueOf(sexeStr);
                Double salaire = rset.getDouble("salaire");

               // System.out.println("id --> " + id + ", nom --> " + nom + ", prenom --> " + prenom);

                Personne personne = new Personne(id, nom, prenom, sexe, adresse, salaire);
                personnes.add(personne);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //methode de fermeture des connections ouvertes
            gBDD.closeConnection();
        }

        return personnes;

    }

    @Override
    public List<Personne> addPersonnes() throws SQLException {
        return null;
    }

}
