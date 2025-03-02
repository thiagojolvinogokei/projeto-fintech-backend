import java.util.Scanner;

public class Login {
    public String username;
    private String password;
    private boolean acesso = false;
    private String acaoSelecionada;
    private static final Scanner scanner = new Scanner(System.in); // Scanner global

    // Construtor Padrão
    public Login() {}

    // Construtor com Parâmetros
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método sem retorno
    public void doLogin() {
        if (this.username == null) {
            System.out.println("Seja bem-vindo à HASF!");
            System.out.println("------".repeat(10));
            System.out.print("Digite seu nome de usuário: ");
            this.username = scanner.nextLine();
        }

        int tentativas = 0;

        while (tentativas < 3) {
            if (this.password == null) {
                System.out.print("Digite sua senha: ");
                this.password = scanner.nextLine();
            }

            // Verifica as credenciais usando a classe `DadosUsuarios`
            if (DadosUsuarios.cruzamentoDados(this.username, this.password)) {
                System.out.println("Acesso efetuado com sucesso para o usuário " + this.username);
                this.acesso = true;
                return;
            } else {
                System.out.println("Seu nome de usuário ou senha estão incorretos!");
                tentativas++;

                if (tentativas < 3) {
                    System.out.print("Esqueceu sua senha? (s/n): ");
                    String resposta = scanner.nextLine().trim().toLowerCase();

                    if (resposta.equals("s")) {
                        recuperarSenha(username);
                        tentativas = 0;  // Reseta tentativas após redefinição de senha
                        return;
                    }
                }
                this.password = null; // Resetando senha para nova tentativa
            }
        }

        System.out.println("Seu cadastro foi bloqueado. Entre em contato com o suporte!");
    }

    public boolean temAcesso() {
        return this.acesso;
    }

    public void selecionaAcao() {
        if (!this.temAcesso()) {
            System.out.println("Sem permissão para executar essa função.");
            return;
        }

        System.out.println("O que você gostaria de fazer?");
        System.out.println("0 -> Ver saldo");
        System.out.println("1 -> Realizar transação");
        System.out.println("2 -> Sair");
        System.out.print("Selecione uma opção: ");
        String opcao = scanner.nextLine().trim().toLowerCase();

        switch (opcao) {
            case "0":
                this.acaoSelecionada = "SALDO";
                break;
            case "1":
                this.acaoSelecionada = "TRANSACAO";
                break;
            case "2":
                this.acaoSelecionada = "SAIR";
                break;
            default:
                this.acaoSelecionada = "DEFAULT";
        }
    }

    private void recuperarSenha(String username) {
        System.out.println("Recuperação de senha iniciada para o usuário: " + username);
        System.out.println("Verifique seu e-mail para instruções sobre como redefinir sua senha.");
    }

    public String retornaAcaoSelecionada() {
        return this.acaoSelecionada;
    }
}
