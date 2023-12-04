package br.com.fiap.solestride.domain.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "TB_FORNECEDOR", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CNPJ_FORNECEDOR", columnNames = "CNPJ_FORNECEDOR")
})
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FORNECEDOR")
    @Column(name = "ID_FORNECEDOR")
    private Long id;
    @Column(name = "NM_FORNECEDOR", nullable = false)
    private String nome;
    @Column(name = "CNPJ_FORNECEDOR", nullable = false)
    private String cnpj;
    @Column(name = "EMAIL_FORNECEDOR", nullable = false)
    private String email;
    @Column(name = "SENHA_FORNECEDOR", nullable = false)
    private String senha;
    @Column(name = "MTF_FORNECEDOR", nullable = false)
    private String modTributarioFornecedor;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getModTributarioFornecedor() {
        return modTributarioFornecedor;
    }

    public void setModTributarioFornecedor(String modTributarioFornecedor) {
        this.modTributarioFornecedor = modTributarioFornecedor;
    }

    public Fornecedor() {
    }

    public Fornecedor(Long id, String nome, String CNPJ_for, String email, String senha, String modTributarioFornecedor) {
        this.id = id;
        this.nome = nome;
        this.cnpj = CNPJ_for;
        this.email = email;
        this.senha = senha;
        this.modTributarioFornecedor = modTributarioFornecedor;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", modTributarioFonecedor='" + modTributarioFornecedor + '\'' +
                '}';
    }
}
