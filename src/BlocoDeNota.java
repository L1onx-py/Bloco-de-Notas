import java.util.ArrayList;
import java.util.List;

public class BlocoDeNota {
    private List<Anotacao> anotacoes;

    public BlocoDeNota() {
        this.anotacoes = new ArrayList<>();
    }

    public void adicionarAnotacao(String texto) {
        Anotacao novaAnotacao = new Anotacao(texto);
        anotacoes.add(novaAnotacao);
        System.out.println("Anotação adicionada com sucesso! ID: " + novaAnotacao.getID());

    }

    public void editAnotacao(int ID, String novoTexto) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getID() == ID && !anotacao.isDeletado()) {
                anotacao.setTexto(novoTexto);
                System.out.println("A anotação " + ID + " foi editada com êxito!!!");
                return;
            }
        }
        System.out.println("Nenhuma anotação registrada!! Tente novamente!");
    }

    public void removerAnotacao(int id) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getID() == id && !anotacao.isDeletado()) {
                anotacao.deletar();
                System.out.println("Anotação " + id + " Foi removida com êxito!!!.");
                return;
            }
        }
        System.out.println("Nenhuma anotação registrada!! Tente novamente!");
    }

    public void buscarAnotacoes(String termo) {
        boolean encontrou = false;
        for (Anotacao anotacao : anotacoes) {
            if (!anotacao.isDeletado() && anotacao.getTexto().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(anotacao);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma anotação encontrada com o termo: " + termo);
        }
    }
    public void listarAnotacoes() {
        boolean encontrou = false;
        for (Anotacao anotacao : anotacoes) {
            if (!anotacao.isDeletado()) {
                System.out.println(anotacao);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma anotação disponível.");
        }
    }

}
