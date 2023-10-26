public class SenhaDecoder {
    public String decodificarSenha(String senha) {

        return new StringBuilder(senha).reverse().toString();
    }
}