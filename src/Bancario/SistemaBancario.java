package Bancario;
import Scanner.InputScanner;

import java.time.LocalTime;
import java.util.Scanner;

import static Service.SistemaBancarioService.Login;
import static Service.SistemaBancarioService.cadastrar;

public class SistemaBancario  {
    private static final Scanner scanner = InputScanner.getScanner();

    public static void main(String[] args) {
        try {

            LocalTime horaAtual = LocalTime.now();
            int hora = horaAtual.getHour();

            if (hora >= 6 && hora <= 12) {
                System.out.println("Primeiramente, bom dia, né? É a base da educação.");
            } else if (hora >= 12 && hora <= 18) {
                System.out.println("Primeiramente, boa tarde, né? É a base da educação.");
            } else {
                System.out.println("Primeiramente, boa noite, né? É a base da educação.");
            }

             System.out.print("Carregando");
            try {

                for (int i = 0; i < 3; i++) {
                    Thread.sleep(2000);
                    System.out.print(".");
                }}catch (InterruptedException e){
                    e.printStackTrace();
                }

            System.out.println("\nEntrando no Sistema");
            Thread.sleep(2000);


            int opcao = 0;
            while (opcao != 3) {
                System.out.println("\nSistema Bancario");
                System.out.println("1. Cadastrar");
                System.out.println("2.Fazer login");
                System.out.println("3. Sair");
                System.out.println("Escolha uma opção: ");


                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        Login();
                        break;
                    case 3:
                        System.out.println("saindo do sistema ");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.out.println("Entrada invalida! insira um número.");
            throw new RuntimeException(e);
        }
    }}