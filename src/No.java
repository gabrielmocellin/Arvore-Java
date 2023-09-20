public class No {
    private int informacao;
    private No noPai, filhoEsquerda, filhoDireita;

    public No(int informacao, No noPai){
        this.informacao = informacao;
        this.noPai = noPai;
        this.filhoEsquerda= null;
        this.filhoDireita = null;
    }

    public void setProximoEsquerda(No noParam) {
        this.filhoEsquerda = noParam;
    }
    public void setProximoDireita(No noParam) {
        this.filhoDireita = noParam;
    }

    /* Ao adicionar um nó na árvore, deve ser verificado se este nó possui informacao maior ou menor que o nó raiz
    Após isso deve ser verificado com os nós posteriores */
    public void adicionarNo(int numero) {

        // IDEIA: e se a gente só passasse as informações do nó para ele ser criado apenas ao chegar no nó correto

        if(numero >= this.informacao){
            if (this.filhoDireita == null) {
                this.filhoDireita = new No(numero, this);
            } else {
                this.filhoDireita.adicionarNo(numero);
            }
        } else{
            if (this.filhoEsquerda == null) {
                this.filhoEsquerda = new No(numero, this);
            } else{
                this.filhoEsquerda.adicionarNo(numero);
            }
        }
    }

    public void buscarValor(int numero) {

    }

    public No excluirNo(){
        if (this.filhoEsquerda == null) {
            return this.filhoDireita ;
        } else if (this.filhoDireita == null) {
            return this.filhoEsquerda;
        } else {
            return this.filhoEsquerda.excluirNo();
        }
    }

}
