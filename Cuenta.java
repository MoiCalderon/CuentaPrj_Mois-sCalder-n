public class Cuenta
{
    private String cuentaHabiente;
    private double saldo;
    
    private static int contador = 0;
    private int numeroCuenta;
    
    public Cuenta(double saldoInicial)
    {
        this.saldo = saldoInicial;
        this.cuentaHabiente = "Sin definir";
        contador++;
        this.numeroCuenta = contador;
    }

    public Cuenta(String cuentaHabiente, double saldoInicial) 
    {
        this.cuentaHabiente = cuentaHabiente;
        this.saldo = saldoInicial;
        contador++;
        this.numeroCuenta = contador;
    }
    
    public static int getCantidadCuentas()
    {
        return contador;
    }
    
    public void setCuentaHabiente(String nombre)
    {
        this.cuentaHabiente = nombre;
    }
    
    public double depositar(double monto) 
    {
        if (monto > 0) 
        {
            this.saldo += monto;
        }
        return this.saldo;
    }
    
    public double retirar(double monto) 
    {
        if (monto > 0 && monto <= saldo) 
        {
            this.saldo -= monto;
        }
        return this.saldo;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public String toString()
    {
        return "CuentaN°: " + numeroCuenta +
                "| Titular: " + cuentaHabiente +
                "| Saldo: " + saldo;
    }
    
}
