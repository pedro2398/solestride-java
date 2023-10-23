package br.com.fiap.solestride.domain;
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
    private String cod_requisicao;
    @Column(name = "QTD_REQUISICAO", nullable = false)
    private Integer quantidade;
    @Column(name = "TETO_REQUISICAO", nullable = false)
    private BigDecimal teto_automatico;
    //@JsonbDateFormat
    @Column(name = "DT_REQUISICAO", nullable = false)
    private LocalDate data;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_REQ_PRODUTO",
            referencedColumnName = "ID_PRODUTO",
            foreignKey = @ForeignKey(name = "TB_REQUISICAO_FK_PRODUTO"),
            nullable = false
    )
    private Produto id_req_produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_requisicao() {
        return cod_requisicao;
    }

    public void setCod_requisicao(String cod_requisicao) {
        this.cod_requisicao = cod_requisicao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTeto_automatico() {
        return teto_automatico;
    }

    public void setTeto_automatico(BigDecimal teto_automatico) {
        this.teto_automatico = teto_automatico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto getId_req_produto() {
        return id_req_produto;
    }

    public void setId_req_produto(Produto id_req_produto) {
        this.id_req_produto = id_req_produto;
    }

    public Requisicao() {
    }

    public Requisicao(Long id, String cod_requisicao, String cod_produto, Integer quantidade, BigDecimal teto_automatico, LocalDate data, Produto id_req_produto) {
        this.id = id;
        this.cod_requisicao = cod_requisicao;
        this.quantidade = quantidade;
        this.teto_automatico = teto_automatico;
        this.data = data;
        this.id_req_produto = id_req_produto;
    }

    @Override
    public String toString() {
        return "Requisicao{" +
                "id=" + id +
                ", cod_requisicao='" + cod_requisicao + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", teto_automatico='" + teto_automatico + '\'' +
                ", data=" + data +
                ", id_req_produto=" + id_req_produto +
                '}';
    }
}
