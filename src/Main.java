import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = Arvore.criarArvore_Base();

        boolean desligar = false;
        while (!desligar) {
            int acao = printMenu(arvore);
            switch (acao) {
                case 1:
                    inserirNumero(arvore);
                    break;
                case 2:
                    buscarNumero(arvore);
                    break;
                case 3:
                    removerNumero(arvore);
                    break;
                case 4:
                    desligar = true;
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }
    }
     public static int printMenu(Arvore arvore) {
        limparTela();
        Printer.imprimirArvore(arvore);
        return input("""
                Ações:
                1- Inserir número.
                2- Buscar número.
                3- Excluir número.
                4- Encerrar programa.
                Digite o número da ação que deseja efetuar:\s""");
     }

     public static void inserirNumero(Arvore arvore){
         limparTela();
         Printer.imprimirArvore(arvore);

         while(true) {
             System.out.println("Insira 0 (zero) para voltar ao menu principal.");
             int numero = input("Digite o número que será adicionado: ");
             if(numero == 0) {
                 break;
             }
             arvore.inserir(numero);
             Printer.imprimirArvore(arvore);
         }
     }

     public static void buscarNumero(Arvore arvore) {
         limparTela();
         Printer.imprimirArvore(arvore);
         int numero = input("Insira o número que deseja buscar: ");
         System.out.println();

         if (arvore.buscar(numero)) {
             System.out.println("O número " + numero + " ESTÁ presente na árvore.");
         }
         else {
             System.out.println("O número " + numero + " NÃO ESTÁ presente na árvore.");
         }

         numero = input("1- Sim\n2- Não\nDeseja buscar outro número: ");
         if (numero == 1) {
             buscarNumero(arvore);
         }
     }

    public static void removerNumero(Arvore arvore) {
        limparTela();
        Printer.imprimirArvore(arvore);
        int numero = input("Insira o número que deseja remover da árvore: ");
        limparTela();

        if (arvore.buscar(numero)) {
            arvore.remover(numero);
            System.out.println("O número " + numero + " foi removido e a árvore ficou assim:");
            Printer.imprimirArvore(arvore);
        }
        else {
            System.out.println("O número " + numero + " NÃO ESTÁ presente na árvore.");
        }

        numero = input("1- Sim\n2- Não\nDeseja remover outro número: ");
        if (numero == 1) {
            removerNumero(arvore);
        }
    }

    public static int input(String msg) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        return teclado.nextInt();
    }
    public static void limparTela() {
        for (int i=0; i<50; i++) {
            System.out.println();
        }
    }
}