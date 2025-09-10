# ☕ PoC - Explorando o Java 25 (e versões anteriores)

Este repositório contém exemplos práticos explorando **novidades do Java 18 até o Java 25**.  
A ideia é revisar recursos que surgiram nas versões recentes e experimentar, na prática, como utilizá-los em projetos do dia a dia.

---

## 🚀 Estrutura do Projeto

- `jwebserver/` → Exemplo do servidor HTTP embutido no JDK 18+.
- `virtualthread/` → **Virtual Threads** (Java 21+) - Threads leves para alta concorrência.
- `sequencedcollections/` → **Sequenced Collections** (Java 21+) - Coleções com ordem garantida.
- (em breve) `records/` → Exemplos com **Records**.
- (em breve) `pattern-matching/` → Exemplos de **Pattern Matching**.
- (em breve) `string-templates/` → Templates de String (Preview).
- (em breve) `scoped-values/` → Scoped Values (substituindo ThreadLocal).

Cada diretório terá exemplos isolados e um README explicando o recurso.

---

## 📦 Pré-requisitos

- **Java 25+** (recomendado instalar o JDK 25 LTS ou superior).
- Maven ou Gradle (dependendo do exemplo).
- Git para clonar o repositório.

---

## 🖥️ Rodando o `jwebserver`

Entre no diretório `jwebserver` e rode:

```bash
# Inicia um servidor HTTP na porta 8000
jwebserver --port 8000
```

Após iniciar o servidor, acesse [http://localhost:8000](http://localhost:8000) no seu navegador. 
O arquivo `index.html` na raiz do projeto será renderizado, exibindo uma página de boas-vindas estilizada que demonstra o funcionamento do servidor web embutido do JDK 18+.

---

## 🧵 Executando Virtual Threads

Entre no diretório do projeto e execute:

```bash
# Executa o exemplo principal de Virtual Threads
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.virtualthread.Main"

# Ou execute a comparação de performance entre Virtual e Platform Threads
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.virtualthread.PerformanceComparison"
```

Os exemplos demonstram como as **Virtual Threads** (Java 21+) revolucionam a programação concorrente, permitindo criar milhões de threads leves com overhead mínimo de memória. O código executa 10.000 tarefas simultaneamente, mostrando medições de performance, análise de memória e comparações com threads tradicionais. Virtual Threads são ideais para aplicações I/O intensivas como APIs REST, microserviços e operações de banco de dados.

---

## 📋 Executando Sequenced Collections

Entre no diretório do projeto e execute:

```bash
# Executa a demonstração de Sequenced Collections
mvn exec:java -Dexec.mainClass="io.github.wesleyosantos91.sequencedcollections.Main"
```

O exemplo demonstra as **Sequenced Collections** (Java 21+), que introduzem uma API consistente para coleções que mantêm ordem de inserção. O código mostra as novas interfaces `SequencedCollection`, `SequencedSet` e `SequencedMap` com métodos como `addFirst()`, `addLast()`, `getFirst()`, `getLast()` e `reversed()`. Essa funcionalidade simplifica o trabalho com `ArrayList`, `LinkedList`, `TreeSet`, `LinkedHashMap` e outras coleções ordenadas, oferecendo uma interface uniforme sem necessidade de casting.
