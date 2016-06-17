package br.com.thdev.unimep.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiag on 16/06/2016.
 */
public class Curso {
    @SerializedName("cur_id")
    public long _id;

    public String nome;
    @SerializedName("qt_semestre")
    public int qtSemestre;

    public String curso;

    public String profissão;

    public int campus;

}
