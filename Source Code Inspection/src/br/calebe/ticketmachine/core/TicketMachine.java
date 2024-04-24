package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    private int valor;
    private int saldo;
    private int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int precoDoBilhete) {
        this.valor = precoDoBilhete;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<PapelMoeda> getTroco() throws SaldoInsuficienteException{
        if (saldo <= 0) {
            throw new SaldoInsuficienteException();
        }

        int valorTroco = saldo;
        saldo = 0;

        Troco troco = new Troco(valorTroco);
        return troco.getIterator();
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }

        String result = "*****************\n";
        result += "Bilhete impresso no valor de:\n";
        result += "*** R$ " + valor + ",00 ****\n";
        result += "*****************\n";

        saldo = saldo - valor;

        return result;
    }
}
