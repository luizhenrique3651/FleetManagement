/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author bruno
 */
public class Carro {
    private int id_carro;
    private String chassi;
    private String placa;
    private String modelo;
    private String ano;
    private String cor;
    private String cilindrada;
    private String tipoCombustivel;
    private double valor_mensal;
    private int km_atual;
    private int km_troca;
    private String disponivel;

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }
    
   

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getValor_mensal() {
        return valor_mensal;
    }

    public void setValor_mensal(double valor_mensal) {
        this.valor_mensal = valor_mensal;
    }

    public int getKm_atual() {
        return km_atual;
    }

    public void setKm_atual(int km_atual) {
        this.km_atual = km_atual;
    }

    public int getKm_troca() {
        return km_troca;
    }

    public void setKm_troca(int km_troca) {
        this.km_troca = km_troca;
    }
    
    
}
