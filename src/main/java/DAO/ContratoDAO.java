package DAO;

import JDBC.ConnectionFactory;
import MODEL.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContratoDAO {
    private Connection connection;
    
	public ContratoDAO() {
		this.connection = new ConnectionFactory().getConnection();

	}
        
public void adiciona(Contrato contrato ){
		String sql = "insert into contrato" + 
                        "(valor_anual, id_cliente, id_carro)" +
                        "values (?, ?, ?)";
		try {
                    PreparedStatement stmt = connection.prepareStatement(sql);

			
                        stmt.setDouble(1, contrato.getValor_anual());
                        stmt.setInt(2, contrato.getId_cliente());
                        stmt.setInt(3, contrato.getId_carro());
                        stmt.execute();
			stmt.close();
                        JOptionPane.showMessageDialog(null, "inserido com sucesso!");

		} catch (Exception e) {
			
                        JOptionPane.showMessageDialog(null, "ERRO: "+e);
		}
}
public void altera(Contrato contrato) {
		String sql = "update contrato set valor_anual=?, id_cliente=?,"
                        + " id_carro=?  where id_contratoo=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

                        stmt.setDouble(1, contrato.getValor_anual());
                        stmt.setInt(2, contrato.getId_cliente());
                        stmt.setInt(3, contrato.getId_carro());
			stmt.execute();
			stmt.close();
			

		} catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                }
        
	}
public void remove(Contrato contrato) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
                                "delete from contrato where id_contrato=?");

			stmt.setInt(1, contrato.getId_contrato());
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}


public List<Contrato> getLista() {
		try {

	PreparedStatement stmt = this.connection.prepareStatement("SELECT "
                + "contrato.id_contrato, contrato.valor_anual, carro.Modelo, cliente.nome\n" +
                   "FROM   contrato \n" +
                    "INNER JOIN carro   ON contrato.id_carro   = carro.id_carro\n" +
                    "INNER JOIN cliente ON contrato.id_cliente = cliente.id_cliente;");
			ResultSet rs = stmt.executeQuery();
			List<Contrato> contratos = new ArrayList<Contrato>();
			while (rs.next()) {
				Contrato cont = new Contrato();
				cont.setId_contrato(rs.getInt("id_contrato"));
				cont.setValor_anual(rs.getDouble("valor_anual"));
                                cont.setModelo(rs.getString("modelo"));
                                cont.setNome(rs.getString("nome"));

				contratos.add(cont);
			}
			rs.close();
			stmt.close();
			return contratos;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
                           return null;
		}
     
           
	}
/*
 public List<Estoque> buscaProdutoPorNome(String nome){
    
       try {
            
            List<Estoque> lista = new ArrayList<>();
            String sql= "select * from estoque where descricao like ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            
            Estoque obj = new Estoque();
            
            obj.setId_produto(rs.getInt("id_produto"));
            obj.setQuantidade(rs.getInt("quantidade"));
            obj.setDescricao(rs.getString("descricao"));
            obj.setPreco(rs.getDouble("preco"));
            
            
            
            lista.add(obj);
            
            
            
            }
            
           return lista;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
  public Estoque consultaPorNome(String nome){
        try {
 
            String sql= "select * from estoque where descricao like ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();   
            Estoque obj = new Estoque();

             if(rs.next()){
            
            
             obj.setId_produto(rs.getInt("id_produto"));
            obj.setQuantidade(rs.getInt("quantidade"));
            obj.setDescricao(rs.getString("descricao"));
            obj.setPreco(rs.getDouble("preco"));
            
            
            
            
            }
             return obj;
        
        
        
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro, cliente não encontrado,"
                    + "para mais detalhes segue o codigo detalhado: \n"+ e);
            return null;
            
            
        }
    }

  public void alteraQuantidade(Estoque estoque) {
		String sql = "update estoque set quantidade=?  where id_produto=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, estoque.getQuantidade());
			stmt.setInt(2, estoque.getId_produto());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Erro ao alterar estoque: "+ e);
                }
	}
  
    */

}






