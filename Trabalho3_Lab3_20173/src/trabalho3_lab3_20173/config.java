/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gabriel
 */
public class config {
    private static Connection instancia = null;
    
    public static Connection getConnection() throws Exception {
        if(instancia == null){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driveUrl = "jdbc:derby://localhost:1527/trabalho";
            instancia = DriverManager.getConnection(driveUrl, "usuario", "senha");
        }
        return instancia;
    }

    public static Connection getInstancia() {
        return instancia;
    }

    public static void setInstancia(Connection aInstancia) {
        instancia = aInstancia;
    }
}
