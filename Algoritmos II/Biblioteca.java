import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Livro {
    String titulo, autor;
    boolean emprestado;
    String nomeEmprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
        this.nomeEmprestado = "";
    }

    public void emprestar(String nome) {
        emprestado = true;
        nomeEmprestado = nome;
    }

    public void devolver() {
        emprestado = false;
        nomeEmprestado = "";
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String info() {
        return titulo + " - " + autor + (emprestado ? " (Emprestado por " + nomeEmprestado + ")" : "");
    }
}

class Biblioteca {
    List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(String titulo, String nome) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo)) {
                if (!livro.isEmprestado()) {
                    livro.emprestar(nome);
                    System.out.println("Emprestado: " + titulo);
                    return;
                }
                System.out.println("Livro já emprestado: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado: " + titulo);
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                System.out.println(livro.info());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis"));

        biblioteca.emprestarLivro("1984", "Carlos");
        biblioteca.
