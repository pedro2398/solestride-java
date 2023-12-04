package br.com.fiap.solestride.domain.entity;
import jakarta.persistence.*;
//import jakarta.json.bind.annotation.JsonbDateFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "TB_REQUISICAO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_COD_REQUISICAO", columnNames = "COD_REQUISICAO")
})
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REQUISICAO")
    @Column(name = "ID_REQUISICAO")
    private Long id;
    @Column(name = "COD_REQUISICAO", nullable = false)
    private String codRequisicao;
    @Column(name = "QTD_REQUISICAO", nullable = false)
    private Integer quantidade;
    @Column(name = "TETO_REQUISICAO", nullable = false)
    private BigDecimal tetoAutomatico;
    //@JsonbDateFormat
    @Column(name = "DT_REQUISICAO", nullable = false)
    private LocalDate data;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_REQ_PRODUTO",
            referencedColumnName = "ID_PRODUTO",
            foreignKey = @ForeignKey(name = "FK_REQUISICAO_PRODUTO"),
            nullable = false
    )
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodRequisicao() {
        return codRequisicao;
    }

    public void setCodRequisicao(String codRequisicao) {
        this.codRequisicao = codRequisicao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTetoAutomatico() {
        return tetoAutomatico;
    }

    public void setTetoAutomatico(BigDecimal tetoAutomatico) {
        this.tetoAutomatico = tetoAutomatico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Requisicao() {
    }

    public Requisicao(Long id, String codRequisicao, String codProduto, Integer quantidade, BigDecimal tetoAutomatico, LocalDate data, Produto produto) {
        this.id = id;
        this.codRequisicao = codRequisicao;
        this.quantidade = quantidade;
        this.tetoAutomatico = tetoAutomatico;
        this.data = data;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Requisicao{" +
                "id=" + id +
                ", codRequisicao='" + codRequisicao + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", tetoAutomatico='" + tetoAutomatico + '\'' +
                ", data=" + data +
                ", produto=" + produto +
                '}';
    }
}
