# ☕ PoC - Explorando o Java 25 (e versões anteriores)

Este repositório contém exemplos práticos explorando **novidades do Java 18 até o Java 25**.  
A ideia é revisar recursos que surgiram nas versões recentes e experimentar, na prática, como utilizá-los em projetos do dia a dia.

---

## 🚀 Estrutura do Projeto

- `jwebserver/` → Exemplo do servidor HTTP embutido no JDK 18+.
- (em breve) `records/` → Exemplos com **Records**.
- (em breve) `pattern-matching/` → Exemplos de **Pattern Matching**.
- (em breve) `sequenced-collections/` → Novidades em coleções ordenadas.
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
