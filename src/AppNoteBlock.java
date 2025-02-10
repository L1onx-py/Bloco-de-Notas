import java.util.Scanner;


public class AppNoteBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlocoDeNota blocoDeNotas = new BlocoDeNota();

        while (true) {
            System.out.println("\n===== Bloco de Notas =====");
            System.out.println("1. Adicionar Anotação");
            System.out.println("2. Editar Anotação");
            System.out.println("3. Remover Anotação");
            System.out.println("4. Buscar Anotações");
            System.out.println("5. Listar Todas as Anotações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a anotação: ");
                    String texto = sc.nextLine();
                    blocoDeNotas.adicionarAnotacao(texto);
                    break;
                case 2:
                    System.out.print("Digite o ID da anotação a ser editada: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o novo texto: ");
                    String novoTexto = sc.nextLine();
                    blocoDeNotas.editAnotacao(idEditar, novoTexto);
                    break;
                case 3:
                    System.out.print("Digite o ID da anotação a ser removida: ");
                    int idRemover = sc.nextInt();
                    blocoDeNotas.removerAnotacao(idRemover);
                    break;
                case 4:
                    System.out.print("Digite o termo de busca: ");
                    String termoBusca = sc.nextLine();
                    blocoDeNotas.buscarAnotacoes(termoBusca);
                    break;
                case 5:
                    blocoDeNotas.listarAnotacoes();
                    break;
                case 6:
                    System.out.println("Saindo do Bloco de Notas...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
