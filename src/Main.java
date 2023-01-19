import br.com.ada.grupo3.locadora.domain.*;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.persistence.*;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuGeralFactory;
import br.com.ada.grupo3.locadora.view.agencia.MenuAgenciaFactory;
import br.com.ada.grupo3.locadora.view.aluguel.MenuAluguelFactory;
import br.com.ada.grupo3.locadora.view.cliente.MenuClienteFactory;
import br.com.ada.grupo3.locadora.view.veiculo.MenuVeiculoFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {


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

        MenuVeiculoFactory menuVeiculoFactory = new MenuVeiculoFactory(gerenciadorDeVeiculo, tipoVeiculoRepository);
        MenuAgenciaFactory menuAgenciaFactory = new MenuAgenciaFactory(gerenciadorDeAgencia);
        MenuClienteFactory menuClienteFactory = new MenuClienteFactory(gerenciadorDeCliente);
        MenuAluguelFactory menuAluguelFactory = new MenuAluguelFactory(gerenciadorDeAluguel);

        Menu menuGeral = new MenuGeralFactory(menuVeiculoFactory, menuAgenciaFactory, menuClienteFactory,
                menuAluguelFactory).create();
        menuGeral.agir();
    }
}