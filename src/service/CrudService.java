package service;

import exceptions.CrudException;
import model.Aluno;
import model.Pessoa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudService {
    private Scanner sc;
    private List<Pessoa> regPessoas = new ArrayList<>();
    private List<Aluno> regAlunos = new ArrayList<>();

    public CrudService(Scanner sc) {
        this.sc = sc;
        Pessoa pessoa = new Pessoa("João", "988776655", "01-01-1990", LocalDateTime.now(), LocalDateTime.now());
        Pessoa pessoa1 = new Pessoa("Douglas", "977665533", "15-08-1970", LocalDateTime.now(), LocalDateTime.now());
        Aluno aluno = new Aluno("Pedro", "988776655", "01-01-1800", LocalDateTime.now(), LocalDateTime.now(), 10.0);
        Aluno aluno1 = new Aluno("Felipe", "987654321", "21-08-1999", LocalDateTime.now(), LocalDateTime.now(), 8.0);
        regAlunos.add(aluno);
        regAlunos.add(aluno1);
        regPessoas.add(pessoa);
        regPessoas.add(pessoa1);
    }

    public void cadastrar() {
        Double notaFinal = null;
        sc.nextLine();
        System.out.println("Digite o nome do cadastro:");
        String nome = sc.nextLine();
        System.out.println("Digite um telefone de cadastro:");
        String telefone = sc.nextLine();
        System.out.println("Digite a data de nascimento do cadastro:");
        String nascimento = sc.nextLine();
        System.out.println("Entre com a nota final do aluno ou deixe em branco para cadastrar como pessoa.");
        String notaFinalStr = sc.nextLine();
        if (!notaFinalStr.isEmpty()) {
            while (true) {
                try {
                    notaFinal = Double.valueOf(notaFinalStr.replace(",", "."));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Valor inserido inválido!");
                }
                System.out.println("Entre com a nota final do aluno ou deixe em branco para cadastrar como pessoa.");
                notaFinalStr = sc.nextLine();
                if (notaFinalStr.isEmpty()) {
                    break;
                }
            }
        }

        if (notaFinal != null) {
            Aluno aluno = new Aluno(nome, telefone, nascimento, LocalDateTime.now(), LocalDateTime.now(), notaFinal);
            regAlunos.add(aluno);
        } else {
            Pessoa pessoa = new Pessoa(nome, telefone, nascimento, LocalDateTime.now(), LocalDateTime.now());
            pessoa.setEditDate(LocalDateTime.now());
            regPessoas.add(pessoa);
        }
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void mostrarRegistros(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Pessoas:");
                regPessoas.forEach(item -> System.out.println("ID: " + regPessoas.indexOf(item) + "" + item));
                break;

            case 2:
                System.out.println("Alunos:");
                regAlunos.forEach(item -> System.out.println("ID: " + regAlunos.indexOf(item) + "" + item));
                break;
            case 3:
                System.out.println("Pessoas:");
                regPessoas.forEach(item -> System.out.println("ID: " + regPessoas.indexOf(item) + "" + item));
                System.out.println("Alunos:");
                regAlunos.forEach(item -> System.out.println("ID: " + regAlunos.indexOf(item) + "" + item));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void excluirCadastroPorId() {
        boolean continua = true;
        System.out.println("\nDe qual grupo deseja excluir?\n1 - Pessoas.\n2 - Alunos");
        int grupo = sc.nextInt();
        if (grupo != 1 && grupo != 2) {
            System.out.println("Opção de grupo inválida!");
        } else {
            sc.nextLine();
            System.out.println("Entre com o ID referente ao cadastro a ser excluido");
            int id = -1;
            String idStr = sc.nextLine();
            if (grupo == 1) {
                while (true) {
                    if (!idStr.isEmpty()) {
                        while (true) {
                            try {
                                id = Integer.parseInt(idStr);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inserido inválido!");
                            }
                            System.out.println("Entre com o ID referente ao cadastro a ser excluido (Digite 'sair' para encerrar):");
                            idStr = sc.nextLine();
                            if (idStr.equals("sair")) {
                                break;
                            }
                        }
                    }
                    if (idStr.equals("sair")) {
                        break;
                    } else if (id < 0 || id >= regPessoas.size()) {
                        System.out.println("ID inexistente, tente novamente (Digite 'sair' para encerrar):");
                        idStr = sc.nextLine();
                        if (idStr.equals("sair")) {
                            break;
                        }
                    } else {
                        regPessoas.remove(id);
                        System.out.println("Cadastro excluido com sucesso!");
                        break;
                    }
                }
            } else {
                while (true) {
                    if (!idStr.isEmpty()) {
                        while (true) {
                            try {
                                id = Integer.parseInt(idStr);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inserido inválido!");
                            }
                            System.out.println("Entre com o ID referente ao cadastro a ser excluido (Digite 'sair' para encerrar):");
                            idStr = sc.nextLine();
                            if (idStr.equals("sair")) {
                                break;
                            }
                        }
                    }
                    if (idStr.equals("sair")) {
                        break;
                    } else if (id < 0 || id >= regAlunos.size()) {
                        System.out.println("ID inexistente, tente novamente (Digite 'sair' para encerrar):");
                        idStr = sc.nextLine();
                        if (idStr.equals("sair")) {
                            break;
                        }
                    } else {
                        regAlunos.remove(id);
                        System.out.println("Cadastro excluido com sucesso!");
                        break;
                    }
                }
            }
        }

    }

    public Pessoa buscarPessoaPorId(int id) {
        if (id < 0 || id >= regPessoas.size()) {
            throw new CrudException("ID inválido");
        } else {
            return regPessoas.get(id);
        }
    }

    public Aluno buscarAlunoPorId(int id) {
        if (id < 0 || id >= regAlunos.size()) {
            throw new CrudException("ID inválido");
        }
        ;
        return regAlunos.get(id);
    }

    public void alterarPessoa(int id) {
        Pessoa pessoa = this.buscarPessoaPorId(id);
        System.out.println(
                "Entre com a opção que deseja alterar:\n" +
                        "1. Nome (Atual:" + pessoa.getNome() + ").\n" +
                        "2. Telefone (Atual: " + pessoa.getTelefone() + ").\n" +
                        "3. Nascimento (Atual: " + pessoa.getNascimento() + ")."
        );
        int opcaoAlteracao = sc.nextInt();
        String nome;
        String telefone;
        String nascimento;
        boolean ok = true;
        sc.nextLine();
        switch (opcaoAlteracao) {
            case 1:
                System.out.println("Entre com o novo nome:");
                nome = sc.nextLine();
                pessoa.setNome(nome);
                break;
            case 2:
                System.out.println("Entre com o novo numero de telefone:");
                telefone = sc.nextLine();
                pessoa.setTelefone(telefone);
                break;
            case 3:
                System.out.println("Entre com a nova data de nascimento:");
                nascimento = sc.nextLine();
                pessoa.setNascimento(nascimento);
                break;
            default:
                ok = false;
                System.out.println("Opção inválida!");
                break;
        }
        if (ok) {
            System.out.println("Cadastro atualizado com sucesso!");
            pessoa.setEditDate(LocalDateTime.now());
        }

    }

    public void alterarAluno(int id) {
        Aluno aluno = this.buscarAlunoPorId(id);
        System.out.println(
                "Entre com a opção que deseja alterar:\n" +
                        "1. Nome (Atual: " + aluno.getNome() + ").\n" +
                        "2. Telefone (Atual: " + aluno.getTelefone() + ").\n" +
                        "3. Nascimento (Atual: " + aluno.getNascimento() + ").\n" +
                        "4. Nota (Atual: " + aluno.getNotaFinal() + ")."
        );
        int opcaoAlteracao = sc.nextInt();
        String nome;
        String telefone;
        String nascimento;
        Double notaFinal;
        String notaFinalStr;
        boolean ok = true;
        sc.nextLine();
        switch (opcaoAlteracao) {
            case 1:
                System.out.println("Entre com o novo nome:");
                nome = sc.nextLine();
                aluno.setNome(nome);
                break;
            case 2:
                System.out.println("Entre com o novo numero de telefone:");
                telefone = sc.nextLine();
                aluno.setTelefone(telefone);
                break;
            case 3:
                System.out.println("Entre com a nova data de nascimento:");
                nascimento = sc.nextLine();
                aluno.setNascimento(nascimento);
                break;
            case 4:
                notaFinal = null;
                System.out.println("Entre com a nova nota");
                notaFinalStr = sc.nextLine();
                if (!notaFinalStr.isEmpty()) {
                    while (true) {
                        try {
                            notaFinal = Double.valueOf(notaFinalStr.replace(",", "."));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inserido inválido!");
                        }
                        System.out.println("Entre com a nota");
                        notaFinalStr = sc.nextLine();
                    }
                }
                aluno.setNotaFinal(notaFinal);
                break;
            default:
                ok = false;
                System.out.println("Opção inválida!");
                break;
        }
        if (ok) {
            System.out.println("Cadastro atualizado com sucesso!");
            aluno.setEditDate(LocalDateTime.now());
        }
    }

}