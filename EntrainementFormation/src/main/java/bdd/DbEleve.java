package bdd;

import classes.Eleve;
import interfaces.EleveDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbEleve implements EleveDao {

    private ResultSet rset = null;

    private final static String QUERY_FIND_ELEVES = "SELECT * FROM eleve ";


    @Override
    public List<Eleve> findEleves() throws SQLException {

        GestionBDD gBDD = new GestionBDD();

        gBDD.openConnection();

        List<Eleve> eleves = new ArrayList<Eleve>();

        try {

            rset = gBDD.getStmt().executeQuery(QUERY_FIND_ELEVES);

            while (rset.next()) {

                Integer eleve_id = rset.getInt("eleve_id");
                String classe = rset.getString("classe");
                Integer note = rset.getInt("note");

                // System.out.println("id --> " + id + ", nom --> " + nom + ", prenom --> " + prenom);

                Eleve eleve = new Eleve(eleve_id, classe, note);
                eleves.add(eleve);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //methode de fermeture des connections ouvertes
            gBDD.closeConnection();
        }

        return eleves;

    }

    @Override
    public List<Eleve> addEleves() throws SQLException {
        return null;
    }
}
