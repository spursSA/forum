package bdd;

import java.sql.*;

public class GestionBDD {

    final private static String URL = "jdbc:mysql://localhost:3306/formation?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC" +
            "&useSSL=false"; //--> pour gérer l'anomalie --> closing inbound before receiving peer's close_notify
    final private static String LOGIN = "root";
    final private static String PASSWORD = "";

    private Connection con = null;
    private Statement stmt = null;

    public void openConnection() throws SQLException {
        System.out.println("Ouverture BDD !!!!!");
        this.con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        this.stmt = this.con.createStatement();
    }

    public void closeConnection()  {
        System.out.println("Fermeture BDD !!!!!");
        if (this.stmt != null) {
            try {
                // Le stmt.close ferme automatiquement le rset.
                this.stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Statement getStmt() {
        return stmt;
    }
}
