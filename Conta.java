public class Conta {
    private String numero;
    private String cpfTitular;

    public Conta(String numero, String cpfTitular) {
        this.numero = numero;
        this.cpfTitular = cpfTitular;
    }

    @Override
    public String toString() {
        return numero + ";" + cpfTitular;
    }
}
