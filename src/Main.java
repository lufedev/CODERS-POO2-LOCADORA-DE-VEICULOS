import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.persistence.*;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuGeralFactory;
import br.com.ada.grupo3.locadora.view.agencia.MenuAgenciasFactory;

public class Main {
    public static void main(String[] args) {

        AgenciaRepository agenciaRepository = new AgenciaRepositoryInMemory();

        AgenciaManager gerenciadorDeAgencia = new AgenciaManager(agenciaRepository);
        Agencia agencia = gerenciadorDeAgencia.criarAgencia("AG1", new Endereco("Av Central", 200, "Maringá", "PR"));
//        System.out.println("Nova agência criada");
//        System.out.println(agencia);

        MenuAgenciasFactory menuAgenciasFactory = new MenuAgenciasFactory(gerenciadorDeAgencia);
        Menu menuGeral = new MenuGeralFactory(menuAgenciasFactory).create();
        menuGeral.agir();
    }
}