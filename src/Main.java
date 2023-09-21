
public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(50);
        arvore.inserir(20);
        System.out.println(arvore.buscar(50));
        System.out.println(arvore.buscar(20));
        System.out.println(arvore.buscar(10));
    }
}