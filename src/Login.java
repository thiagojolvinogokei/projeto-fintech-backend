import java.util.Scanner;

public class Login {
    private String username;
    private String password;

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
            System.out.print("Digite seu ID: ");
            this.username = scanner.nextLine();
        }

        int tentativas = 0;
        boolean acesso = false;

        while (tentativas < 3) {
            if (this.password == null) {
                System.out.print("Digite sua senha: ");
                this.password = scanner.nextLine();
            }

            // Verifica as credenciais usando a classe `Usuarios`
            if (Usuario.cruzamentoDados(this.username, this.password)) {
                System.out.println("Acesso efetuado com sucesso para o usuário " + this.username);
                acesso = true;
                break;
            } else {
                System.out.println("Seu ID ou senha estão incorretos!");
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

        if (!acesso) {
            System.out.println("Seu cadastro foi bloqueado. Entre em contato com o suporte!");
        }

        scanner.close();
    }

    private void recuperarSenha(String username) {
        System.out.println("Recuperação de senha iniciada para o usuário: " + username);
        System.out.println("Verifique seu e-mail para instruções sobre como redefinir sua senha.");
    }
}
