public class Conta {

    public double saldo;

    public Conta() {
        // default constructor
    };

    public void sacar(double valor) throws Exception {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new Exception("Saldo insuficiente para saque!");
        }

    }

    public void depositar(double valor) {
        saldo += valor;
    }

}
