import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Anotacao {

    //ATRIBUTOS: (Lembre-se sempre de sempre se perguntar: O que este objeto TEM?)
    private String texto;
    private static int geradorID = 1;
    private int ID;
    private LocalDate dataDeCriacao;
    private Boolean deletado;

    //CONSTRUTOR:
    public Anotacao(String texto, int ID, LocalDate dataDeCriacao, Boolean deletado) {
        this.texto = texto;
        this.ID = geradorID++; // Dessa forma o será gerado ID automaticamente
        this.dataDeCriacao = dataDeCriacao;
        this.deletado = false;
    }

    //GETTERS E SETTERS:
    public String getTexto() {
        return texto;
    }

    public void setTexto(String novoTexto) {
        this.texto = novoTexto;
    }

    public int getID() {
        return ID;
    }

    public String  getDataDeCriacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Formatar a saída do LocalDate sem ser a forma do Java)
        return dataDeCriacao.format(formatter);
    }

    public Boolean getDeletado() {
        return deletado;
    }

    //MÉTODOS: (Lembre-se sempre de sempre se perguntar: O que este objeto FAZ?)
    public boolean isDeletado() {
        return deletado;
    }

    public void deletar() {
        this.deletado = true;
    }

    @Override
    public String toString() {
    return "[ID: " + ID + "] " + texto + " (Hora da criação: " + getDataDeCriacao() + ")";
    }

}
