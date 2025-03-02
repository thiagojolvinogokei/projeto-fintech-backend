public class DadosUsuarios {
    // Definição das credenciais, retornados como se fossem dados persistidos em um banco de dados

    public static final int ID1 = 1;
    public static final String USUARIO1 = "CassiaEller";
    private static final String SENHA1 = "R&licario11";

    public static final String NOME1 = "Thiago Jolvino";
    public static final String SEXO1 = "M";
    public static final String EMAIL1 = "thiagojolvino@gmail.com";
    public static final double SALDO1 = 2000.0;
    public static final String STATUS1 = "ATIVO";

    public static final int ID2 = 2;
    public static final String USUARIO2 = "BacoExu";
    private static final String SENHA2 = "Surre@l1Spot";
    public static final String NOME2 = "Daniel Moreira";
    public static final String SEXO2 = "M";
    public static final String EMAIL2 = "danielmoreira@gmail.com";
    public static final double SALDO2 = 3000.0;
    public static final String STATUS2 = "INATIVO";

    public static final int ID3 = 3;
    public static final String USUARIO3 = "MMendoca";
    private static final String SENHA3 = "C@saJo@na4";
    public static final String NOME3 = "Ivan";
    public static final String SEXO3 = "M";
    public static final String EMAIL3 = "ivan@gmail.com";
    public static final double SALDO3 = 1000.0;
    public static final String STATUS3 = "ATIVO";

    // Metodo para cruzar dados
    public static boolean cruzamentoDados(String username, String password) {
        return (username.equals(USUARIO1) && password.equals(SENHA1)) ||
                (username.equals(USUARIO2) && password.equals(SENHA2)) ||
                (username.equals(USUARIO3) && password.equals(SENHA3));
    }


}
