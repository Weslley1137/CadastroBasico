package Service;

import Conta.ContaUsuario;

import java.util.HashMap;
import static Scanner.InputScanner.scanner;


public class SistemaBancarioService {

    private static HashMap<String, ContaUsuario> contas = new HashMap<>();
    public static void cadastrar(){
        try{

        System.out.println("Digite um nome de usuário");
        String nomeUsuario = scanner.nextLine();

        if(contas.containsKey(nomeUsuario)){
            System.out.println("Nome de usuario ja está em uso.");
            return;
        }


        System.out.println("Digite uma senha: ");
        String senha = scanner.nextLine();

        contas.put(nomeUsuario, new ContaUsuario(nomeUsuario, senha));
        System.out.println("Cadastro realizado com sucesso.");

    }catch (Exception e){
            System.out.println("Erro ao realizar cadastro: " + e.getMessage());
            throw new RuntimeException(e);
        }}

    public static void Login(){
        try{
        System.out.println("Digite seu nome de usuário: ");
        String nomeUsuario = scanner.nextLine();

        if(!contas.containsKey(nomeUsuario)){
            System.out.println("usuario não encontrado.");
            return;
        }
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        ContaUsuario conta = contas.get(nomeUsuario);
        if(conta.autenticar(senha)){
            System.out.println("Login realizado com sucesso!");
            menuConta(conta);
        }else{
            System.out.println("Senha incorreta.");
        }
    }catch (Exception e){
        System.out.println("Erro ao realizar login: " + e.getMessage());
        throw new RuntimeException(e);
     }
    }

    private static void menuConta(ContaUsuario conta){
        try{

        int opcao = 0;
        while(opcao != 5){
            System.out.println("Conta: " + conta.getNomeUsuario());
            System.out.println("1. Ver Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Sair da conta");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Saldo: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor a depositar: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    System.out.println("Deposito realizado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o valor a sacar: ");
                    double saque = scanner.nextDouble();
                    if(conta.sacar(saque)){
                        System.out.println("Saque realizado com sucesso!");
                    } else{
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome de usuário da conta que deseja transferir:");
                    String nomeDestinatario = scanner.nextLine();

                    if(!contas.containsKey(nomeDestinatario)){
                        System.out.println("Conta não encontrada.");
                        break;
                    }

                    System.out.println("Digite o valor para transferencia: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    ContaUsuario destinatario = contas.get(nomeDestinatario);
                    conta.transferir(destinatario, valorTransferencia);
                    break;

                case 5:
                    System.out.println("Saindo da conta...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }catch (Exception e){
            System.out.println("Erro ao executar menu: " + e.getMessage());
            throw new RuntimeException(e);
        }
}}
