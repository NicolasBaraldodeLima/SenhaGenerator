import java.util.Scanner;

public class SenhaInserter {
    public String inserirSenha() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua senha: ");
        return scanner.nextLine();
    }
}