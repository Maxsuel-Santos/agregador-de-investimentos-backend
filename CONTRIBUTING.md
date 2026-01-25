# Guia de Contribuição e Desenvolvimento

Este documento estabelece o fluxo de trabalho (workflow) e os padrões de desenvolvimento para o projeto **Finncker desktop**. O objetivo é garantir a integridade do código na branch principal e facilitar a colaboração entre a equipe.

---

## 1. Fluxo de Trabalho (Git Flow)

Nosso fluxo baseia-se no conceito de **Feature Branching**.

* **`main`**: Contém a versão estável e funcional do software. **É proibido realizar commits diretamente nesta branch.**
* **Branches de trabalho**: Para cada nova tarefa, cria-se uma ramificação isolada.

**Estrutura Visual:**
```text
main      ---------------------------------> (Versão Estável)
             \                         /
feat/example  \--[commit]--[commit]---/  (Pull Request)
````

### Passo a Passo do Desenvolvimento

Siga este ciclo para começar a trabalhar no projeto:

#### Passo 0: Configuração Inicial (Clonar)

Se você nunca baixou o projeto, execute este comando no seu terminal para criar a cópia local.
*Isso é feito apenas uma vez.*

```bash
git clone https://github.com/Finncker/desktop.git
```

-----

#### Passo 1: Sincronização

Antes de iniciar uma nova tarefa, garanta que seu ambiente local esteja atualizado com a versão mais recente do servidor.

```bash
git checkout main
git pull origin main
```

#### Passo 2: Criação da Branch

Crie uma branch específica para a tarefa.
> É recomendado atribuir nomes descritivos e em inglês para novas branches.

**Padrão:** `type/task-name`

**Prefixos aceitos:**

  * `feat/`: Novas funcionalidades (ex: `feat/login-screen`)
  * `fix/`: Correção de bugs (ex: `fix/tax-calculation`)
  * `docs/`: Alterações em documentação (ex: `docs/readme`)

<!-- end list -->

```bash
# Cria a branch e altera o contexto para ela
git checkout -b feat/login-screen
```

#### Passo 3: Desenvolvimento e Versionamento

Ao finalizar uma etapa lógica do trabalho, realize o commit.

**A. Adicionar arquivos à Staging Area:**
Prepara os arquivos modificados para serem versionados.

```bash
git add .
```

**B. Realizar o Commit:**
Grava as alterações no histórico local.
> Assim como para as branches, é recomendo escrever a mensagem do commit em ingês e no imperativo.

```bash
git commit -m "feat: implement initial login controller structure"
```

> **Nota:** Mantenha commits pequenos e atômicos. Evite commitar arquivos de configuração da IDE ou binários compilados.

#### Passo 4: Envio para o Repositório Remoto

Envie sua branch para o repositório remoto no GitHub.

```bash
git push origin feat/login-screen
```

#### Passo 5: Code Review (Pull Request)

1.  Acesse o repositório remoto.
2.  Abra um **Pull Request (PR)** da sua branch para a `main`.
3.  Descreva brevemente as alterações e solicite revisão de um colega.
4.  Após a aprovação, o código será integrado (Merged).

-----

## 2\. Padrões de Projeto (Java Springboot)

> É recomendado que todo o código (nomes de arquivos, classes, variáveis e comentários javadoc) seja escrito em inglês.

### A. Nomenclatura de Arquivos e Classes

Utilizamos **PascalCase** (Inicia com maiúscula).

| Tipo | Padrão | Exemplo Correto ✅ |
| :--- | :--- | :--- |
| **Entities (FXML)** | `[Name]User.java` | `User.fxml` |
| **Controllers** | `[Name]Controller.java` | `UserController.java` |
| **Classes de Modelo** | Substantivo Singular | `Customer.java`, `Product.java` |

### B. Variáveis e Atributos

Utilizamos **camelCase** (Inicia com minúscula). Os nomes devem ser descritivos e em inglês.

| Tipo | Regra | Exemplo Correto ✅ | Exemplo Errado ❌ |
| :--- | :--- | :--- | :--- |
| **Variáveis Locais** | camelCase | `totalSales`, `customerList` | `totalVendas`, `list` |
| **Constantes** | UPPER\_SNAKE\_CASE | `MAX_WIDTH`, `DEFAULT_TAX` | `maxWidth`, `Padrao` |
| **Booleanos** | Prefixos is/has/can | `isActive`, `hasPermission`, `canEdit` | `ativo`, `status` |

### C. Métodos

Utilizamos **camelCase**. Métodos representam ações, portanto devem sempre começar com um **Verbo em Inglês**.

  * ✅ **Correto:** `calculateTotal()`, `getCustomerById()`, `saveData()`
  * ❌ **Incorreto:** `calcular()`, `getUser()`, `Process()`

**Eventos do JavaFX:**
Para métodos que respondem a cliques ou ações da interface, recomenda-se o prefixo `handle` ou `on`.

  * Ex: `handleSaveButtonAction()`, `onMouseEntered()`

-----

## 3\. Guia de Solução de Problemas (Troubleshooting)

Comandos úteis para situações comuns durante o desenvolvimento:

| Situação | Comando / Ação |
| :--- | :--- |
| **Verificar arquivos alterados** | `git status` (Use frequentemente) |
| **Descartar alterações locais** | `git checkout .` (Cuidado: apaga alterações não salvas) |
| **Errou a mensagem do commit?** | `git commit --amend -m "New correct message"` |
| **Estou na branch errada** | 1. `git stash` (Guarda mudanças)<br>2. `git checkout correct-branch`<br>3. `git stash pop` (Recupera mudanças) |

### Conflitos de Merge

Caso ocorra um conflito (duas pessoas editaram a mesma linha), o Git impedirá o merge automático.

1.  O Git marcará o arquivo conflitante com `<<<<<<< HEAD`.
2.  Edite o arquivo manualmente escolhendo a versão correta (apagando os marcadores do Git).
3.  Realize um novo `git add` e `git commit` para resolver.

-----

> **Dúvidas?** Consulte a equipe antes de executar comandos que alterem o histórico (como `reset` ou `rebase`).
