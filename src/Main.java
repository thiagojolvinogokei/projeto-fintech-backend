public class Main {
    public static void main(String[] args) {
        // Construtor padrão
        Login login = new Login();
        login.doLogin();

        if (login.temAcesso()) {
            Usuario usuario = null;

            if (login.username.equals("CassiaEller")) {
                usuario = new Usuario(
                        DadosUsuarios.ID1,
                        DadosUsuarios.USUARIO1,
                        DadosUsuarios.NOME1,
                        DadosUsuarios.SEXO1,
                        DadosUsuarios.EMAIL1,
                        DadosUsuarios.SALDO1,
                        DadosUsuarios.STATUS1);
            } else if (login.username.equals("BacoExu")) {
                usuario = new Usuario(
                        DadosUsuarios.ID2,
                        DadosUsuarios.USUARIO2,
                        DadosUsuarios.NOME2,
                        DadosUsuarios.SEXO2,
                        DadosUsuarios.EMAIL2,
                        DadosUsuarios.SALDO2,
                        DadosUsuarios.STATUS2);
            } else if (login.username.equals("MMendoca")) {
                usuario = new Usuario(
                        DadosUsuarios.ID3,
                        DadosUsuarios.USUARIO3,
                        DadosUsuarios.NOME3,
                        DadosUsuarios.SEXO3,
                        DadosUsuarios.EMAIL3,
                        DadosUsuarios.SALDO3,
                        DadosUsuarios.STATUS3);
            }

            // Controle de fluxos depois de logar
            login.selecionaAcao();
            usuario.executaAcao(login.retornaAcaoSelecionada());

        }
    }
}
