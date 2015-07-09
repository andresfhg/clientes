/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Andres
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class conectadb {

    /**
     * nombre de la base de datos
     */
    public String db = "clientesandres";

    /**
     * URL del driver
     */
    public String host = "jdbc:mysql://localhost:3306/";

    /**
     * usuario de la bd
     */
    public String user = "root";

    /**
     * contraseña del usuario de la bd
     */
    public String pass = "";

    public String url = host + db + "?user=" + user + "&passaword=" + pass;

    /**
     *
     * @return la coneccion a la base de datos
     */

    public Connection Conectar() {

        Connection link = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);

        }

        return link;

    }

}
