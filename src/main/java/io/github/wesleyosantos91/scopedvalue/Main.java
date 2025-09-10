package io.github.wesleyosantos91.scopedvalue;

public class Main {

    // 1) Crie a "chave" do contexto (imutável)
    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    static void main() {

        // 2) Vincule o valor ao escopo e execute seu código
        ScopedValue.where(USER, "Wesley").run(Main::controller);

        // Fora do escopo, não há valor ligado
        IO.println("Fora do escopo -> ligado? " + USER.isBound()); // false

        // dentro do escopo, há valor ligado
        ScopedValue.where(USER, "teste").run(() -> IO.println("Dentro do escopo -> ligado? " + USER.isBound()));
    }

    static void controller() {
        service();
    }

    static void service() {
        // 3) Leia o valor em qualquer ponto do call stack dentro do escopo
        log("Olá, " + USER.get() + "!"); // sem passar parâmetro
    }

    static void log(String msg) {
        // Se não houver binding, use um fallback legível
        IO.println("[user=" + USER.orElse("desconhecido") + "] " + msg);
    }
}
