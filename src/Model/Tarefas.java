package Model;

import java.time.LocalDate;

public class Tarefas {

    //ATRIBUTOS >>> BANCO DE DADOS
    private int idTarefas;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private LocalDate dataCriacao;

    //CONSTRUTORES
    //CRIAR NOVA TAREFA
    public Tarefas(String titulo, String descricao, boolean concluida, LocalDate dataCriacao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
    }
    public Tarefas(int id, String titulo, String descricao, boolean concluida, LocalDate dataCriacao){
        this.idTarefas = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
    }
    public Tarefas(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false; //COMEÇA PENDENTE
        this.dataCriacao = LocalDate.now(); //DATA DE HOJE
    }

    //GETTERS E SETTERS(ENCAPSULAMENTO)
    //GETTERS PARA LER E SETTERS PARA LER DE FORMA CONTROLADA AS INFO QUE ENTRAM
    public int getIdTarefas(){return idTarefas;}
    public void setIdTarefas(int id){this.idTarefas = idTarefas;}

    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}

    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao = descricao;}

    public boolean isConcluida(){return concluida;}
    public void setConcluida(boolean concluida){this.concluida = concluida;}

    public LocalDate getDataCriacao(){return dataCriacao;}
    public void setDataCriacao(LocalDate dataCriacao){this.dataCriacao = dataCriacao;}

    //IRÁ SER UTIL PARA EXIBIR INFO NO TERMINAL
    @Override
    public String toString(){
        String status = concluida ? "✔ Concluída" : "⏳ Pendente";
        return String.format("[%d] %s | %s | %s | Criada em: %s",
                idTarefas, titulo, descricao, status, dataCriacao);
    }
}
