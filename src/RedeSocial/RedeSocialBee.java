package RedeSocial;

import Usuarios.Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocialBee {
    Scanner sc = new Scanner(System.in);
    RedeSocialBee bee = new RedeSocialBee();
    List<Usuarios> perfis = new ArrayList<Usuarios>();

    public void menuInicial() {
        try {
            System.out.println("»»————-　MENU INICIAL　————-««");
            System.out.println("Digite:");
            System.out.println("1 - para Cadastrar");
            System.out.println("2 - para Login");
            System.out.println("3 - para Fechar");
            int opcaoMenu = sc.nextInt();
            switch (opcaoMenu) {
                case 1:
                    bee.cadastrar();
                    break;
                case 2:
                    bee.login();
                    break;
                case 3:
                    bee.fechar();
                    break;
                default:
                    System.out.println("Comando inválido");
                    bee.menuInicial();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("--- Ta pichuruco?? Da onde tirou isso? ---");
            bee.erro();
        } catch (Exception e) {
            System.out.println(" Comando inválido, sistema será encerrado");
            bee.erro();
        }
    }
    public void cadastrar() {
        System.out.println("Digite seu nome:");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite um logim para cadastrar:");
        String login = sc.next().toUpperCase();
        for (Usuarios usuarios : perfis) {
            while (login.equals(usuarios.getLogin())) {
                System.out.println("Login já existe no cadastro, tente novamente");
                bee.cadastrar();
            }
        }
        System.out.println("Cadastre uma senha de acesso");
        String senha = sc.next();
        while (senha.isEmpty() | senha.isBlank() | login.isEmpty() |login.isBlank() | nome.isBlank() | nome.isEmpty()) {
            System.out.println("Todos os campos são obrigatórios, tentar novamente");
            bee.cadastrar();
        }
        Usuarios usuarios = new Usuarios(nome,login,senha);
        perfis.add(usuarios);
        System.out.println("Cadastro realizado com sucesso");
        bee.menuInicial();
    }
    private void login() {
        if (perfis.isEmpty()) {
            System.out.println("É preciso cadastrar antes de fazer o login...");
            bee.menuInicial();
        }
        System.out.println("---- LOGIN -----");
        System.out.println("Login: ");
        String login = sc.next().toUpperCase();
        System.out.println("Senha: ");
        String senha = sc.next();
        for (Usuarios usuarios : perfis) {
            if (login.equals(usuarios.getLogin()) && senha.equals(usuarios.getSenha())) {
                System.out.println();
                System.out.println("Ola, " + usuarios.getNome() + " !");
                System.out.println("╭════════════════════🐝═╮");
                System.out.println("  Bem vindo/a rede BEE!");
                System.out.println("╰═🐝════════════════════╯");
                usuarios.menuUsuario();
            }
        }
        System.out.println("Login ou senha inválidas, tente novamente");
        bee.listarUsuarios();
        bee.menuInicial();
    }
    public void fechar() {
        System.out.println();
        System.out.println("|￣￣￣￣￣￣￣| ");
        System.out.println("| Volta logo! |");
        System.out.println("|＿＿＿＿＿ _＿|");
        System.out.println("()_() ||");
        System.out.println("(•ㅅ•) || ");
        System.out.println("/ 　 づ");
        System.out.println();
    }

    private void erro() {
        System.out.println("░░░░░░░░░░░░░▄▄▄▄▄▄▄░░░░░░░░░");
        System.out.println("░░░░░░░░░▄▀▀▀░░░░░░░▀▄░░░░░░░");
        System.out.println("░░░░░░░▄▀░░░░░░░░░░░░▀▄░░░░░░");
        System.out.println("░░░░░░▄▀░░░░░░░░░░▄▀▀▄▀▄░░░░░");
        System.out.println("░░░░▄▀░░░░░░░░░░▄▀░░██▄▀▄░░░░");
        System.out.println("░░░▄▀░░▄▀▀▀▄░░░░█░░░▀▀░█▀▄░░░");
        System.out.println("░░░█░░█▄▄░░░█░░░▀▄░░░░░▐░█░░░");
        System.out.println("░░▐▌░░█▀▀░░▄▀░░░░░▀▄▄▄▄▀░░█░░");
        System.out.println("░░▐▌░░█░░░▄▀░░░░░░░░░░░░░░█░░");
        System.out.println("░░▐▌░░░▀▀▀░░░░░░░░░░░░░░░░▐▌░");
        System.out.println("░░▐▌░░░░░░░░░░░░░░░▄░░░░░░▐▌░");
        System.out.println("░░▐▌░░░░░░░░░▄░░░░░█░░░░░░▐▌░");
        System.out.println("░░░█░░░░░░░░░▀█▄░░▄█░░░░░░▐▌░");
        System.out.println("░░░▐▌░░░░░░░░░░▀▀▀▀░░░░░░░▐▌░");
        System.out.println("░░░░█░░░░░░░░░░░░░░░░░░░░░█░░");
        System.out.println("░░░░▐▌▀▄░░░░░░░░░░░░░░░░░▐▌░░");
        System.out.println("░░░░░█░░▀░░░░░░░░░░░░░░░░▀░░░");
    }

    private void listarUsuarios() {
        for (Usuarios usuarios : perfis) {
            System.out.println();
            System.out.println(usuarios.getNome());
            System.out.println(usuarios.getLogin());
            System.out.println(usuarios.getSenha());
        }
    }

}
