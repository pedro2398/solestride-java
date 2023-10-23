package br.com.fiap.solestride.domain;
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
    private String CNPJ_for;
    @Column(name = "EMAIL_FORNECEDOR", nullable = false)
    private String email;
    @Column(name = "SENHA_FORNECEDOR", nullable = false)
    private String senha;
    @Column(name = "MTF_FORNECEDOR", nullable = false)
    private String mod_tributario_form;

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

    public String getCNPJ_for() {
        return CNPJ_for;
    }

    public void setCNPJ_for(String CNPJ_for) {
        this.CNPJ_for = CNPJ_for;
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

    public String getMod_tributario_form() {
        return mod_tributario_form;
    }

    public void setMod_tributario_form(String mod_tributario_form) {
        this.mod_tributario_form = mod_tributario_form;
    }

    public Fornecedor() {
    }

    public Fornecedor(Long id, String nome, String CNPJ_for, String email, String senha, String mod_tributario_form) {
        this.id = id;
        this.nome = nome;
        this.CNPJ_for = CNPJ_for;
        this.email = email;
        this.senha = senha;
        this.mod_tributario_form = mod_tributario_form;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CNPJ_for='" + CNPJ_for + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", mod_tributario_form='" + mod_tributario_form + '\'' +
                '}';
    }
}
