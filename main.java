import java.time.LocalDate;

public class main {
  public static void main(String[] args) {
    agencia a = new agencia("carros","1234","12345","12345");
    contrato c = new contrato();
    veiculo v1 = new veiculo("Ferrari","Legal","preta","ASD-123",30.00,true);
    cliente cl = new cliente("Luiz","1234","1234","rua","teste@teste");
    c.setEmAberto(true);
    c.setCliente(cl);
    c.setAgenciaRetirada(a);
    c.setVeiculo(v1);
    c.setAgenciaDevolucao(a);
    c.setDataRetirada(LocalDate.now());
    c.setDataPrevista(LocalDate.now().plusDays(7));
    c.setDataFinal(LocalDate.now().plusDays(14));
    c.setCondutorCadastrado(cl);
    c.setValorPrevisto(1000.0);
    c.setValorFinal(1200.0);

    System.out.println("Contract is open: " + c.getEmAberto());
    System.out.println("Client Name: " + c.getCliente().getNome());
    System.out.println("Pickup Agency: " + c.getAgenciaRetirada().getNome());
    System.out.println("Vehicle: " + c.getVeiculo().getMarca());
    System.out.println("Return Agency: " + c.getAgenciaDevolucao().getNome());
    System.out.println("Pickup Date: " + c.getDataRetirada());
    System.out.println("Return Date: " + c.getDataPrevista());
    System.out.println("Final Date: " + c.getDataFinal());
    System.out.println("Authorized Driver: " + c.getCondutorCadastrado().getNome());
    System.out.println("Estimated Cost: $" + c.getValorPrevisto());
    System.out.println("Final Cost: $" + c.getValorFinal());
  }
}
