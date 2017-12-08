/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Projeto{ 
    private String nomeResponsavel;
    private String nome;
    private String descricao;
    private Date dataAbertura;
    private Date dataEncerramento;
    private Boolean status = true;

    public Projeto(String nomeResponsavel, String nome, String descricao, Date dataAbertura, Date dataEncerramento, Boolean status) {
        this.nomeResponsavel = nomeResponsavel;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.status = status;
    }

    public Projeto(String nomeResponsavel, String descricao) {
        this.nomeResponsavel = nomeResponsavel;
        this.descricao = descricao;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Projeto() {
    }

    @Override
    public String toString() {
        if(status){
            return nome + " - " + descricao + " - Ativo";
        }else{
            return nome + " - " + descricao + " - Inativo";
        }
        
    }
}   
