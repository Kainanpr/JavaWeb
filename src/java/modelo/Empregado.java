
package modelo;

public class Empregado {
    
    private int id;
    private String nome;
    private String setor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Empregado{" + "id=" + id + ", nome=" + nome + ", setor=" + setor + '}';
    }
    
    
     
}
