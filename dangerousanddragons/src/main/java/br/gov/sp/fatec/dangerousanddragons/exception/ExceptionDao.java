package br.gov.sp.fatec.dangerousanddragons.exception;

public class ExceptionDao extends RuntimeException{

    public ExceptionDao(String exceptionMessage){
        super(exceptionMessage);
    }
}
