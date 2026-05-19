# Trabalho: Árvore Binária

**Aluno:** Pedro Henrique Miquelin - 251072001  
**Disciplina:** AED: Árvores  

---

## Descrição do Projeto
Este repositório contém a implementação da operação de **remoção de nós** em uma Árvore Binária de Busca (BST) desenvolvida em Java. O algoritmo complementa o código-base fornecido, que já possuía os métodos de inserção e caminhamentos (Pré-Ordem, Em-Ordem e Pós-Ordem).

A funcionalidade desenvolvida trata com precisão os três cenários de exclusão:
1. **Nó Folha (Sem filhos):** Removido diretamente, fazendo o ponteiro do pai apontar para `null`.
2. **Nó com 1 Filho:** O filho assume a posição do pai que foi removido.
3. **Nó com 2 Filhos:** Aplicação estrita da metodologia do **Sucessor (Menor dos maiores)**. O algoritmo localiza o menor elemento da subárvore direita, copia seu valor para o nó alvo e, recursivamente, elimina o sucessor de sua posição original.

---

## Relatório Técnico: Justificativa da Abordagem Recursiva

A escolha pelo modelo **recursivo** para a árvore binária foi fundamentada nos seguintes critérios técnicos e estruturais:

### 1. Gerenciamento Automatizado de Ponteiros
Como a estrutura do nó fornecida não possui uma referência para o "nó pai", uma implementação iterativa (com laços `while`) exigiria criar e controlar variáveis auxiliares manualmente para rastrear o pai de cada nó durante a busca. Na abordagem recursiva, a própria **Pilha de Execução (Call Stack)** do sistema operacional armazena esse rastro. Ao retornar a referência do nó modificado (`return atual;`), o pai atualiza seu ponteiro automaticamente, mitigando erros de ponteiros órfãos ou *NullPointerException*.

### 2. Reutilização Lógica no Caso de Dois Filhos
O cenário mais complexo da remoção ocorre quando o nó possui dois filhos. Após encontrar o sucessor e copiar seu valor, o sucessor original precisa ser deletado. Como o menor nó dos maiores tem, no máximo, um filho à direita, a recursão permite simplesmente reatar o método principal de forma direta:

<pre><code>atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));</code></pre>

### 3. Coesão e Consistência Arquitetural
As operações pré-existentes no projeto (`inserirRecursivo` e os métodos de exibição `preOrdem`, `emOrdem`, `posOrdem`) foram todas construídas sob o paradigma recursivo. Adotar a recursão também na remoção mantém o padrão de design, a consistência e a identidade do código-base, facilitando a legibilidade e a manutenção.

### 4. Análise de Complexidade Assintótica
* **Complexidade Temporal (Tempo):** Ambas as abordagens (iterativa e recursiva) são equivalentes. Em uma árvore balanceada, a complexidade é de O(log n), e no pior caso (árvore perfeitamente degenerada em formato de lista), é de O(n), onde n é o número de nós.
* **Complexidade Espacial (Memória):** A recursão consome O(h) de memória na pilha do sistema (onde h é a altura da árvore). Este consumo é considerado desprezível diante do ganho em segurança e robustez do código.

---

## Como Executar e Testar o Projeto

1. Certifique-se de ter o Java JDK instalado na sua máquina (versão 11 ou superior).
2. Abra o projeto na sua IDE de preferência (como o IntelliJ IDEA ou Eclipse).
3. Execute a classe `Main.java`.

### Saída Esperada no Console:
Ao rodar o arquivo `Main.java`, o console demonstrará com sucesso as mensagens de inserção, a exibição da árvore perfeitamente ordenada (pelo percurso Em-Ordem), a aplicação dos 3 tipos de remoção e o resultado final reorganizado.
