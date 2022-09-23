package mySQL;

import java.sql.*;
import AppContacto.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OperacionDataBase {

    private ConexionDataBase conexion = new ConexionDataBase();
    private Connection con = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;

    public void insertarRegistro(Contacto miContacto) {

        try {

            con = conexion.conectar();

            String sql = "INSERT INTO CONTACTOS(nombre, apellido, telefono_1, telefono_2, empresa, correo_electronico)"
                       + "VALUES(?,?,?,?,?,?);";

            ps = con.prepareStatement(sql);

            ps.setString(1, miContacto.getNombre());
            ps.setString(2, miContacto.getApellido());
            ps.setString(3, miContacto.getTelefono1());
            ps.setString(4, miContacto.getTelefono2());
            ps.setString(5, miContacto.getEmpresa());
            ps.setString(6, miContacto.getCorreoElectronico());
            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Contacto Creado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            conexion.desconectar();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void modificarRegistro(Contacto miContacto) {

        try {

            con = conexion.conectar();

            String sql = "UPDATE CONTACTOS SET nombre=? , Apellido=? ,telefono_1=?  ,telefono_2=? , empresa=? ,correo_electronico=?"
                       + "WHERE Id=" + miContacto.getId();

            ps = con.prepareStatement(sql);

            ps.setString(1, miContacto.getNombre());
            ps.setString(2, miContacto.getApellido());
            ps.setString(3, miContacto.getTelefono1());
            ps.setString(4, miContacto.getTelefono2());
            ps.setString(5, miContacto.getEmpresa());
            ps.setString(6, miContacto.getCorreoElectronico());

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Contacto Modificado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            conexion.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarRegistro(Contacto miContacto){
         
        String sql = "DELETE FROM CONTACTOS WHERE ID="+miContacto.getId();
        
        try{
           con = conexion.conectar();
           
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Contacto Eliminado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
           
           conexion.desconectar();
         }
         catch(SQLException e){
             e.printStackTrace();
             
         }
    }
    
    
    public ArrayList<Contacto> consultarRegistro() {

        ArrayList<Contacto> listaContactos = new ArrayList();
        Contacto contacto;

        try {
            String sql = "SELECT * FROM CONTACTOS";

            con = conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                contacto = new Contacto(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Telefono_1"),
                        rs.getString("Telefono_2"), rs.getString("Empresa"), rs.getString("Correo_Electronico"));

                listaContactos.add(contacto);

            }

            conexion.desconectar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaContactos;
    }
}
