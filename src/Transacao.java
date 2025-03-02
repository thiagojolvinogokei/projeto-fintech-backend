import java.util.Date;

public class Transacao {
    private String id;
    private double valor;
    private String tipo;
    private Usuario usuario;
    private String contaRecebedora;

    public Transacao(String id, double valor, String tipo, Usuario usuario, String contaRecebedora) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.usuario = usuario;
        this.contaRecebedora = contaRecebedora;
    }

    public void exibirDetalhes() {
        System.out.println("Transação: " + id);
        System.out.println("Valor: " + valor);
        System.out.println("Tipo: " + tipo);
        System.out.println("Usuário: " + usuario.getNomeUsuario());
        System.out.println("Conta Recebedora: " + contaRecebedora);
    }
}
