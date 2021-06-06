package interfaces;

import classes.Eleve;

import java.sql.SQLException;
import java.util.List;

public interface EleveDao {
    List<Eleve> findEleves() throws SQLException;
    List<Eleve> addEleves() throws SQLException;
}
