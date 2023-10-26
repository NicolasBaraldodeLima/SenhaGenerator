import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String senha;
    private List<String> historicoSenhas;

    public Usuario() {
        this.historicoSenhas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionarSenha(String senha) {
        this.historicoSenhas.add(senha);
    }

    public List<String> getHistoricoSenhas() {
        return historicoSenhas;
    }
}