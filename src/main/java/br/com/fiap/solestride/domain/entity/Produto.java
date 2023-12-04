package br.com.fiap.solestride.domain.entity;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private String codProduto;
    @Column(name = "DESC_PRODUTO", nullable = false)
    private String descricao;
    @Column(name = "MODELO_PRODUTO", nullable = false)
    private String modelo;
    @Column(name = "FAB_PRODUTO", nullable = false)
    private String fabricante;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PRODUTO_FORNECEDOR",
            joinColumns = {
                    @JoinColumn(
                            name = "ID_PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_FORNECEDOR")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_FORNECEDOR",
                            referencedColumnName = "ID_FORNECEDOR",
                            foreignKey = @ForeignKey(name = "FK_FORNECEDOR_PRODUTO")
                    )
            }
    )
    private Set<Fornecedor> fornecedores = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
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

    public Produto addFornecedor(Fornecedor forn) {
        fornecedores.add(forn);
        return this;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, String codProduto, String descricao, String modelo, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codProduto='" + codProduto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
