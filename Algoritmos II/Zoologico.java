import java.util.ArrayList;
import java.util.List;

class Animal {
    String nome, especie;
    int idade;
    String habitat;

    public Animal(String nome, String especie, int idade, String habitat) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public String info() {
        return nome + " - " + especie + " - " + idade + " anos - Habitat: " + habitat;
    }
}

class Zoologico {
    List<Animal> animais = new ArrayList<>();

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void listarAnimaisPorHabitat(String tipoHabitat) {
        System.out.println("Animais no habitat " + tipoHabitat + ":");
        for (Animal animal : animais) {
            if (animal.getHabitat().equals(tipoHabitat)) {
                System.out.println("- " + animal.info());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();

        zoologico.cadastrarAnimal(new Animal("Leo", "Leão", 5, "Terrestre"));
        zoologico.cadastrarAnimal(new Animal("Nemo", "Peixe Palhaço", 2, "Aquático"));
        zoologico.cadastrarAnimal(new Animal("Tweety", "Canário", 3, "Aéreo"));

        zoologico.listarAnimaisPorHabitat("Terrestre");
        zoologico.listarAnimaisPorHabitat("Aquático");
        zoologico.listarAnimaisPorHabitat("Aéreo");
    }
}
