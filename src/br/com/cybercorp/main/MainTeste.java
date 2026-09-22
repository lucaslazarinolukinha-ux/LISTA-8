package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {
    public static void main(String[] args) {
        // 1. Departamento, Funcionário e Veículo
        Departamento ti = new Departamento("TI", "Tecnologia da Informação", 3);
        Funcionario func = new Funcionario("F001", "Carlos", ti);
        Veiculo veiculo = new Veiculo("ABC-1234", "Onix", func);

        // 2. Sistema com 2 vagas
        SistemaSeguranca sistema = new SistemaSeguranca(2);

        // 3 e 4. Credencial original e clone
        Credencial c1 = new Credencial("FFF-999", true, func);
        Credencial clone = new Credencial("FFF-999", true, func);

        // 5. Teste da Catraca (mesmo funcionário duas vezes, deve permitir)
        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        // 6. Teste do Cofre (HashSet deve bloquear o clone)
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        // 7. Teste da Garagem
        sistema.estacionarVeiculo(veiculo, 0);
        sistema.estacionarVeiculo(veiculo, 5); // ArrayIndexOutOfBoundsException esperado aqui
    }
}
