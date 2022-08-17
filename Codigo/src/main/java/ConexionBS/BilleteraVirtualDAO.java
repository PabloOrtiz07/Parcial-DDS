package ConexionBS;

import Entidades.BilleteraVirtual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BilleteraVirtualDAO {

    public static void registerBilletera(BilleteraVirtual billeteraVirtual) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = ConexionBS.initDb();
        String sql = "INSERT INTO Billetera (billetera_id) values (?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, billeteraVirtual.getIdBilleteraVirtual());
        stm.executeUpdate();
        connection.close();
    }
}
