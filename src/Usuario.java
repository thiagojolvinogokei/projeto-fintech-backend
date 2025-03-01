public class Usuario {
    // Definição das credenciais
    private static final String USUARIO1 = "CassiaEller";
    private static final String SENHA1 = "R&licario11";

    private static final String USUARIO2 = "BacoExu";
    private static final String SENHA2 = "Surre@l1Spot";

    private static final String USUARIO3 = "MMendoca";
    private static final String SENHA3 = "C@saJo@na4";

    // Metodo para cruzar dados
    public static boolean cruzamentoDados(String username, String password) {
        return (username.equals(USUARIO1) && password.equals(SENHA1)) ||
                (username.equals(USUARIO2) && password.equals(SENHA2)) ||
                (username.equals(USUARIO3) && password.equals(SENHA3));
    }
}
