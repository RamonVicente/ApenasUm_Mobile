package com.apenasum.model;

public class Transaction {

    private String idUser;
    private String nomeLogista;
    private String cartaoVigencia;
    private String cartaoReal;
    private String valor;
    private String data_transacao;
    private String latitude;
    private String longitude;
    private String local;
    private String cnpj_logista;
    private int isParcelado;
    private int quantidade_parcela;

    public Transaction() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNomeLogista() {
        return nomeLogista;
    }

    public void setNomeLogista(String nomeLogista) {
        this.nomeLogista = nomeLogista;
    }

    public String getCartaoVigencia() {
        return cartaoVigencia;
    }

    public void setCartaoVigencia(String cartaoVigencia) {
        this.cartaoVigencia = cartaoVigencia;
    }

    public String getCartaoReal() {
        return cartaoReal;
    }

    public void setCartaoReal(String cartaoReal) {
        this.cartaoReal = cartaoReal;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(String data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCnpj_logista() {
        return cnpj_logista;
    }

    public void setCnpj_logista(String cnpj_logista) {
        this.cnpj_logista = cnpj_logista;
    }

    public int getIsParcelado() {
        return isParcelado;
    }

    public void setIsParcelado(int isParcelado) {
        this.isParcelado = isParcelado;
    }

    public int getQuantidade_parcela() {
        return quantidade_parcela;
    }

    public void setQuantidade_parcela(int quantidade_parcela) {
        this.quantidade_parcela = quantidade_parcela;
    }
}
