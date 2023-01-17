import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
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

        VeiculoManager gerenciadorDeVeiculo = new VeiculoManager(veiculoRepository);
        AgenciaManager gerenciadorDeAgencia = new AgenciaManager(agenciaRepository);
        ClienteManager gerenciadorDeCliente = new ClienteManager(clienteRepository);
        AluguelManager gerenciadorDeAluguel = new AluguelManager(aluguelRepository);

        List<TipoVeiculo> tiposDeVeiculos = new ArrayList<>();
        tiposDeVeiculos.add(new TipoVeiculo("Moto", new BigDecimal("100.00")));
        tiposDeVeiculos.add(new TipoVeiculo("Carro", new BigDecimal("150.00")));
        tiposDeVeiculos.add(new TipoVeiculo("Caminhão", new BigDecimal("200.00")));

        MenuVeiculoFactory menuVeiculoFactory = new MenuVeiculoFactory(gerenciadorDeVeiculo, tiposDeVeiculos);
        MenuAgenciaFactory menuAgenciaFactory = new MenuAgenciaFactory(gerenciadorDeAgencia);
        MenuClienteFactory menuClienteFactory = new MenuClienteFactory(gerenciadorDeCliente);
        MenuAluguelFactory menuAluguelFactory = new MenuAluguelFactory(gerenciadorDeAluguel);

        Menu menuGeral = new MenuGeralFactory(menuVeiculoFactory, menuAgenciaFactory, menuClienteFactory, menuAluguelFactory).create();
        menuGeral.agir();
    }
}