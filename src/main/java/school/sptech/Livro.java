package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(){
        this.avaliacoes = new ArrayList<>();
    }

    public Livro(LocalDate dataPublicacao, String autor, String titulo) {
        this.avaliacoes = new ArrayList<>();
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.titulo = titulo;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if(descricao == null || descricao.trim().isEmpty() || qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5){
            throw new ArgumentoInvalidoException("Erro");
        }

        avaliacoes.add(new Avaliacao(descricao,qtdEstrelas));
    }

    public Double calcularMediaAvaliacoes(){
        Double somaEstrelas = 0.0;
        if(avaliacoes.isEmpty()){
            return 0.0;
        } else {
            for (Avaliacao avaliacao : avaliacoes){
                somaEstrelas += avaliacao.getQtdEstrelas();
            }

            Double media = somaEstrelas / avaliacoes.size();
            return media;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
