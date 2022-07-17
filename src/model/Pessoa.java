package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private String telefone;
    private String nascimento;
    private LocalDateTime regDate;
    private LocalDateTime editDate;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

    public Pessoa(String nome, String telefone, String nascimento, LocalDateTime regDate, LocalDateTime editDate) {
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.regDate = regDate;
        this.editDate = editDate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    @Override
    public String toString() {
        return ", nome: " + getNome() +
                ", telefone: " + getTelefone() +
                ", nascimento: " + getNascimento() +
                ", data de registro: " + dtf.format(getRegDate()) +
                ", data de alteração: " + dtf.format(getEditDate()) +
                "}";
    }
}