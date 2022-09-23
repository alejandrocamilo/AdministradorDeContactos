package mySQL;

import java.sql.*;

public class ConexionDataBase {

    private final String url = "jdbc:mysql://localhost/clientes";
    private final String user = "root";
    private final String password = "";
    private Connection conexion = null;

    public Connection conectar() {
        try {
            conexion = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }

    public void desconectar() {
        if (conexion != null) {

            try {
                conexion.close();

                System.out.println("Desconectado");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
