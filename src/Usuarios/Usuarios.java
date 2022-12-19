package Usuarios;

import Postagens.Postagens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Usuarios {
    static Scanner sc = new Scanner(System.in);
    private final String login;
    private final List<Postagens> timelime;
    private String nome;
    private String senha;

    public Usuarios(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.timelime = new ArrayList<Postagens>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Postagens> getTimelime() {
        System.out.println("-----Timeline " + getNome() + "-----");
        for (Postagens postagens : timelime) {
            System.out.println(postagens.getLocalHour() + " - " + postagens.getLocalDate());
            System.out.println(postagens.getConteudo());
            System.out.println();
        }
        return null;
    }

    public void menuUsuario() {
        try {
            System.out.println();
            System.out.println("----- MENU DO USUÁRIO -----");
            System.out.println("digite 1 - para Postar");
            System.out.println("digite 2 - para Timeline");
            System.out.println("digite 3 - para Sair");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    postar();
                    break;
                case 2:
                    if (timelime.isEmpty()) {
                        System.out.println("Você ainda não fez nenhuma publicação");
                    }
                    getTimelime();
                    break;
                case 3:
                    System.out.println("Logout realizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("--- Ta pichuruco?? Da onde tirou isso? ---");
        } catch (Exception e) {
            System.out.println(" Comando inválido, sistema será encerrado");
        }
    }

    public void postar() {
        System.out.println("O que tem a dizer?");
        sc.nextLine();
        String post = sc.nextLine();
        Postagens postagens = new Postagens(post);
        timelime.add(postagens);
        System.out.println("Publicação registrada com sucesso!");
        menuUsuario();
    }
}