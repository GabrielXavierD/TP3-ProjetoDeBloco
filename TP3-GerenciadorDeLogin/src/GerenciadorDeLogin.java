import java.io.*;

public class GerenciadorDeLogin {
    public static boolean buscarUsuario(String usuarioLogin, String senhaLogin){
        final String ARQUIVO_LOGIN = "login.csv";
        boolean usuarioEncontrado = false;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_LOGIN));
            String linha = leitor.readLine();

            while (linha != null) {
                String[] dadosUsuario = linha.split(",");
                if(dadosUsuario.length == 2){
                    String usuario = dadosUsuario[0].trim();
                    String senha = dadosUsuario[1].trim();

                    if(usuario.equals(usuarioLogin) && senha.equals(senhaLogin)){
                        System.out.println("Login realizado com sucesso!");
                        usuarioEncontrado = true;
                        break;
                    }
                }
                linha = leitor.readLine();
            }
            leitor.close();

            if (!usuarioEncontrado) {
                System.out.println("O usuário não foi encontrado no sistema! Ele será registrado.");
                GerenciadorDeLogin.registrarUsuario(usuarioLogin, senhaLogin);
            }

        }catch(IOException erro){
            System.out.println("Erro: não foi possível realizar a leitura do arquivo (" + ARQUIVO_LOGIN + ") : " + erro.getMessage());
        }
        return usuarioEncontrado;
    }


    public static void registrarUsuario(String usuario, String senha){
        final String ARQUIVO_LOGIN = "login.csv";
        boolean usuarioJaExisteNoArquivo = false;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_LOGIN));
            String linha = leitor.readLine();

            while (linha != null) {
                String[] dadosUsuario = linha.split(",");
                if (dadosUsuario.length == 2) {
                    String usuarioExistente = dadosUsuario[0].trim();
                    if (usuarioExistente.equals(usuario)) {
                        usuarioJaExisteNoArquivo = true;
                        break;
                    }
                }
                linha = leitor.readLine();
            }
            leitor.close();
        } catch (IOException erro) {
                System.out.println("O arquivo de 'login.csv' ainda não existe, ele será criado.");
        }

        if (usuarioJaExisteNoArquivo) {
            System.out.println("Usuário já está registrado! Registro cancelado.");
            return;
        }

        Usuario novoUsuario = new Usuario(usuario, senha);
        try {
            BufferedWriter gravador = new BufferedWriter(new FileWriter(ARQUIVO_LOGIN, true));
            gravador.write(novoUsuario.exibirDadosUsuario() + "\n");
            System.out.println("O usuário foi registrado com sucesso!");
            gravador.close();
        } catch (IOException erro) {
            System.out.println("Erro: falha ao criar arquivo (" + ARQUIVO_LOGIN + ") : " + erro.getMessage());
        }
    }
}
