package br.com.thdev.unimep.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thiag on 13/06/2016.
 */
public class Agendas {
    @SerializedName("agendas")
    public List<Agenda> agendas;
}
