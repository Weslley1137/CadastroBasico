package Scanner;

import Conta.ContaUsuario;

import java.util.HashMap;
import java.util.Scanner;

public class InputScanner {
    public static final Scanner scanner = new Scanner(System.in);
    public static HashMap<String, ContaUsuario> contas = new HashMap<>();

    public static Scanner getScanner() {
        return scanner;
    }
    private InputScanner() {
    }

    public static HashMap<String, ContaUsuario> getContas() {
        return contas;
    }

}

