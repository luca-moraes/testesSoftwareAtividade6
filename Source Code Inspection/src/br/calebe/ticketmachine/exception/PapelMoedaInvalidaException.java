package br.calebe.ticketmachine.exception;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoedaInvalidaException extends Exception {
    public PapelMoedaInvalidaException(String message) {
        super(message);
    }
    public PapelMoedaInvalidaException() {
        super("Valor de papel moeda inválido!");
    }
}
