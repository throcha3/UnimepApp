package br.com.thdev.unimep.database.Table;

/**
 * Created by thiag on 16/06/2016.
 */
public interface CursoTable {
    String TABELA = "Cursos";
    String ID = "_id";
    String NOME = "disciplina";
    String QT_SEMESTRE = "qt_semestre";
    String PROFISSAO = "profissão";
    String CURSO = "curso";
    String CAMPUS = "campus";

    String SQL_CREATE="create table if not exists "+TABELA+" (" +
            ID +" integer primary key, " +
            NOME +" text, " +
            QT_SEMESTRE +" integer, " +
            CAMPUS +" integer, " +
            PROFISSAO +" text, " +
            CURSO+" text);";

    String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABELA;
}
