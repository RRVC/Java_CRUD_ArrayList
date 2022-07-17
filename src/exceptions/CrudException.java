package exceptions;

public class CrudException extends RuntimeException{
    public String erro;

    public CrudException(String erro){
        super(erro);
    }
}