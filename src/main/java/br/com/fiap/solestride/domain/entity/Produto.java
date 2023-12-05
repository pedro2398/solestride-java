package br.com.fiap.solestride.domain.entity;
import br.com.fiap.solestride.domain.entity.pessoa.Fabricante;
import br.com.fiap.solestride.domain.entity.pessoa.Fornecedor;
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
    private String codProduto;
    @Column(name = "DESC_PRODUTO", nullable = false)
    private String descricao;
    @Column(name = "MODELO_PRODUTO", nullable = false)
    private String modelo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_FABRICANTE",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PRODUTO_FABRICANTE"),
            nullable = false
    )
    private Fabricante fabricante;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_FORNECEDOR",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PRODUTO_FORNECEDOR"),
            nullable = false
    )
    private Fornecedor fornecedor;

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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Fornecedor getFornecedores() {
        return fornecedor;
    }

    public void setFornecedores(Fornecedor fornecedores) {
        this.fornecedor = fornecedores;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, String codProduto, String descricao, String modelo, Fabricante fabricante) {
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
