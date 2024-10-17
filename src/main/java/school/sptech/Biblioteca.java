package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(){
        this.livros = new ArrayList<>();
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        if(livro == null || livro.getTitulo() == null || livro.getTitulo().trim().isEmpty() ||
                livro.getAutor() == null || livro.getAutor().trim().isEmpty() || livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Erro");
        }

        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo){
        Livro lv = null;

        if(titulo == null || titulo.trim().isEmpty()){
            throw new ArgumentoInvalidoException("Erro");
        }

        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                lv = livro;
            }
        }

        if(lv == null){
            throw new LivroNaoEncontradoException("Livro não encontrado");
        }

        livros.remove(lv);
    }

    public Livro buscarLivroPorTitulo(String titulo){
        Livro lv = null;

        if(titulo == null || titulo.trim().isEmpty()){
            throw new ArgumentoInvalidoException("Erro");
        }

        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                lv = livro;
            }
        }

        if(lv == null){
            throw new LivroNaoEncontradoException("Livro não encontrado");
        }

        return lv;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosDatas = new ArrayList<>();

        for(Livro livro : livros){
            if(livro.getDataPublicacao().getYear() <= ano){
                livrosDatas.add(livro);
            }
        }

        return livrosDatas;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> top5 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Livro lv = null;
            Double maiorMedia = Double.MIN_VALUE;

            for (Livro livro : livros) {
                Double media = livro.calcularMediaAvaliacoes();
                if (media > maiorMedia && !top5.contains(livro)) {
                    maiorMedia = media;
                    lv = livro;
                }
            }

            if (lv != null) {
                top5.add(lv);
            } else {
                break;
            }
        }

        return top5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
