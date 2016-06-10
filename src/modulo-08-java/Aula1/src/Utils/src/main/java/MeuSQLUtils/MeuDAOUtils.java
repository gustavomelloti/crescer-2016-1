package MeuSQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MeuDAOUtils {
    private final Connection con;
    
    public MeuDAOUtils(Connection c) {
        con = c;
    }
    
    public ArrayList<String> processarQuery(String query) throws SQLException {
        ArrayList<String> tabela = new ArrayList<>();
        
        try (final Statement statement = con.createStatement();final ResultSet resultSet = statement.executeQuery(query)) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            StringBuilder colunas = new StringBuilder();
            StringBuilder linhas = new StringBuilder();
            
            for (int i = 1; i <= rsmd.getColumnCount(); i++ ) {
                colunas.append(rsmd.getColumnName(i));
            }
          
            tabela.add(colunas.toString());

            while (resultSet.next()) {
                linhas.setLength(0);
                
                for (int i = 1; i <= rsmd.getColumnCount(); i++ ) {
                    linhas.append(resultSet.getString(i));
                }
                
                tabela.add(linhas.toString());
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return tabela;
    }
    
    public void processarNonQuery(String comando) throws Exception {
        try (final Statement statement = con.createStatement()) {
            statement.executeUpdate(comando);
        } catch (Exception ex) {
           throw ex;
        }
    }
    
    public void importarPessoas(String[] arquivo) throws Exception {
        String insert = "INSERT INTO PESSOA (ID, NOME) VALUES (?, ?)";
       
        try (final PreparedStatement preparedStatement = con.prepareStatement(insert)) {
            con.setAutoCommit(false);
            for (int i = 1; i < arquivo.length; i++) {
                preparedStatement.setInt(1, Integer.parseInt(arquivo[i].split(";")[0]));
                preparedStatement.setString(2, arquivo[i].split(";")[1]);
                preparedStatement.executeUpdate();
            }
            con.commit(); 
        } catch (Exception ex) {
            throw ex;
        }
    }
}
