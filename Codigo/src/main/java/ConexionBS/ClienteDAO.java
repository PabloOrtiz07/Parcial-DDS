package ConexionBS;

import Entidades.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public static void registerCliente(Cliente cliente) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = ConexionBS.initDb();
        String sql = "INSERT INTO Cliente (nombre,apellido,dni,correo,nombre_usuario,contrasenia) values (?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, cliente.getNombre());
        stm.setString(2, cliente.getApellido());
        stm.setString(3, cliente.getDni());
        stm.setString(4, cliente.getCorreo());
        stm.setString(5, cliente.getNombreUsuario());
        stm.setString(6, cliente.getContrasenia());
        stm.executeUpdate();
        connection.close();
    }

}
