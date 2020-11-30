public class Banco implements Runnable {

    public Conta conta;

    public void run() {
        synchronized (conta) {
            for (int i = 10; i <= 100; i += 10) {
                conta.depositar(i);
                System.out.println("Deposito: " + i);
                System.out.println("Saldo Atual: " + conta.saldo);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

    } {
        
    }
}
