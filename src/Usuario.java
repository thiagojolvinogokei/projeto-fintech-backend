import java.util.Date;
import java.util.Scanner;

public class Usuario {
    private int id;
    private String nomeUsuario;
    private String nome;
    private String sexo;
    private String email;
    private double saldo;
    private String status;

    public Usuario(int id, String nomeUsuario, String nome, String sexo, String email, double saldo, String status) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.saldo = saldo;
        this.status = status;
    }

    public void executaAcao(String acao) {
        if (acao.equals("SALDO")) {
            this.verSaldo();
        } else if (acao.equals("TRANSACAO")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o valor da transação: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            System.out.print("Digite a conta de destino: ");
            String contaDestino = scanner.nextLine();
            this.transaciona(valor, contaDestino);
            this.verSaldo(); // Mostrar saldo atualizado
        }
    }

    private void verSaldo() {
        System.out.println("Seu saldo é de: " + saldo);
    }

    private void transaciona(double valorTransacionado, String contaRecebedora) {
        if (valorTransacionado > 0 && saldo >= valorTransacionado) {
            Transacao transacao = new Transacao("T" + System.currentTimeMillis(), valorTransacionado, "Débito", this, contaRecebedora);
            this.diminuirSaldo(valorTransacionado); // Atualizar saldo do usuário
            System.out.println("Transação realizada com sucesso!");
            transacao.exibirDetalhes();
        } else {
            System.out.println("Saldo insuficiente para a transação.");
        }
    }

    public void diminuirSaldo(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
