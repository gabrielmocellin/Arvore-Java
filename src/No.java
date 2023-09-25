public class No {
    private final int chave;
    private No pai, esquerda, direita;

    public No(int chave, No pai){
        this.chave = chave;
        this.pai = pai;
        this.esquerda= null;
        this.direita = null;
    }

    /* ALGORITMO
       1- Verifica se o número que deseja-se inserir é maior ou igual à chave do nó atual
       2- Caso positivo iremos inserir o número no filho à direita do nó atual
            2.1- Verifica se o filho à direita do nó atual é nulo
            2.2- Caso positivo é instanciando no filho à direita do nó atual um novo nó com o número desejado
            2.3- Caso negativo a função é chamada recursivamente no filho à direita do nó atual
       3- Caso negativo iremos inserir o número no filho à esquerda do nó atual com a mesma lógica descrita nos passos
          2.1, 2.2 e 2.3
    */
    public void adicionarNumero(int numero) {
        if(numero >= this.chave){
            if (this.direita == null) {
                this.direita = new No(numero, this);
            }
            else {
                this.direita.adicionarNumero(numero);
            }
        }
        else {
            if (this.esquerda == null) {
                this.esquerda = new No(numero, this);
            }
            else {
                esquerda.adicionarNumero(numero);
            }
        }
    }

    /* ALGORITMO
       1- Verifica se a chave do nó atual bate com o número que está sendo buscado (caso positivo retorna true)
       2- Caso negativo verifica se o número que está sendo buscado é menor que o nó atual
       3- Caso seja menor, é verificado se o filho à esquerda do nó atual é nulo
       4- Caso seja nulo retornamos false (pois chegamos ao nó folha e o número buscado não está presente na árvore)
       5- Caso não seja nulo a função é chamada recursivamente no filho à esquerda do nó atual
    */
    public boolean buscarNumero(int numero) {
        if (numero == this.chave) {
            return true;
        }
        else if (numero < this.chave) {
            if (this.esquerda == null) {
                return false;
            } else {
                return this.esquerda.buscarNumero(numero);
            }
        }
        else {
            if (this.direita == null) {
                return false;
            } else {
                return this.direita.buscarNumero(numero);
            }
        }
    }

    public No excluirNo(int numero, No raiz){
        if (numero == this.chave) {
            if (isFolha()) {
                raiz = excluir_No_Folha(raiz);
            }
            else if (filho_Esquerdo_Eh_Null()) {
                raiz = excluir_No_Com_Um_Filho_Null(this.direita, raiz);
            }
            else if (filho_Direito_Eh_Null()) {
                raiz = excluir_No_Com_Um_Filho_Null(this.esquerda, raiz);
            }
            else {
                raiz = excluir_No_Com_Dois_Filhos(raiz);
            }
            return raiz;
        }
        else {
            if (numero < this.chave) {
                return this.esquerda.excluirNo(numero, raiz);
            }
            else {
                return this.direita.excluirNo(numero, raiz);
            }
        }
    }

    public No excluir_No_Folha(No raiz) {
        if (isRaiz()) {
            raiz = null;
        }
        else if (this.pai.esquerda == this) {
            this.pai.esquerda = null;
        }
        else {
            this.pai.direita = null;
        }
        return raiz;
    }

    public No excluir_No_Com_Um_Filho_Null(No sucessor, No raiz){ // ************* COMO TROCAR O ATRIBUTO RAIZ DA ÁRVORE DAQUI? *****************
        if (isRaiz()) {
            raiz = sucessor;
        }
        else {
            if (this.pai.direita == this) { // Verificar se o nó atual que será excluído está na direita (é maior) que o pai
                this.pai.direita = sucessor; // A referência do pai para o filho é retirada
            } else {
                this.pai.esquerda = sucessor;
            }
        }
        sucessor.pai = this.pai; // Pode ser nó qualquer ou null
        return raiz;
    }

    /*
    Se um nó com dois filhos será excluido, primeiramente procuramos o seu sucessor
    Utilizamos a regra de "maior valor mais próximo"
    Exemplo: excluindo o número 30, procuramos o valor mais próximo de 31
    */
    public No excluir_No_Com_Dois_Filhos(No raiz){
        No sucessor = procurar_Sucessor(this.direita);
        if(isRaiz()){
            sucessor.pai = null;
            if(raiz.direita != sucessor) {
                sucessor.direita = raiz.direita;
            }
            sucessor.esquerda = raiz.esquerda;
            return sucessor;
        } else{
            // Colocamos o sucessor na posição do NÓ que queremos remover
            sucessor.pai = this.pai;
            sucessor.esquerda = this.esquerda;
            if(this.pai.esquerda == this) {
                this.pai.esquerda = sucessor;
            }
            else {
                this.pai.direita = sucessor;
            }
            this.esquerda.pai = sucessor;

            // Por fim precisamos arrumar o filho direito do sucessor
            if(this.direita != null) {
                // Este if verifica se tem algo à direita do NÓ que removemos da árvore, caso tenha, precisamos colocar
                // à direita do sucessor
                if(sucessor.direita == null) {
                    this.direita.pai = sucessor;
                    sucessor.direita = this.direita;
                }
                else {
                    // Caso o sucessor já tenha filhos a sua direita, precisamos dar prioridade a eles
                    No ultimoFilho_Sucessor = procurar_Ultimo_Filho_Direito_Do_Sucessor(sucessor);
                    ultimoFilho_Sucessor.direita = this.direita;
                    this.direita.pai = ultimoFilho_Sucessor;
                }
            }
        }
        return raiz;
    }

    public No procurar_Sucessor(No noPartida) {
        No sucessor;
        while(true) {
            if(noPartida.esquerda == null){
                sucessor = noPartida;
                break;
            } else {
                noPartida = noPartida.esquerda;
            }
        }

        // Antes de retornar o sucessor cortamos a relação de parentesco dele (já que vamos subi-lo na árvore)
        if(sucessor.pai.esquerda == sucessor) {
            sucessor.pai.esquerda = null;
        }
        else {
            sucessor.pai.direita = null;
        }
        return sucessor;
    }

    public No procurar_Ultimo_Filho_Direito_Do_Sucessor(No noPartida) {
        if(noPartida.direita == null) {
            return noPartida;
        }
        return procurar_Ultimo_Filho_Direito_Do_Sucessor(noPartida.direita);
    }

    public boolean isFolha() {return direita == null && esquerda == null;}
    public boolean filho_Esquerdo_Eh_Null() {return esquerda == null;}
    public boolean filho_Direito_Eh_Null() {return direita == null;}
    public boolean isRaiz() {return pai == null;}
    public int getChave() {return chave;}
    public No getesquerda() {return esquerda;}
    public No getdireita() {return direita;}
}
