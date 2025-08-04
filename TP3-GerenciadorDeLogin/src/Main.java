import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-- MENU --");
        System.out.println("1 - Realizar Cadastro (cria o arquivo .csv, caso não tenha)");
        System.out.println("2 - Realizar Login");
        System.out.println("3 - Sair");
        System.out.print("Digite uma opção: ");
        String opcao = entrada.nextLine();
        switch(opcao){
            case "1":
                String nome = Utilitario.receberNome();
                String senha = Utilitario.receberSenha();
                GerenciadorDeLogin.registrarUsuario(nome, senha);
                break;
            case "2":
                String nomeLogin = Utilitario.receberNome();
                String senhaLogin = Utilitario.receberSenha();
                GerenciadorDeLogin.buscarUsuario(nomeLogin, senhaLogin);
                break;
            case "3":
                System.out.println("Você saiu! Sistema encerrado!");
                break;
            default:
                System.out.println("Erro: Digite uma opção válida. Escolha 1, 2 ou 3");
        }
        entrada.close();
    }
}