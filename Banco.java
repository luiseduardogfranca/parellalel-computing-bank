public class Banco implements Runnable {

    public Conta conta;

    public void run() {
        synchronized (conta) {
            for (int i = 50; i <= 100; i += 10) {
                conta.depositar(i - 5);
                System.out.println("Deposito: " + (i - 5));
                System.out.println("Saldo Atual: " + conta.saldo);
                try {
                    conta.sacar(i);
                    System.out.println("Saque: " + i);
                    System.out.println("Saldo Atual: " + conta.saldo);
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("Saque: " + i);
                    System.err.println(e.getMessage());
                }
            } 
        }
    }

    public static void main(String[] args) {
        Conta conta = new Conta();
        Banco banco = new Banco();
        banco.conta = conta;

        Thread thread1 = new Thread(banco);
        Thread thread2 = new Thread(banco);

        thread1.start();
        thread2.start();

    }
}

