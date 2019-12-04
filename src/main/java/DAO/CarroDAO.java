/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import MODEL.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CarroDAO {

    private Connection connection;

    public CarroDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public void adiciona(Carro carro) {
        String sql = "insert into carro" + "(chassi,placa,modelo,ano,cor,cilindrada,tipoCombustivel,valor_mensal,km_atual,km_troca)" + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, carro.getChassi());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getModelo());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.setString(6, carro.getCilindrada());
            stmt.setString(7, carro.getTipoCombustivel());
            stmt.setDouble(8, carro.getValor_mensal());
            stmt.setInt(9, carro.getKm_atual());
            stmt.setInt(10, carro.getKm_troca());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "inserido com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e);
        }
    }

    public void altera(Carro carro) {
        String sql = "update carro set chassi=?, placa=?, modelo=? , ano=?,cor=?, cilindrada=?,"
                + "tipoCombustivel=?,valor_mensal=?,km_atual=?,km_troca=? where id_carro=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            
            stmt.setString(1, carro.getChassi());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getModelo());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.setString(6, carro.getCilindrada());
            stmt.setString(7, carro.getTipoCombustivel());
            stmt.setDouble(8, carro.getValor_mensal());
            stmt.setInt(9, carro.getKm_atual());
            stmt.setInt(10, carro.getKm_troca());
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void remove(Carro carro) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from carro where id_carro=?");

            stmt.setInt(1, carro.getId_carro());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Carro> getLista() {
        try {

            PreparedStatement stmt = this.connection.prepareStatement("select * from carro order by disponivel ASC");
            ResultSet rs = stmt.executeQuery();
            List<Carro> carros = new ArrayList<Carro>();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId_carro(rs.getInt("id_carro"));
                carro.setChassi(rs.getString("chassi"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getString("ano"));
                carro.setCor(rs.getString("cor"));
                carro.setCilindrada(rs.getString("cilindrada"));
                carro.setTipoCombustivel(rs.getString("tipoCombustivel"));
                carro.setValor_mensal(rs.getDouble("valor_mensal"));
                carro.setKm_atual(rs.getInt("km_atual"));
                carro.setKm_troca(rs.getInt("km_troca"));
                carro.setDisponivel(rs.getString("disponivel"));

                carros.add(carro);
            }
            rs.close();
            stmt.close();
            return carros;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
     public List<Carro> getListaDisponivel() {
        try {

            PreparedStatement stmt = this.connection.prepareStatement("select * from carro where disponivel like '%Disponível%'");
            ResultSet rs = stmt.executeQuery();
            List<Carro> carros = new ArrayList<Carro>();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId_carro(rs.getInt("id_carro"));
                carro.setChassi(rs.getString("chassi"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getString("ano"));
                carro.setCor(rs.getString("cor"));
                carro.setCilindrada(rs.getString("cilindrada"));
                carro.setTipoCombustivel(rs.getString("tipoCombustivel"));
                carro.setValor_mensal(rs.getDouble("valor_mensal"));
                carro.setKm_atual(rs.getInt("km_atual"));
                carro.setKm_troca(rs.getInt("km_troca"));
                carro.setDisponivel(rs.getString("disponivel"));

                carros.add(carro);
            }
            rs.close();
            stmt.close();
            return carros;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public List<Carro> buscaProdutoPorModelo(String modelo) {

        try {

            List<Carro> lista = new ArrayList<>();
            String sql = "select * from carro where modelo like ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, modelo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Carro carro = new Carro();
                carro.setId_carro(rs.getInt("id_carro"));
                carro.setPlaca(rs.getString("Placa"));
                carro.setModelo(rs.getString("Modelo"));
                carro.setAno(rs.getString("Ano"));
                carro.setCor(rs.getString("Cor"));
                carro.setCilindrada(rs.getString("Cilindra"));
                carro.setTipoCombustivel(rs.getString("Tipo Combustivel"));
                carro.setValor_mensal(rs.getDouble("Valor Mensal"));
                carro.setKm_atual(rs.getInt("Km Atual"));
                carro.setKm_troca(rs.getInt("Km Troca"));

                lista.add(carro);

            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
    public void atualizaDisponibilidade(Carro carro){
    
        String sql = "update carro set disponivel=? where id_carro=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, carro.getId_carro());
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
