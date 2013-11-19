
package br.com.sgce.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_aluno")
    private Integer id_aluno;
    @Column(name = "nome_aluno", nullable = false, length = 45)
    private String nome;
    @Column(name = "responsavel_aluno", nullable = false, length = 45)
    private String responsavel;
    @Column(name = "email_aluno", nullable = false, length = 45)
    private String email;
    @Column(name = "endereco_aluno", nullable = false, length = 45)
    private String endereco;
    @Column(name = "bairro_aluno", nullable = false, length = 45)
    private String bairro;
    @Column(name = "cidade_aluno", nullable = false, length = 6)
    private String cidade;

    public Aluno() {
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.id_aluno != other.id_aluno && (this.id_aluno == null || !this.id_aluno.equals(other.id_aluno))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id_aluno != null ? this.id_aluno.hashCode() : 0);
        return hash;
    }
}
