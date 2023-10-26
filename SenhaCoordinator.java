import java.util.List;
import java.util.Scanner;

public class SenhaCoordinator {
    private Usuario usuario;
    private SenhaInserter senhaInserter;
    private SenhaGenerator senhaGenerator;
    private SenhaDecoder senhaDecoder;
    private AutomacaoSenha automacaoSenha;

    public SenhaCoordinator() {
        this.usuario = new Usuario();
        this.senhaInserter = new SenhaInserter();
        this.senhaGenerator = new SenhaGenerator();
        this.senhaDecoder = new SenhaDecoder();
        this.automacaoSenha = new AutomacaoSenha();
    }

    public void executarPrograma() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Senhas!");

        // Login do usuário (pode ser estendido para um sistema de autenticação mais seguro)
        System.out.print("Digite seu nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        usuario.setNome(nomeUsuario);

        System.out.print("Digite sua senha: ");
        String senhaUsuario = scanner.nextLine();
        usuario.setSenha(senhaUsuario);

        System.out.println("Login bem-sucedido!");

        // Opções do menu
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir Senha");
            System.out.println("2. Gerar Senha Automática");
            System.out.println("3. Decodificar Senha");
            System.out.println("4. Histórico de Senhas");
            System.out.println("5. Executar Automação de Senhas");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    // Inserir senha
                    String novaSenha = senhaInserter.inserirSenha();
                    usuario.adicionarSenha(novaSenha);
                    System.out.println("Senha inserida com sucesso!");
                    break;
                case 2:
                    // Gerar senha automática
                    System.out.println("Configuração da Senha Automática:");
                    System.out.print("Comprimento da Senha: ");
                    int comprimentoSenha = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.print("Usar letras maiúsculas? (S/N): ");
                    boolean usarLetrasMaiusculas = scanner.nextLine().equalsIgnoreCase("S");

                    System.out.print("Usar letras minúsculas? (S/N): ");
                    boolean usarLetrasMinusculas = scanner.nextLine().equalsIgnoreCase("S");

                    System.out.print("Usar números? (S/N): ");
                    boolean usarNumeros = scanner.nextLine().equalsIgnoreCase("S");

                    System.out.print("Usar caracteres especiais? (S/N): ");
                    boolean usarCaracteresEspeciais = scanner.nextLine().equalsIgnoreCase("S");

                    String senhaAutomatica = senhaGenerator.gerarSenhaAutomatica(
                            comprimentoSenha, usarLetrasMaiusculas, usarLetrasMinusculas, usarNumeros, usarCaracteresEspeciais
                    );
                    usuario.adicionarSenha(senhaAutomatica);
                    System.out.println("Senha automática gerada: " + senhaAutomatica);
                    break;
                case 3:
                    // Decodificar senha
                    System.out.print("Digite a senha que deseja decodificar: ");
                    String senhaParaDecodificar = scanner.nextLine();
                    String senhaDecodificada = senhaDecoder.decodificarSenha(senhaParaDecodificar);
                    System.out.println("Senha decodificada: " + senhaDecodificada);
                    break;
                case 4:
                    // Histórico de senhas
                    List<String> historico = usuario.getHistoricoSenhas();
                    System.out.println("Histórico de Senhas:");
                    for (String senha : historico) {
                        System.out.println(senha);
                    }
                    break;
                case 5:
                    // Executar automação de senhas
                    automacaoSenha.executarAutomacao();
                    break;
                case 6:
                    // Sair do programa
                    System.out.println("Obrigado por usar o Sistema de Senhas. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
