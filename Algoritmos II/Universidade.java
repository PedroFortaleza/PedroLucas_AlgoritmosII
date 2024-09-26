import java.util.ArrayList;
import java.util.List;

class Professor {
    String nome;
    public Professor(String nome) {
        this.nome = nome;
    }
}

class Disciplina {
    String nome;
    int cargaHoraria;
    Professor professor;
    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }
}

class Aluno {
    String nome;
    List<Disciplina> disciplinasMatriculadas = new ArrayList<>();
    public Aluno(String nome) {
        this.nome = nome;
    }
    public void matricular(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
    }
    public int getHorasCursadas() {
        int totalHoras = 0;
        for (Disciplina d : disciplinasMatriculadas) {
            totalHoras += d.cargaHoraria;
        }
        return totalHoras;
    }
    public void listarDisciplinas() {
        System.out.println("Disciplinas de " + nome + ":");
        for (Disciplina d : disciplinasMatriculadas) {
            System.out.println("- " + d.nome + " (Carga: " + d.cargaHoraria + " horas)");
        }
    }
}

class Curso {
    List<Disciplina> disciplinas = new ArrayList<>();
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    public void disciplinasFaltando(Aluno aluno) {
        System.out.println("Disciplinas que " + aluno.nome + " precisa completar:");
        for (Disciplina d : disciplinas) {
            if (!aluno.disciplinasMatriculadas.contains(d)) {
                System.out.println("- " + d.nome);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Silva");
        Disciplina d1 = new Disciplina("Matemática", 60, prof1);
        Disciplina d2 = new Disciplina("Física", 45, prof1);
        Disciplina d3 = new Disciplina("Química", 30, prof1);

        Curso curso = new Curso();
        curso.adicionarDisciplina(d1);
        curso.adicionarDisciplina(d2);
        curso.adicionarDisciplina(d3);

        Aluno aluno = new Aluno("Lucas");
        aluno.matricular(d1);
        aluno.matricular(d2);

        aluno.listarDisciplinas();
        System.out.println("Total de horas cursadas: " + aluno.getHorasCursadas());
        curso.disciplinasFaltando(aluno);
    }
}
