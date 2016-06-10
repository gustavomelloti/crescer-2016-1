package br.com.crescer.aula3;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {
    public static void main(String[] args) {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try(ResultSet rs = statement.executeQuery("SELECT * FROM PESSOA")) {
                   while(rs.next()) {
                       System.out.println(rs.getString("NM_PESSOA"));
                   }
                } catch (Exception e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
