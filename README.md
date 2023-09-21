# Árvore Binária
Projeto desenvolvido durante o 4º Período do curso de Engenharia de Software na PUCPR na matéria Resolução de Problemas Estruturados em Computação lecionada pela professora [Marina de Lara](https://github.com/akitodr) .

## Autores

- [@diogobonet](https://github.com/diogobonet)
- [@FelipeRed](https://github.com/FelipeRed)
- [@gabrielmocellin](https://github.com/gabrielmocellin)


## O que é Árvore Binária de Busca?
É uma estrutura de dados de uma lista não-linear, a árvore binária de busca é uma árvore binária que segue uma regra especial para organizar seus elementos.

1. Se ainda não há nó raiz, então o novo elemento será o próprio nó raiz

2. Se há nó raiz, então deve comparar o novo elemento com o nó raiz. 

3. Caso o novo elemento seja menor que o elemento do nó raiz, então o novo elemento é inserido na sub árvore da direita

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
`public void excluirNo(int numero)`

1. CMT 1 - Verificando primeiro o filho da esquerda do nó atual se é maior que a informação do pai, afim de saber se deve ir para a direita
2. CMT 2 - Verificando se informação atual está na direita do pai


### Verificação se o nó é folha
`public boolean isNoFolha()`

Esse método retorna um valor booleano, verificando se o nó é um nó folha, essa verificação ocorre verificando se o nó da direita e esquerda são nulos. Se forem ele retorna o valor `true`, caso não seja retorna o valor `false`.
