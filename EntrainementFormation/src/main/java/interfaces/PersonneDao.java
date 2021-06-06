package interfaces;

import classes.Personne;

import java.sql.SQLException;
import java.util.List;

public interface PersonneDao {

        List<Personne> findPersonnes() throws SQLException;

        List<Personne> addPersonnes() throws SQLException;

}
