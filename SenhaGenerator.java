import java.util.Random;

public class SenhaGenerator {
    public String gerarSenhaAutomatica(int comprimento, boolean usarLetrasMaiusculas, boolean usarLetrasMinusculas,
                                       boolean usarNumeros, boolean usarCaracteresEspeciais) {
        StringBuilder caracteresPermitidos = new StringBuilder();
        if (usarLetrasMaiusculas) caracteresPermitidos.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (usarLetrasMinusculas) caracteresPermitidos.append("abcdefghijklmnopqrstuvwxyz");
        if (usarNumeros) caracteresPermitidos.append("0123456789");
        if (usarCaracteresEspeciais) caracteresPermitidos.append("!@#$%^&*()-_=+[{]};:'\",<.>/?");

        Random random = new Random();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            senha.append(caracteresPermitidos.charAt(index));
        }

        return senha.toString();
    }
}
