import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlocoDeNota {
    private List<Anotacao> anotacoes;

    public BlocoDeNota() {
        this.anotacoes = new ArrayList<>();
    }

    public void adicionarAnotacao(String texto) {
        try {
            Anotacao novaAnotacao = new Anotacao(texto);
            anotacoes.add(novaAnotacao);
            System.out.println("Anotação adicionada com êxito!!! ID: " + novaAnotacao.getID());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Não foi possível adicionar a anotação " + e.getMessage());
        }
    }

    public void editAnotacao(int id, String novoTexto) {
        Optional<Anotacao> anotacaoOpt = buscarAnotacoes(id);
        if (anotacaoOpt.isPresent()) {
            try {
                anotacaoOpt.get().setTexto(novoTexto);
                System.out.println("Anotação ID " + id + " editada com Êxito!!!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao editar anotação: " + e.getMessage());
            }
        } else {
            System.out.println("Erro: Anotação com o ID " + id + " não foi encontrada!!!.");
        }
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
