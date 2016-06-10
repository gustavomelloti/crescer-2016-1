


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RunInsert {
     public static void main(String[] args) {
        String insert = "INSERT INTO PESSOA(ID_PESSOA, NM_PESSOA) VALUES (3, ?)";
        try (final java.sql.Connection connection = ConnectionUtils.getConnection();final PreparedStatement prepared = connection.prepareStatement(insert)) {
            prepared.setString(1, "Gustavosadasd");
            prepared.executeUpdate(insert);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
