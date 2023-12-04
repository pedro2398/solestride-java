package br.com.fiap.solestride.domain.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;
    @Column(name = "NOME_PESSOA" ,nullable = false)
    private String nome;
    @Column(name = "CNPJ_PESSOA", nullable = false)
    private String cnpj;
    @Column(name = "EMAIL_PESSOA", nullable = false)
    private String email;
    @Column(name = "SENHA_PESSOA", nullable = false)
    private String senha;
    @Column(name = "MOD_TRIBUTARIO", nullable = false)
    private String modTributario;
    @Column(name = "TP_PESSOA", nullable = false)
    private String tipo;

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

    public String getModTributario() {
        return modTributario;
    }

    public void setModTributario(String modTributario) {
        this.modTributario = modTributario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Pessoa() {
    }
    public Pessoa(String tipo) {
        this.tipo = tipo;
    }
    public Pessoa(Long id, String nome, String cnpj, String email, String senha, String modTributario, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.modTributario = modTributario;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", modTributario='" + modTributario + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
