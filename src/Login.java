import java.util.Scanner;

public class Login {
    public String username;
    private String password;
    private boolean acesso = false;
    private String acaoSelecionada;
    // Construtor Padrão
    public Login() {
    }

    // Construtor com Parâmetros
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Metodo sem retorno
    public void doLogin() {
        Scanner scanner = new Scanner(System.in);


        if (this.username == null || this.password == null) { //inicia solicitação de usuário e senha
            System.out.println("Seja bem-vindo à HASF!");
            System.out.println("------".repeat(10));
            System.out.print("Digite seu nome de usuario: ");
            this.username = scanner.nextLine();
        }

        int tentativas = 0;


        while (tentativas < 3) {
            if (this.password == null) {
                System.out.print("Digite sua senha: ");
                this.password = scanner.nextLine();
            }

            // Verifica as credenciais usando a classe `Usuarios`
            if (DadosUsuarios.cruzamentoDados(this.username, this.password)) {
                System.out.println("Acesso efetuado com sucesso para o usuário " + this.username);
                this.acesso = true;
                break;
            } else {
                System.out.println("Seu nome de usuario ou senha estão incorretos!");
                tentativas++;

                if (tentativas < 3) {
                    String resposta;
                    do {
                        System.out.print("Esqueceu sua senha? (s/n): ");
                        resposta = scanner.nextLine().trim().toLowerCase();

                        if (resposta.equals("s")) {
                            recuperarSenha(username);
                            return;
                        } else if (!resposta.equals("n")) {
                            System.out.println("Opção inválida! Responda apenas com 's' ou 'n'.");
                        }
                    } while (!resposta.equals("s") && !resposta.equals("n"));

                    // Resetando a senha para nova tentativa
                    this.password = null;
                }
            }
        }

        if (!this.acesso) {
            System.out.println("Seu cadastro foi bloqueado. Entre em contato com o suporte!");
        }

        scanner.close();
    }
    public boolean temAcesso(){
        return this.acesso;
    }

    public void selecionaAcao(){
        if (this.temAcesso()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("O que você gostaria de fazer?");
            System.out.print("Selecione uma opção: ");
            System.out.print("0 -> Ver saldo: ");
            System.out.print("1 -> Realizar transação: ");
            System.out.print("2 -> Sair: ");
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
        System.out.println("Sem permissão para executar essa função.");
    }
    private void recuperarSenha(String username) {
        System.out.println("Recuperação de senha iniciada para o usuário: " + username);
        System.out.println("Verifique seu e-mail para instruções sobre como redefinir sua senha.");
    }
}
