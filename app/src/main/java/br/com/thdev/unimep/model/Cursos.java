package br.com.thdev.unimep.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thiag on 16/06/2016.
 */
public class Cursos {
    @SerializedName("count")
    public int count;

    @SerializedName("cursos")
    public List<Curso> cursos;
}
