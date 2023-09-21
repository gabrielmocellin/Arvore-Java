public class No {
    private int informacao;
    private No pai, esquerda, direita;

    public No(int informacao, No pai){
        this.informacao = informacao;
        this.pai = pai;
        this.esquerda= null;
        this.direita = null;
    }

    public void adicionarNumero(int numero) {
    /* ALGORITMO
       1- Verifica se o número que deseja-se inserir é maior ou igual a informação do nó atual
       2- Caso positivo iremos inserir o número no filho a direita do nó atual
            2.1- Verifica se o filho a direita do nó atual é nulo
            2.2- Caso positivo é instanciando no filho a direita do nó atual um novo nó com o número desejado
            2.3- Caso negativo a função é chamada recursivamente no filho a direita do nó atual
       3- Caso negativo iremos inserir o número no filho a esquerda do nó atual com a mesma lógica descrita nos passos
          2.1 , 2.2 e 2.3
    */
        if(numero >= this.informacao){
            if (this.direita == null)
                this.direita = new No(numero, this);
            else
                this.direita.adicionarNumero(numero);
        } else {
            if (this.esquerda == null)
                this.esquerda = new No(numero, this);
            else
                esquerda.adicionarNumero(numero);
        }
    }

    public boolean buscarNumero(int numero) {
    /* ALGORITMO
       1- Verifica se a informação do nó atual bate com o número que está sendo buscado (caso positivo retorna true)
       2- Caso negativo verifica se o número que está sendo buscado é menor que o nó atual
       3- Caso seja menor, é verificado se o filho a esquerda do nó atual é nulo
       4- Caso seja nulo retornamos false (pois chegamos ao nó folha e o número buscado não está presente na árvore)
       5- Caso não seja nulo a função é chamada recursivamente no filho a esquerda do nó atual
    */
        if (numero == this.informacao) {
            return true;
        } else if (numero < this.informacao) {
            if (this.esquerda == null)
                return false;
            else
                return this.esquerda.buscarNumero(numero);
        } else {
            if (this.direita == null)
                return false;
            else
                return this.esquerda.buscarNumero(numero);
        }
    }

    public void excluirNo(int numero){
    /*ALGORITMO
       CMT 1 - Verificando primeiro o filho da esquerda do nó atual se é maior que a informação do pai, afim de saber se deve ir para a direita
       CMT 2 - Verificando se informação atual está na direita do pai
    */
        if (numero == this.informacao) {
            if (this.isNoFolha()) { // VERIFICAÇÃO PARA REMOÇÃO DE NÓ FOLHA
                excluir_No_Folha();
            } else { // CASO NÃO SEJA FOLHA
                if (this.esquerda == null) { // SE O FILHO DA ESQUERDA FOR NULL, E SE O NO ATUAL FOR FILHO DA DIREITA DO PAI
                    excluir_No_Com_Um_Filho_Null(this.direita);
                } else if (this.direita == null) {
                    excluir_No_Com_Um_Filho_Null(this.esquerda);
                } else { // CASO NENHUM DOS DOIS SEJAM NULOS
                    this.excluir_No_Com_Dois_Filhos();
                }
            }
        } else {
            if (numero >= this.informacao) {
                this.direita.excluirNo(numero);
            } else {
                this.esquerda.excluirNo(numero);
            }
        }
    }

    public boolean isNoFolha(){
        if(this.direita == null && this.esquerda == null)
            return true;
        return false;
    }

    public void excluir_No_Com_Dois_Filhos(){

        /*
            Se um nó com dois filhos será excluido, primeiramente deve ser verificado se o nó da direita é folha:
            1 Caso o nó da direita não seja folha, é verificado se o nó da esquerda é folha.
                1.1 Caso o nó da esquerda seja folha, então o nó removido é substituído pelo nó da esquerda.
                1.2 Caso o nó da esquerda não seja folha, então é iniciado uma recursividade até encontrar um nó na esquerda que seja folha.
            2 Caso o nó da direita seja folha, o nó removido é substituido pelo nó da direita.
        */
        if (this.pai == null) {
            if(this.direita.esquerda == null) {
                this.direita.esquerda = this.esquerda;
                this.direita.pai = null;
            } else {
                No folha = procurar_No_Folha(this.direita.esquerda);
                folha.pai = null;
                folha.direita = this.direita;
                folha.esquerda = this.esquerda;
                this.direita.pai = folha;
                this.esquerda.pai = folha;
            }
        } else {
            if(this.direita.isNoFolha()) {
                No folha = this.direita;
                if (this.pai.direita == this) {
                    this.pai.direita = folha;
                } else {
                    this.pai.esquerda = folha;
                }
                folha.pai = this.pai;
                folha.esquerda = this.esquerda;

                this.esquerda.pai = folha;
            } else {
                if(this.direita.esquerda != null) {
                    No folha = procurar_No_Folha(this.direita.esquerda);
                    if (this.pai.esquerda == this) {
                        this.pai.esquerda = folha;
                        if (folha.pai.esquerda == folha) {
                            folha.pai.esquerda = folha.direita;
                        } else {
                            folha.pai.direita = folha.direita;
                        }
                    } else {
                        this.pai.direita = folha;
                        if (folha.pai.esquerda == folha) {
                            folha.pai.esquerda = folha.direita;
                        } else {
                            folha.pai.direita = folha.direita;
                        }
                    }
                    folha.pai = this.pai;
                    folha.esquerda = this.esquerda;
                    folha.direita = this.direita;
                } else {
                    if (this.pai.direita == this) {
                        this.pai.direita = this.direita;
                    } else {
                        this.pai.esquerda = this.direita;
                    }
                    this.direita.pai = this.pai;
                    this.direita.esquerda = this.esquerda;
                }
            }
        }
    }

    public void excluir_No_Com_Um_Filho_Null(No no_param){
        if (this.pai.direita == this) {
            this.pai.direita = no_param;
            no_param.pai = this.pai;
        } else {
            this.pai.esquerda = no_param;
            no_param.pai = this.pai;
        }
    }

    public No procurar_No_Folha(No noPartida) {
        No noFolha;
        while(true){
            if (noPartida.esquerda == null){
                noFolha = noPartida;
                break;
            } else {
                noPartida = noPartida.esquerda;
            }
        }
        return noFolha;
    }

    public void excluir_No_Folha() {
        if (this.pai.esquerda == this) {
            this.pai.esquerda = null;
        } else {
            this.pai.direita = null;
        }
    }





    public int getInformacao() {
        return informacao;
    }
    public No getesquerda() {
        return esquerda;
    }
    public No getdireita() {
        return direita;
    }
}