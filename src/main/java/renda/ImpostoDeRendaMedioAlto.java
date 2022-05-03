package renda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoDeRendaMedioAlto implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("2826.65");
    private final BigDecimal VALOR_MAXIMO = new BigDecimal("3751.06");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0 && salario.compareTo(VALOR_MAXIMO) <= -1;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return (salario.multiply(new BigDecimal("0.15")).setScale(2, RoundingMode.HALF_UP));
    }
}
