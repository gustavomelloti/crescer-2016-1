
package br.com.crescer.aula3.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO implements IPessoa {
    
    private final Connection con;
    
    public PessoaDAO(Connection c) {
        con = c;
    }
    
    @Override
    public void insert(Pessoa p) {
        String insert = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)"; 
 
        try (final PreparedStatement preparedStatement = con.prepareStatement(insert)) {
            preparedStatement.setString(1 ,p.getNome());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void update(Pessoa p) {
        String insert = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ?"; 
 
        try (final PreparedStatement preparedStatement = con.prepareStatement(insert)) {
            preparedStatement.setString(1 ,p.getNome());
            preparedStatement.setInt(2, p.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void delete(Pessoa p) {
        String delete = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        
        try (final PreparedStatement preparedStatement = con.prepareStatement(delete)) {
            preparedStatement.setInt(1 ,p.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public List<Pessoa> listAll() {
        String query = "SELECT * FROM PESSOA";
       
        try (final Statement statement = con.createStatement();final ResultSet resultSet = statement.executeQuery(query)) {
           return resultToPessoa(resultSet);
        } catch (SQLException ex) {
            try {
                throw ex;
            } catch (SQLException ex1) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return new ArrayList<Pessoa>();
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        String query = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";
       
        try (final Statement statement = con.createStatement();final PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + nome + "%");
            System.out.println(preparedStatement.toString());
            return resultToPessoa(preparedStatement.executeQuery());
        } catch (final SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return new ArrayList<Pessoa>();
    }
    
    private List<Pessoa> resultToPessoa(ResultSet result) throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
      
        while(result.next()) {
            pessoas.add(new Pessoa(result.getInt("ID_PESSOA"), result.getString("NM_PESSOA")));
        }
        
        return pessoas;
    }
}
