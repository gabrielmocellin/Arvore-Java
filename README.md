# Árvore Binária
Projeto desenvolvido durante o 4º Período do curso de Engenharia de Software na PUCPR na matéria Resolução de Problemas Estruturados em Computação lecionada pela professora [Marina de Lara](https://github.com/akitodr) .

## Autores

- [@diogobonet](https://github.com/diogobonet)
- [@FelipeRed](https://github.com/FelipeRed)
- [@gabrielmocellin](https://github.com/gabrielmocellin)


## O que é Árvore Binária de Busca?
É uma estrutura de dados de uma lista não-linear, a árvore binária de busca é uma árvore binária que segue uma regra especial para organizar seus elementos.

![301e011b6cbfd51d9f76160cc8013892f0417681](https://github.com/gabrielmocellin/Arvore-Java/assets/96633512/ac7d92a1-4b46-4d3b-a916-b5be7e999e5b)


1. Se ainda não há nó raiz, então o novo elemento será o próprio nó raiz

2. Se há nó raiz, então deve comparar o novo elemento com o nó raiz. 

3. Caso o novo elemento seja menor que o elemento do nó raiz, então o novo elemento é inserido na sub árvore da direita

#### A árvore binária de busca possui:
- Inserção
- Busca
- Remoção

## Implementação da Árvore Binária de Busca
> A implementação foi realizada na linguagem *Java*.

### Atributos do nó
`private int informacao;  private No pai, esquerda, direita;`

Foi definido na própria classe `nó`, dentro do construtor que um nó pode ser pai, e recebe os atributos de esquerda e direita, para nó código fazer as verificações que serão importantes para os métodos de *inserção, remoção de nós e busca*. E também possui o atributo informação que é representado por um valor **inteiro** e também será responsável para realizar as verificações do algoritmo.

### Inserção do nó
`public void adicionarNumero(int numero)`

Esse método é responsável pelo seguinte algoritmo:

1. Verifica se o número que deseja-se inserir é maior ou igual a informação do nó atual
       
2. Caso positivo iremos inserir o número no filho a direita do nó atual<br>
        2.1- Verifica se o filho a direita do nó atual é nulo <br>
            2.2- Caso positivo é instanciando no filho a direita do nó atual um novo nó com o número desejado<br>
            2.3- Caso negativo a função é chamada recursivamente no filho a direita do nó atual<br>
       3- Caso negativo iremos inserir o número no filho a esquerda do nó atual com a mesma lógica descrita nos passos 2.1 , 2.2 e 2.3

### Busca do nó
`public boolean buscarNumero(int numero)`

Esse método é responsável pelo seguinte algoritmo:
1. Verifica se a informação do nó atual bate com o número que está sendo buscado (caso positivo retorna true)  
2. Caso negativo verifica se o número que está sendo buscado é menor que o nó atual
3. Caso seja menor, é verificado se o filho a esquerda do nó atual é nulo
4. Caso seja nulo retornamos false (pois chegamos ao nó folha e o número buscado não está presente na árvore)
5. Caso não seja nulo a função é chamada recursivamente no filho a esquerda do nó atual

### Excluir o nó
`public No excluirNo(int numero, No raiz)`

1. Verifica se o valor passado como `numero` é igual `chave`<br>
1.1 - Verifica se o nó é folha, caso seja atualiza o valor da `raiz` <br>
2. Caso não seja, verifica se o `numero` passado com parametro é menor que a `chave` retornando o método `this.esquerda.excluirNo(numero, raiz);`.
Caso ele seja maior ele retorna o método `this.direita.excluirNo(numero, raiz);`.


### Verificação se o nó é folha
`public boolean isNoFolha()`

Esse método retorna um valor booleano, verificando se o nó é um nó folha, essa verificação ocorre verificando se o nó da direita e esquerda são nulos. Se forem ele retorna o valor `true`, caso não seja retorna o valor `false`.

### Excluir nó com dois filhos
`public void excluir_No_Com_Dois_Filhos`

Esse método é responsável pelo seguinte algoritmo: <br>

Se um nó com dois filhos será excluido, primeiramente deve ser verificado se o nó da direita é folha:

1. Caso o nó da direita não seja folha, é verificado se o nó da esquerda é folha. <br>
    1.1 Caso o nó da esquerda seja folha, então o nó removido é substituído pelo nó da esquerda.<br>
    1.2 Caso o nó da esquerda não seja folha, então é iniciado uma recursividade até encontrar um nó na esquerda que seja folha.<br>
2. Caso o nó da direita seja folha, o nó removido é substituido pelo nó da direita.

### Excluir nó com um filho nulo
` public No excluir_No_Com_Um_Filho_Null(No sucessor, No raiz)`

Esse método é responsável pelo seguinte algoritmo: <br>

1. Verifica se o nó é raiz<br>
    1.1 - Se o nó atual for raiz, ele se torna o seu sucessor. <br>
2. Caso não seja verifica se o nó atual (que será excluido) que está do lado direito é maior que o pai.
3. A referência do pai para o filho direito é atualizada para apontar para o nó `sucessor`
4. Caso não seja, a referência do pai para o filho esquerdo é atualizada para apontar para o nó sucessor, efetivamente removendo a ligação entre o pai e o nó atual. Atualizar as referências do pai para o filho. Retornando a raiz logo em seguida.

### Procurar o nó folha
`public No procurar_No_Folha(No noPartida)`

1. Dentro desse método possui um laço de repetição while true, que percorre a árvore para encontrar o nó folha
2. Ao encontrar o nó folha (para fazer a identificação os filhos serão nulos) atribuindo as variáveis de `noPartida` no `nóFolha`. 
3. Caso o lado esquerdo não seja nulo, atribuimos o no lado esquerdo para apontar o filho esquerdo do `noPartida`.

### Excluir nó folha
`public void excluir_No_Folha()`

1. Verifica se o nó atual é o filho esquerdo do seu pai. <br>
1.1 - Caso o nó atual seja o filho esquerdo do pai, definimos ele como nulo, removendo a ligação com o pai e acaba excluindo do nó atual (nó filho).
2. Caso o nó atual seja o filho direito, ele faz a mesma coisa, define o nó atual como valor `null`.


### Procurar sucessor
`public No procurar_Sucessor(No noPartida)`
 1. Ele inicia a busca descendo pela árvore à esquerda até encontrar o nó mais à esquerda, que é o nó sucessor <br>
 2. Corta a relação de parentesco do sucessor com seu pai, para que possa ser removido ou movido posteriormente, se necessário <br>
 3. Retorna o nó sucessor

## Screenshots do Prompt
