package util;

public class Menu {
    public static void menuPrincipal() {
        System.out.println("======================================================");
        System.out.println("Bem vindo! Escolha uma das opções para prosseguir:");
        System.out.println("1 - Cadastramento");
        System.out.println("2 - Exibição de cadastros");
        System.out.println("3 - Alteração de cadastros");
        System.out.println("4 - Exclusão de cadastros");
        System.out.println("0 - Sair");
    }


    public static void menuExibicao(){
        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Exibir todos não alunos cadastradas");
        System.out.println("2 - Exibir todos os alunos cadastrados");
        System.out.println("3 - Exibir todos");
        System.out.println("0 - Voltar");
    }
}