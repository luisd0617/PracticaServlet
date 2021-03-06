
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AdairGarcia
 */
public class Controlador extends Connection{

    public Controlador() {
    }
    
    public UsuarioModel login(UsuarioModel usuario){
        ResultSet resultSet;
        UsuarioModel result = new UsuarioModel();
        try {
            PreparedStatement statement = con.prepareCall(
                    "SELECT * FROM usuarios WHERE username= ?  AND password= ?"
            );
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            resultSet = statement.executeQuery();
            if(resultSet.first()){
                result.setId(resultSet.getInt("id"));
                result.setUsername(resultSet.getString("username"));
                return result;
            }else return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return result;
        }
    }
        public UsuarioModel Registro(UsuarioModel usuario){
        UsuarioModel result = new UsuarioModel();
        try {
            String user = usuario.getUsername();
            String contra = usuario.getPassword();
            PreparedStatement statement = con.prepareCall(
                    "INSERT INTO usuarios values(NULL,'"+ user +"','"+ contra +"')"
            );
            statement.executeUpdate();
            
           return usuario;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return result;
        }
    }
}
