import java.util.HashMap;
import java.util.Map;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Carrinho {
    private Map<Produto, Integer> produtos;

    public Carrinho() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidade(s) de " + produto.getNome() + " adicionada(s) ao carrinho.");
    }

    public void removerProduto(Produto produto) {
        if (produtos.containsKey(produto)) {
            produtos.remove(produto);
            System.out.println(produto.getNome() + " removido do carrinho.");
        } else {
            System.out.println(produto.getNome() + " não está no carrinho.");
        }
    }

    public void atualizarQuantidade(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            if (quantidade <= 0) {
                removerProduto(produto);
            } else {
                produtos.put(produto, quantidade);
                System.out.println("Quantidade de " + produto.getNome() + " atualizada para " + quantidade + ".");
            }
        } else {
            System.out.println(produto.getNome() + " não está no carrinho.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            System.out.println("- " + entry.getKey().getNome() + " (Preço: R$ " + entry.getKey().getPreco() + ", Quantidade: " + entry.getValue() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Camisa", 59.90);
        Produto produto2 = new Produto("Calça", 89.90);
        Produto produto3 = new Produto("Tênis", 199.90);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(produto1, 2);
        carrinho.adicionarProduto(produto2, 1);
        
        carrinho.listarProdutos();
        System.out.println("Total: R$ " + carrinho.calcularTotal());

        carrinho.atualizarQuantidade(produto1, 3);
        
        carrinho.removerProduto(produto2);
        
        carrinho.listarProdutos();
        System.out.println("Total após remoção: R$ " + carrinho.calcularTotal());
    }
}
