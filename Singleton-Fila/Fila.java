public class Fila {
    private static Fila instancia;
    private String[] documentos;
    private int tamanho;
    private int capacidade;

    private Fila(int capacidade) {
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.documentos = new String[capacidade];
    }

    public static Fila getInstance() {
        if (instancia == null) {
            instancia = new Fila(100); // Defina a capacidade desejada
        }
        return instancia;
    }

    public void imprimirDocumento() {
        if (tamanho > 0) {
            String documento = documentos[0];
            System.out.println("Imprimindo documento: " + documento);
            // Remova o documento da fila (shift à esquerda)
            for (int i = 0; i < tamanho - 1; i++) {
                documentos[i] = documentos[i + 1];
            }
            tamanho--;
        } else {
            System.out.println("A fila de impressão está vazia.");
        }
    }

    public void removerDocumento() {
        if (tamanho > 0) {
            // Remova o documento mais antigo da fila (shift à esquerda)
            for (int i = 0; i < tamanho - 1; i++) {
                documentos[i] = documentos[i + 1];
            }
            tamanho--;
        } else {
            System.out.println("A fila de impressão está vazia, nenhum documento para remover.");
        }
    }

    public void removerTodosDocumentos() {
        tamanho = 0;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade > 0) {
            this.capacidade = capacidade;
            if (tamanho > capacidade) {
                tamanho = capacidade;
            }
        } else {
            System.out.println("A capacidade deve ser um valor positivo.");
        }
    }
}