package io.github.wesleyosantos91.unnamedvariablepatterns;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    static void main() {
        System.out.println("🎯 Demonstração de Unnamed Variables & Patterns no Java 22+");
        System.out.println("═".repeat(65));
        System.out.println();

        // Demonstra Unnamed Variables em Lambdas
        demonstrateUnnamedVariablesInLambdas();

        // Demonstra Unnamed Variables em Exception Handling
        demonstrateUnnamedVariablesInExceptions();

        // Demonstra Unnamed Patterns com Records
        demonstrateUnnamedPatternsWithRecords();

        // Demonstra Unnamed Patterns em Switch Expressions
        demonstrateUnnamedPatternsInSwitch();

        // Demonstra casos práticos avançados
        demonstrateAdvancedUseCases();

        System.out.println("\n🌟 Unnamed Variables & Patterns oferecem:");
        System.out.println("   • Código mais limpo ao ignorar valores não utilizados");
        System.out.println("   • Melhor legibilidade em pattern matching");
        System.out.println("   • Redução de warnings do compilador");
        System.out.println("   • Expressão clara da intenção do código");
    }

    private static void demonstrateUnnamedVariablesInLambdas() {
        System.out.println("🔄 Unnamed Variables em Lambdas:");
        System.out.println("─".repeat(35));

        var nomes = List.of("Ana", "Bruno", "Carla", "Daniel");

        System.out.println("Lista original: " + nomes);

        // Em vez de usar um parâmetro nomeado que não usamos
        System.out.print("Processando cada item: ");
        nomes.forEach(_ -> System.out.print("✓ "));
        System.out.println();

        // Útil quando só precisamos da posição/índice, não do valor
        System.out.println("Contando elementos:");
        int count = nomes.stream()
             .map(_ -> 1)  // Transforma cada elemento em 1
             .reduce(0, Integer::sum);  // reduce com valor inicial retorna Integer diretamente
        System.out.println("Total de elementos: " + count);

        // Em Map operations onde só importa a transformação
        var tamanhos = nomes.stream()
                           .map(_ -> "***")  // Substitui todos por asteriscos
                           .toList();
        System.out.println("Substituição por asteriscos: " + tamanhos);

        System.out.println();
    }

    private static void demonstrateUnnamedVariablesInExceptions() {
        System.out.println("🚨 Unnamed Variables em Exception Handling:");
        System.out.println("─".repeat(45));

        // Exemplo 1: IOException que não precisa ser inspecionada
        try {
            // Simulando operação que pode falhar
            if (Math.random() > 0.5) {
                throw new IOException("Simulação de falha I/O");
            }
            System.out.println("✅ Operação I/O bem-sucedida");
        } catch (IOException _) {
            // Não precisamos dos detalhes da exceção, só tratar genericamente
            System.out.println("❌ Falha de I/O detectada, continuando execução...");
        }

        // Exemplo 2: Múltiplas exceções tratadas da mesma forma
        try {
            processData();
        } catch (IllegalArgumentException _) {
            System.out.println("⚠️ Argumento inválido - usando valor padrão");
        } catch (UnsupportedOperationException _) {
            System.out.println("⚠️ Operação não suportada - usando alternativa");
        }

        // Exemplo 3: Try-with-resources onde não usamos o recurso diretamente
        try (var _ = new AutoCloseableResource()) {
            System.out.println("🔒 Recurso será fechado automaticamente");
        } catch (Exception _) {
            System.out.println("🚫 Erro ao gerenciar recurso");
        }

        System.out.println();
    }

    private static void demonstrateUnnamedPatternsWithRecords() {
        System.out.println("📋 Unnamed Patterns com Records:");
        System.out.println("─".repeat(35));

        // Definindo records para demonstração
        record Point(int x, int y) {}
        record Person(String name, int age, String email) {}
        record Rectangle(Point topLeft, Point bottomRight, String color) {}

        // Exemplo 1: Só nos importamos com a coordenada X
        Object obj1 = new Point(15, 25);
        if (obj1 instanceof Point(int x, _)) {
            System.out.println("Coordenada X: " + x + " (Y ignorado)");
        }

        // Exemplo 2: Só nos importamos com o nome da pessoa
        Object obj2 = new Person("Alice", 30, "alice@email.com");
        if (obj2 instanceof Person(String nome, _, _)) {
            System.out.println("Nome da pessoa: " + nome + " (idade e email ignorados)");
        }

        // Exemplo 3: Pattern matching aninhado com unnamed
        Object obj3 = new Rectangle(new Point(0, 0), new Point(10, 10), "azul");
        if (obj3 instanceof Rectangle(Point(int x1, _), Point(int x2, _), _)) {
            int largura = x2 - x1;
            System.out.println("Largura do retângulo: " + largura + " (Y e cor ignorados)");
        }

        // Exemplo 4: Array patterns com unnamed
        var pontos = new Point[]{new Point(1, 2), new Point(3, 4), new Point(5, 6)};
        if (pontos instanceof Point[] arr && arr.length >= 2) {
            if (arr[0] instanceof Point(int firstX, _) &&
                arr[1] instanceof Point(int secondX, _)) {
                System.out.println("Primeiras coordenadas X: " + firstX + ", " + secondX);
            }
        }

        System.out.println();
    }

    private static void demonstrateUnnamedPatternsInSwitch() {
        System.out.println("🔀 Unnamed Patterns em Switch Expressions:");
        System.out.println("─".repeat(45));

        record Circle(double radius) {}
        record Rectangle(double width, double height) {}
        record Triangle(double base, double height, double angle) {}

        var shapes = List.of(
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 45.0)
        );

        for (Object shape : shapes) {
            String description = switch (shape) {
                case Circle(double r) -> "Círculo com raio " + r;
                case Rectangle(double w, double h) -> "Retângulo " + w + "x" + h;
                case Triangle(double base, double height, _) ->
                    "Triângulo base=" + base + " altura=" + height + " (ângulo ignorado)";
                default -> "Forma desconhecida";
            };
            System.out.println("📐 " + description);
        }

        // Switch com múltiplos unnamed patterns
        for (Object shape : shapes) {
            double area = switch (shape) {
                case Circle(double r) -> Math.PI * r * r;
                case Rectangle(double w, double h) -> w * h;
                case Triangle(double base, double height, _) -> (base * height) / 2;
                default -> 0.0;
            };
            System.out.printf("📏 Área: %.2f%n", area);
        }

        System.out.println();
    }

    private static void demonstrateAdvancedUseCases() {
        System.out.println("🚀 Casos Avançados de Uso:");
        System.out.println("─".repeat(30));

        // Unnamed em enhanced for loops (conceitual)
        var dados = Map.of("a", 1, "b", 2, "c", 3);

        System.out.println("Contando entradas do mapa:");
        int count = 0;
        for (var _ : dados.entrySet()) {
            count++;  // Só contamos, não usamos o entry
        }
        System.out.println("Total de entradas: " + count);

        // Unnamed em destructuring assignments (conceitual)
        record Coordinates(double lat, double lng, double elevation) {}
        var location = new Coordinates(-23.5505, -46.6333, 760.0);

        if (location instanceof Coordinates(double lat, double lng, _)) {
            System.out.printf("Localização: %.4f, %.4f (elevação ignorada)%n", lat, lng);
        }

        // Unnamed em stream operations
        System.out.println("Stream operations com unnamed:");
        List.of("arquivo1.txt", "arquivo2.txt", "arquivo3.txt")
            .stream()
            .filter(_ -> true)  // Aceita todos (filtro dummy)
            .map(_ -> "📄")     // Transforma todos em ícone
            .forEach(System.out::print);
        System.out.println(" (arquivos processados)");

        System.out.println();
    }

    private static void processData() throws IllegalArgumentException, UnsupportedOperationException {
        double random = Math.random();
        if (random < 0.33) {
            throw new IllegalArgumentException("Dados inválidos");
        } else if (random < 0.66) {
            throw new UnsupportedOperationException("Operação não implementada");
        }
        System.out.println("✅ Dados processados com sucesso");
    }

    // Classe auxiliar para try-with-resources
    private static class AutoCloseableResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("🔒 Recurso fechado automaticamente");
        }
    }
}
