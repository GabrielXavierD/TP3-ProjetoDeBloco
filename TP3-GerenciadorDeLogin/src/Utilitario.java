import java.io.*;
import java.util.Scanner;

public class Utilitario {
    public static String receberNome() {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o nome do usuário: ");
            String nome = entrada.nextLine().trim();

            if (nome.toLowerCase().equals("sair")) {
                System.out.println("Você saiu!");
                entrada.close();
                System.exit(0);
            }

            if (nome.length() >= 1) {
                if (validarNome(nome)) {
                    return nome;
                } else {
                    System.out.println("Erro: Digite um nome válido com apenas letras e espaços.");
                }
            } else {
                System.out.println("Erro: O nome é inválido! O nome deve ter apenas letras e espaços.");
            }
        }
    }

    public static boolean validarNome(String nome) {
        boolean oNomeEhValido = true;
        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);
            if (letra != ' ' && !Character.isLetter(letra)) {
                return oNomeEhValido = false;
            }
        }
        return oNomeEhValido;
    }

    public static String receberSenha() {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.print("Digite a senha do usuário: ");
            String senha = entrada.nextLine().trim();

            if (senha.toLowerCase().equals("sair")) {
                System.out.println("Você saiu!");
                entrada.close();
                System.exit(0);
            }

            if (senha.length() >= 1) {
                return senha;
            } else {
                System.out.println("Erro: Digite um nome válido com apenas letras e espaços.");
            }
        }
    }
}
