package br.com.thdev.unimep.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiag on 16/05/2016.
 */
public class Agenda {
    @SerializedName("age_id")
    public long _id;
    @SerializedName("id_disciplina")
    public String disciplina;

    public String tipo;

    public String deadline;

    public String descricao;



}
