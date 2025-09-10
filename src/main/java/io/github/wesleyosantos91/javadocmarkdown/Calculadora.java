package io.github.wesleyosantos91.javadocmarkdown;

/// # Calculadora
/// Uma classe **didática** para mostrar _Javadoc em Markdown_ no **Java 23**.
///
/// - Comentários começam com `///` (uma por linha)
/// - Você pode usar **negrito**, _itálico_, listas, links e `código`
/// - Também dá para usar tags do Javadoc como `@param` e `@return`
///
/// Exemplo de link para a API: [List]  // se houver import java.util.List
public class Calculadora {

    /// ## Soma dois inteiros
    ///
    /// Use quando precisar de uma soma rápida:
    ///
    /// ```java
    /// var calc = new Calculadora();
    /// int r = calc.soma(2, 3); // 5
    /// ```
    ///
    /// @param a primeiro termo
    /// @param b segundo termo
    /// @return a soma de `a` e `b`
    public int soma(int a, int b) {
        return a + b;
    }

    /// ## Média aritmética simples
    ///
    /// Recebe uma lista de inteiros e devolve a média.
    ///
    /// Observações:
    /// - Retorna `0.0` se a lista estiver vazia
    /// - Exemplo:
    ///   ```java
    ///   double m = calc.media(List.of(10, 20, 30)); // 20.0
    ///   ```
    ///
    /// @param valores lista de valores (pode estar vazia)
    /// @return a média dos valores, ou `0.0` se vazia
    public double media(java.util.List<Integer> valores) {
        if (valores == null || valores.isEmpty()) return 0.0;
        long soma = 0;
        for (int v : valores) soma += v;
        return (double) soma / valores.size();
    }
}
