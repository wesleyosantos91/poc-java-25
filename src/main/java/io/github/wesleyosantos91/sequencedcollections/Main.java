package io.github.wesleyosantos91.sequencedcollections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    static void main() {

        System.out.println("📋 Demonstração de Sequenced Collections no Java 21+");
        System.out.println("═".repeat(60));
        System.out.println();

        // Demonstra SequencedCollection (ArrayList)
        demonstrateSequencedCollection();

        // Demonstra SequencedSet (LinkedHashSet)
        demonstrateSequencedSet();

        // Demonstra SequencedMap (LinkedHashMap)
        demonstrateSequencedMap();

        // Demonstra compatibilidade com outras implementações
        demonstrateOtherImplementations();

        System.out.println("\n🌟 Sequenced Collections oferecem:");
        System.out.println("   • API consistente para coleções ordenadas");
        System.out.println("   • Métodos first/last uniformes");
        System.out.println("   • Visualização reversa sem cópia");
        System.out.println("   • Compatibilidade com implementações existentes");
    }

    private static void demonstrateSequencedCollection() {
        System.out.println("🔄 SequencedCollection com ArrayList:");
        System.out.println("─".repeat(40));

        // ArrayList agora implementa SequencedCollection
        SequencedCollection<String> lista = new ArrayList<>();

        // Métodos addFirst() e addLast()
        lista.addFirst("Primeiro");
        lista.addLast("Segundo");
        lista.addLast("Terceiro");
        lista.addFirst("Novo Primeiro");

        System.out.println("Lista após inserções: " + lista);

        // Métodos getFirst() e getLast()
        System.out.println("Primeiro elemento: " + lista.getFirst());
        System.out.println("Último elemento: " + lista.getLast());

        // Método reversed() - retorna uma view reversa
        SequencedCollection<String> reversa = lista.reversed();
        System.out.println("Visualização reversa: " + reversa);

        // Removendo primeiro e último
        System.out.println("Removido primeiro: " + lista.removeFirst());
        System.out.println("Removido último: " + lista.removeLast());
        System.out.println("Lista final: " + lista);

        System.out.println();
    }

    private static void demonstrateSequencedSet() {
        System.out.println("📋 SequencedSet com LinkedHashSet:");
        System.out.println("─".repeat(40));

        // LinkedHashSet agora implementa SequencedSet
        SequencedSet<Integer> conjunto = new LinkedHashSet<>();

        // Adicionando elementos
        conjunto.addFirst(10);
        conjunto.addLast(20);
        conjunto.addLast(30);
        conjunto.addFirst(5);

        // Sets não permitem duplicatas
        conjunto.addLast(20); // Não será adicionado

        System.out.println("Conjunto após inserções: " + conjunto);
        System.out.println("Tamanho: " + conjunto.size());

        // Acessando extremos
        System.out.println("Primeiro: " + conjunto.getFirst());
        System.out.println("Último: " + conjunto.getLast());

        // Visualização reversa
        SequencedSet<Integer> conjuntoReverso = conjunto.reversed();
        System.out.println("Ordem reversa: " + conjuntoReverso);

        // Removendo elementos
        System.out.println("Removido primeiro: " + conjunto.removeFirst());
        System.out.println("Conjunto após remoção: " + conjunto);

        System.out.println();
    }

    private static void demonstrateSequencedMap() {
        System.out.println("🗂️ SequencedMap com LinkedHashMap:");
        System.out.println("─".repeat(40));

        // LinkedHashMap agora implementa SequencedMap
        SequencedMap<String, String> mapa = new LinkedHashMap<>();

        // Métodos put tradicionais
        mapa.put("segunda", "Trabalho");
        mapa.put("sexta", "TGIF");

        // Novos métodos putFirst() e putLast()
        mapa.putFirst("domingo", "Descanso");
        mapa.putLast("sábado", "Diversão");

        System.out.println("Mapa após inserções: " + mapa);

        // Acessando primeiro e último entry
        Map.Entry<String, String> primeiro = mapa.firstEntry();
        Map.Entry<String, String> ultimo = mapa.lastEntry();

        System.out.println("Primeira entrada: " + primeiro.getKey() + " -> " + primeiro.getValue());
        System.out.println("Última entrada: " + ultimo.getKey() + " -> " + ultimo.getValue());

        // Visualização reversa do mapa
        SequencedMap<String, String> mapaReverso = mapa.reversed();
        System.out.println("Mapa em ordem reversa: " + mapaReverso);

        // Removendo entradas pelos extremos
        Map.Entry<String, String> removidoPrimeiro = mapa.pollFirstEntry();
        Map.Entry<String, String> removidoUltimo = mapa.pollLastEntry();

        System.out.println("Removido primeiro: " + removidoPrimeiro);
        System.out.println("Removido último: " + removidoUltimo);
        System.out.println("Mapa final: " + mapa);

        System.out.println();
    }

    private static void demonstrateOtherImplementations() {
        System.out.println("🔧 Compatibilidade com outras implementações:");
        System.out.println("─".repeat(50));

        // LinkedList sempre foi sequencial
        SequencedCollection<String> linkedList = new LinkedList<>();
        linkedList.addFirst("A");
        linkedList.addLast("C");
        linkedList.addFirst("B");
        System.out.println("LinkedList: " + linkedList);

        // TreeSet (SortedSet) agora também é SequencedSet
        SequencedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(2);
        System.out.println("TreeSet (ordenado): " + treeSet);
        System.out.println("TreeSet reverso: " + treeSet.reversed());

        // TreeMap (SortedMap) agora também é SequencedMap
        SequencedMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("charlie", 3);
        treeMap.put("alice", 1);
        treeMap.put("bob", 2);
        System.out.println("TreeMap (ordenado): " + treeMap);

        // Demonstrando que a API é consistente
        System.out.println("\n✅ API Consistente:");
        System.out.println("   • Primeiro do TreeSet: " + treeSet.getFirst());
        System.out.println("   • Último do TreeSet: " + treeSet.getLast());
        System.out.println("   • Primeira chave do TreeMap: " + treeMap.firstEntry().getKey());
        System.out.println("   • Última chave do TreeMap: " + treeMap.lastEntry().getKey());

        System.out.println();
    }
}
