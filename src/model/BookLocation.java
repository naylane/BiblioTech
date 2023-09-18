package model;

public class BookLocation {
    private String prateleira;
    private String corredor;
    private String sessao;

    public BookLocation(String prateleira, String corredor, String sessao) {
        this.prateleira = prateleira;
        this.corredor = corredor;
        this.sessao = sessao;}
    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }
}
