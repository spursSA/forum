
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCBaseDeDonnee {

    public class JDBCBaseDeDonnees<Parent> implements JDBCBaseDeDonnees {
        Connection connection;
        private System FXMLLoader;

        @Override
        public void start(Stage primaryStage) throws Exception{


            Connection con = null;

            String url = "jdbc:mysql://127.0.0.1/formation";
            String user = "root";
            String password = "";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            con = DriverManager.getConnection(url, user, password);


            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
*/

