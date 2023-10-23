package br.com.fiap.solestride.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_COD_PRODUTO", columnNames = "COD_PRODUTO")
})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @Column(name = "ID_PRODUTO")
    private Long id;
    @Column(name = "NM_NOME", nullable = false)
    private String nome;
    @Column(name = "COD_PRODUTO", nullable = false)
    private String cod_produto;
    @Column(name = "DESC_PRODUTO", nullable = false)
    private String descricao;
    @Column(name = "MODELO_PRODUTO", nullable = false)
    private String modelo;
    @Column(name = "FAB_PRODUTO", nullable = false)
    private String fabricante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, String cod_produto, String descricao, String modelo, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.cod_produto = cod_produto;
        this.descricao = descricao;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cod_produto='" + cod_produto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
