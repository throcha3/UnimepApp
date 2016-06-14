package br.com.thdev.unimep.database.Table;

/**
 * Created by thiag on 13/06/2016.
 */
public interface AgendaTable {

    String TABELA = "Agendas";
    String ID = "_id";
    String DISCIPLINA = "disciplina";
    String TIPO = "tipo";
    String DEADLINE = "deadline";
    String DESCRICAO = "descricao";




    String SQL_CREATE="create table if not exists "+TABELA+" (" +
                ID +" integer primary key, " +
                DISCIPLINA +" text, " +
                TIPO +" text, " +
                DEADLINE +" text, " +
                DESCRICAO+" text);";

    String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA;

}
