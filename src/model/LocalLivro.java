package model;

public class LocalLivro {
    private byte prateleira;
    private byte corredor;
    private byte sessao;

    public LocalLivro(byte prateleira, byte corredor, byte sessao) {
        this.prateleira = prateleira;
        this.corredor = corredor;
        this.sessao = sessao;
    }

    public byte getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(byte prateleira) {
        this.prateleira = prateleira;
    }

    public byte getCorredor() {
        return corredor;
    }

    public void setCorredor(byte corredor) {
        this.corredor = corredor;
    }

    public byte getSessao() {
        return sessao;
    }

    public void setSessao(byte sessao) {
        this.sessao = sessao;
    }

}
