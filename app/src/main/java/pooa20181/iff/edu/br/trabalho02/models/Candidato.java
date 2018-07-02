package pooa20181.iff.edu.br.trabalho02.models;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Candidato extends RealmObject implements Serializable {


    @PrimaryKey
    private int id;
    private String nome;
    private String cargo;
    private String partido;
    private String numUrna;
    private String numVotos;
    private String estado;
    private String municipio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNumUrna() {
        return numUrna;
    }

    public void setNumUrna(String numUrna) {
        this.numUrna = numUrna;
    }

    public String getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(String numVotos) {
        this.numVotos = numVotos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Candidato(int id, String nome, String partido, String numUrna, String cargo) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numUrna = numUrna;
        this.cargo = cargo;
    }

    public Candidato(int id, String nome, String partido, String numUrna,
                     String cargo, String estado, String numVotos, String municipio) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numUrna = numUrna;
        this.cargo = cargo;
        this.estado = estado;
        this.numVotos = numVotos;
        this.municipio = municipio;

    }

    public Candidato() {
    }
}