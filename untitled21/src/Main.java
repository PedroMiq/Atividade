public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(0);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(-5);
        arvoreBinaria.inserir(-4);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(9);

        System.out.println("\n--- Árvore Original (Em-Ordem) ---");
        arvoreBinaria.exibir("Em");

        System.out.println("\n--- Teste 1: Removendo nó folha (-4) ---");
        arvoreBinaria.remover(-4);

        System.out.println("\n--- Teste 2: Removendo nó com 1 filho (7) ---");
        arvoreBinaria.remover(7);

        System.out.println("\n--- Teste 3: Removendo nó com 2 filhos (5) ---");
        arvoreBinaria.remover(5);

        System.out.println("\n--- Árvore Final Após as Remoções (Em-Ordem) ---");
        arvoreBinaria.exibir("Em");
    }
}