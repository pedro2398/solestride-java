package br.com.fiap.solestride.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_COMPRADOR", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CNPJ_COMP", columnNames = "CNPJ_COMP")
})
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COMPRADOR")
    @Column(name = "ID_COMPRADOR")
    private Long id;
    @Column(name = "NM_COMPRADOR", nullable = false)
    private String nome;
    @Column(name = "CNPJ_COMP", nullable = false)
    private String CNPJ_comp;
    @Column(name = "EMAIL_COMPRADOR", nullable = false)
    private String email;
    @Column(name = "SENHA_COMPRADOR", nullable = false)
    private String senha;
    @Column(name = "MTC_COMPRADOR", nullable = false)
    private String mod_tributario_comp;

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

    public String getCNPJ_comp() {
        return CNPJ_comp;
    }

    public void setCNPJ_comp(String CNPJ_comp) {
        this.CNPJ_comp = CNPJ_comp;
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

    public String getMod_tributario_comp() {
        return mod_tributario_comp;
    }

    public void setMod_tributario_comp(String mod_tributario_comp) {
        this.mod_tributario_comp = mod_tributario_comp;
    }

    public Comprador() {
    }

    public Comprador(Long id, String CNPJ_comp, String email, String senha, String mod_tributario_comp) {
        this.id = id;
        this.CNPJ_comp = CNPJ_comp;
        this.email = email;
        this.senha = senha;
        this.mod_tributario_comp = mod_tributario_comp;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "id=" + id +
                ", CNPJ_comp='" + CNPJ_comp + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", mod_tributario_comp='" + mod_tributario_comp + '\'' +
                '}';
    }
}
