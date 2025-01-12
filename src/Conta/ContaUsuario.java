package Conta;

public class ContaUsuario{
    private String nomeUsuario;
    private String senhaUsuario;
    private double saldo;

    public ContaUsuario(String name, String senha) {
        this.nomeUsuario = name;
        this.senhaUsuario = senha;
        this.saldo = 0;
    }

    public boolean autenticar(String senha) {
        return this.senhaUsuario.equals(senha);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setName(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senhaUsuario;
    }

    public void setSenha(String senha) {
        this.senhaUsuario = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        try{
        if(valor > 0){
            this.saldo += valor;

        }
        else{
            System.out.println("Valor inválido!");
        }}catch(Exception e){
            System.out.println("Valor inválido!");
            throw e;
        }
    }
    public boolean sacar(double valor){
        try{

        if(valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }else{
        System.out.println("Saldo insuficiente ou valor invalido");
        return false;

    }}catch(Exception e){
        System.out.println("Valor inválido!");
            throw e;
         }
    }

    public boolean transferir(ContaUsuario destinatario, double valor){
        try {
            if(valor < 0){
        System.out.println("O valor de transferência deve ser maior que zero.");
    return false;
    }
        if(sacar(valor)){
        System.out.println("Saldo após saque: " + this.getSaldo());
        destinatario.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para " + destinatario.getNomeUsuario() + " realizada com sucesso!");
            System.out.println("Saldo do destinatário após transferência: " + destinatario.getSaldo());
     System.out.println("Transferencia realizada com sucesso!");
     return true;
        } else{
        System.out.println("Falha na transferencia!");
        return false;
 }
    }catch(Exception e){
        System.out.println("Valor inválido!");
            throw e;
     }
    }
}


