/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import MODEL.Contrato;
import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class UsuarioDAO {
    
        private Connection connection;

    
    public UsuarioDAO(){
     this.connection = new ConnectionFactory().getConnection();
    }
    
    
    public void adiciona(Usuario usuario ){
		String sql = "insert into usuario" + 
                        "(usuario, senha, tipo)" +
                        "values (?, ?, ?)";
		try {
                    PreparedStatement stmt = connection.prepareStatement(sql);

			
                        stmt.setString(1, usuario.getUsuario());
                        stmt.setString(2, usuario.getSenha());
                        stmt.setInt(3, usuario.getTipo());
                        stmt.execute();
			stmt.close();
                        JOptionPane.showMessageDialog(null, "inserido com sucesso!");

		} catch (Exception e) {
			
                        JOptionPane.showMessageDialog(null, "ERRO: "+e);
		}
    
    
    }
    
    public void altera(Usuario usuario) {
		String sql = "update usuario set usuario=?, senha=?, tipo=?"
                        + "where id_usuario=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

                        stmt.setString(1, usuario.getUsuario());
                        stmt.setString(2, usuario.getSenha());
                        stmt.setInt(3, usuario.getTipo());
                        stmt.setInt(4, usuario.getId_usuario());
			stmt.execute();
			stmt.close();
			

		} catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                }
        
	}
public void remove(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
                                "delete from contrato where id_usuario=?");

			stmt.setInt(1, usuario.getId_usuario());
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}


     public List<Usuario> getLista() {
        try {

            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");
            ResultSet rs = stmt.executeQuery();
            List<Usuario> usr = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                

                usr.add(usuario);
            }
            rs.close();
            stmt.close();
            return usr;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
    
}
