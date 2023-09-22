
public class Main {
    public static int height(No raiz) {
        if (raiz == null)
            return 0;
        return Math.max(height(raiz.getesquerda()), height(raiz.getdireita())) + 1;
    }

    public static int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static void printTree(int[][] M, No root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.getChave();
        printTree(M, root.getesquerda(), col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getdireita(), col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }

    public static void TreePrinter(Arvore tree) {
        if(tree.isVazia()) {
            System.out.println("Árvore vazia.");
        }
        else {
            int h = height(tree.getRaiz());
            int col = getcol(h);
            int[][] M = new int[h][col];
            printTree(M, tree.getRaiz(), col / 2, 0, h);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < col; j++) {
                    if (M[i][j] == 0)
                        System.out.print("  ");
                    else
                        System.out.print(M[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore(50);
        arvore.inserir(55);
        arvore.inserir(60);
        arvore.inserir(61);
        arvore.inserir(59);

        TreePrinter(arvore);System.out.println("\n");
        arvore.remover(50);
        TreePrinter(arvore);System.out.println("\n");
        arvore.remover(55);
        TreePrinter(arvore);System.out.println("\n");
        arvore.remover(59);
        TreePrinter(arvore);System.out.println("\n");
        arvore.remover(60);
        TreePrinter(arvore);System.out.println("\n");
        arvore.remover(61);
        TreePrinter(arvore);System.out.println("\n");
    }
}