import br.com.ada.grupo3.locadora.AgenciaUtilDatabase;
import br.com.ada.grupo3.locadora.VeiculoUtilDatabase;
import br.com.ada.grupo3.locadora.TipoVeiculoUtilDatabase;
import br.com.ada.grupo3.locadora.domain.*;
import br.com.ada.grupo3.locadora.persistence.*;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuGeralFactory;
import br.com.ada.grupo3.locadora.view.agencia.MenuAgenciaFactory;
import br.com.ada.grupo3.locadora.view.aluguel.MenuAluguelFactory;
import br.com.ada.grupo3.locadora.view.cliente.MenuClienteFactory;
import br.com.ada.grupo3.locadora.view.veiculo.MenuVeiculoFactory;

import java.math.BigDecimal;

public class LocateCar {


    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepositoryInMemory();
        AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemory();
        ClienteRepository clienteRepository = new ClienteRepositoryInMemory();
        AluguelRepository aluguelRepository = new AluguelRepositoryInMemory();
        TipoVeiculoRepository tipoVeiculoRepository = new TipoVeiculoRepositoryInMemory();

        VeiculoManager gerenciadorDeVeiculo = new VeiculoManager(veiculoRepository);
        AgenciaManager gerenciadorDeAgencia = new AgenciaManager(agenciaRepository);
        ClienteManager gerenciadorDeCliente = new ClienteManager(clienteRepository);
        AluguelManager gerenciadorDeAluguel = new AluguelManager(aluguelRepository);
        TipoVeiculoManager gerenciadorTipoVeiculo = new TipoVeiculoManager(tipoVeiculoRepository);


        MenuVeiculoFactory menuVeiculoFactory = new MenuVeiculoFactory(gerenciadorDeVeiculo, gerenciadorTipoVeiculo);
        MenuAgenciaFactory menuAgenciaFactory = new MenuAgenciaFactory(gerenciadorDeAgencia);
        MenuClienteFactory menuClienteFactory = new MenuClienteFactory(gerenciadorDeCliente);
        MenuAluguelFactory menuAluguelFactory = new MenuAluguelFactory(gerenciadorDeAluguel, gerenciadorDeCliente, gerenciadorDeAgencia, gerenciadorDeVeiculo);

        Menu menuGeral = new MenuGeralFactory(menuVeiculoFactory, menuAgenciaFactory, menuClienteFactory,
                menuAluguelFactory).create();

        AgenciaUtilDatabase.loadAgenciasFromFile(agenciaRepository);
        TipoVeiculoUtilDatabase.loadTipoVeiculoFromFile(tipoVeiculoRepository);
        inicializarGerenciadorTipoVeiculo(gerenciadorTipoVeiculo);
        VeiculoUtilDatabase.loadVeiculosFromFile(veiculoRepository);
        menuGeral.agir();
    }

    private static void inicializarGerenciadorTipoVeiculo(TipoVeiculoManager gerenciadorTipoVeiculo) {
        if (!gerenciadorTipoVeiculo.existeTipoVeiculo("Moto")) {
            gerenciadorTipoVeiculo.criarTipoVeiculo("Moto", BigDecimal.valueOf(100));
        }
        if (!gerenciadorTipoVeiculo.existeTipoVeiculo("Carro")) {
            gerenciadorTipoVeiculo.criarTipoVeiculo("Carro", BigDecimal.valueOf(150));
        }
        if (!gerenciadorTipoVeiculo.existeTipoVeiculo("Caminhão")) {
            gerenciadorTipoVeiculo.criarTipoVeiculo("Caminhão", BigDecimal.valueOf(200));
        }

    }


}