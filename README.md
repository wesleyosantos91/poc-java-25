# ☕ PoC - Explorando o Java 25 (e versões anteriores)

Este repositório contém exemplos práticos explorando **novidades do Java 18 até o Java 25**.  
A ideia é revisar recursos que surgiram nas versões recentes e experimentar, na prática, como utilizá-los em projetos do dia a dia.

---

## 🚀 Estrutura do Projeto

- `jwebserver/` → **JWebServer** (Java 18+) - Servidor HTTP embutido no JDK.
- `virtualthread/` → **Virtual Threads** (Java 21+) - Threads leves para alta concorrência.
- `sequencedcollections/` → **Sequenced Collections** (Java 21+) - Coleções com ordem garantida.
- `unnamedvariablepatterns/` → **Unnamed Variables & Patterns** (Java 22+) - Variáveis não nomeadas.
- `javadocmarkdown/` → **Markdown Documentation Comments** (Java 23+) - Javadoc com sintaxe Markdown.
- `scopedvalue/` → **Scoped Values** (Java 25+) - Passagem implícita de contexto.

Cada diretório contém exemplos isolados e um README explicando o recurso.

---

## 📦 Pré-requisitos

- **Java 25+** (recomendado instalar o JDK 25 LTS ou superior).
- Maven ou Gradle (dependendo do exemplo).
- Git para clonar o repositório.

---

## 🖥️ Executando JWebServer

Entre no diretório do projeto e execute:

```bash
# Inicia um servidor HTTP na porta 8000
jwebserver --port 8000
```

O **JWebServer** (Java 18+) é um servidor HTTP simples embutido no JDK que elimina a necessidade de servidores externos durante desenvolvimento. Após iniciar o servidor, acesse [http://localhost:8000](http://localhost:8000) no seu navegador. O arquivo `index.html` na raiz do projeto será renderizado, exibindo uma página de boas-vindas estilizada que demonstra o funcionamento do servidor web embutido.

---

## 🧵 Executando Virtual Threads

Entre no diretório do projeto e execute:

```bash
# Executa o exemplo principal de Virtual Threads
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.virtualthread.Main"
```

**Virtual Threads** (Java 21+) revolucionam a programação concorrente, permitindo criar milhões de threads leves com overhead mínimo de memória. O código executa 10.000 tarefas simultaneamente, mostrando medições de performance, análise de memória e comparações com threads tradicionais. Virtual Threads são ideais para aplicações I/O intensivas como APIs REST, microserviços e operações de banco de dados.

---

## 📋 Executando Sequenced Collections

Entre no diretório do projeto e execute:

```bash
# Executa a demonstração de Sequenced Collections
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.sequencedcollections.Main"
```

**Sequenced Collections** (Java 21+) introduzem uma API consistente para coleções que mantêm ordem de inserção. O código mostra as novas interfaces `SequencedCollection`, `SequencedSet` e `SequencedMap` com métodos como `addFirst()`, `addLast()`, `getFirst()`, `getLast()` e `reversed()`. Essa funcionalidade simplifica o trabalho com `ArrayList`, `LinkedList`, `TreeSet`, `LinkedHashMap` e outras coleções ordenadas, oferecendo uma interface uniforme sem necessidade de casting.

---

## 🎯 Executando Unnamed Variables & Patterns

Entre no diretório do projeto e execute:

```bash
# Executa a demonstração de Unnamed Variables & Patterns
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.unnamedvariablepatterns.Main"
```

**Unnamed Variables & Patterns** (Java 22+) introduzem o uso do underscore `_` para representar variáveis que não serão utilizadas, tornando o código mais limpo e expressivo. O código demonstra uso em lambdas (`nomes.forEach(_ -> ...)`), exception handling (`catch (IOException _)`), pattern matching (`if (obj instanceof Point(int x, _))`) e switch expressions (`case Triangle(_, _, angle)`). Esta funcionalidade elimina warnings do compilador sobre variáveis não utilizadas e comunica claramente a intenção do desenvolvedor.

---

## 📚 Markdown Documentation Comments

Navegue até o pacote `javadocmarkdown` para ver a classe `Calculadora`:

```bash
# Para gerar documentação Javadoc com Markdown (Java 23+)
javadoc -d docs src/main/java/io/github/wesleyosantos91/javadocmarkdown/*.java
```

**Markdown Documentation Comments** (Java 23+) introduzem sintaxe Markdown nativa em comentários Javadoc através do JEP 467. A classe `Calculadora` demonstra a nova sintaxe `///` com cabeçalhos, formatação, listas, blocos de código e integração com tags tradicionais do Javadoc. Esta funcionalidade torna a documentação mais legível no código-fonte e mais rica visualmente quando gerada.

---

## 🔐 Executando Scoped Values

Entre no diretório do projeto e execute:

```bash
# Executa a demonstração de Scoped Values
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.scopedvalue.Main"
```

**Scoped Values** (Java 20+) oferecem uma alternativa moderna e eficiente ao ThreadLocal para passagem implícita de contexto através do call stack. O código demonstra como criar uma chave de contexto (`USER`), vincular valores ao escopo usando `ScopedValue.where(USER, "Wesley").run()`, e acessar esses valores em qualquer ponto do call stack com `USER.get()`. A implementação mostra verificação de binding com `isBound()` e uso de fallback com `orElse()`.