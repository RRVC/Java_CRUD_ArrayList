package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa {
    private Double notaFinal;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

    public Aluno(String nome, String telefone, String nascimento, LocalDateTime regDate, LocalDateTime editDate, Double notaFinal) {
        super(nome, telefone, nascimento, regDate, editDate);
        this.notaFinal = notaFinal;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return ", nome: " + getNome() +
                ", telefone: " + getTelefone() +
                ", nascimento: " + getNascimento() +
                ", data de registro: " + dtf.format(getRegDate()) +
                ", data de alteração: " + dtf.format(getEditDate()) +
                ", notaFinal: " + getNotaFinal() +
                '}';
    }


}