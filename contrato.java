import java.time.LocalDate;

public class contrato {
        private boolean emAberto;
        private cliente cliente;
        private agencia agenciaRetirada;
        private veiculo veiculo;
        private agencia agenciaDevolucao;
        private LocalDate dataRetirada;
        private LocalDate dataPrevista;
        private LocalDate dataFinal;
        private cliente condutorCadastrado;
        private double valorPrevisto;
        private double valorFinal;

    public contrato() {
    }

    public contrato(boolean emAberto, cliente cliente, agencia agenciaRetirada, veiculo veiculo, agencia agenciaDevolucao, LocalDate dataRetirada, LocalDate dataPrevista, LocalDate dataFinal, cliente condutorCadastrado, double valorPrevisto, double valorFinal) {
        this.emAberto = emAberto;
        this.cliente = cliente;
        this.agenciaRetirada = agenciaRetirada;
        this.veiculo = veiculo;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataRetirada = dataRetirada;
        this.dataPrevista = dataPrevista;
        this.dataFinal = dataFinal;
        this.condutorCadastrado = condutorCadastrado;
        this.valorPrevisto = valorPrevisto;
        this.valorFinal = valorFinal;
    }

    // Getters and setters for all fields
        public boolean getEmAberto() {
            return emAberto;
        }
        public void setEmAberto(boolean emAberto) {
            this.emAberto = emAberto;
        }
        public cliente getCliente() {
            return cliente;
        }
        public void setCliente(cliente cliente) {
            this.cliente = cliente;
        }
        public agencia getAgenciaRetirada() {
            return agenciaRetirada;
        }
        public void setAgenciaRetirada(agencia agenciaRetirada) {
            this.agenciaRetirada = agenciaRetirada;
        }
        public veiculo getVeiculo() {
            return veiculo;
        }
        public void setVeiculo(veiculo veiculo) {
            this.veiculo = veiculo;
        }
        public agencia getAgenciaDevolucao() {
            return agenciaDevolucao;
        }
        public void setAgenciaDevolucao(agencia agenciaDevolucao) {
            this.agenciaDevolucao = agenciaDevolucao;
        }
        public LocalDate getDataRetirada() {
            return dataRetirada;
        }
        public void setDataRetirada(LocalDate dataRetirada) {
            this.dataRetirada = dataRetirada;
        }
        public LocalDate getDataPrevista() {
            return dataPrevista;
        }
        public void setDataPrevista(LocalDate dataPrevista) {
            this.dataPrevista = dataPrevista;
        }
        public LocalDate getDataFinal() {
            return dataFinal;
        }
        public void setDataFinal(LocalDate dataFinal) {
            this.dataFinal = dataFinal;
        }
        public cliente getCondutorCadastrado() {
            return condutorCadastrado;
        }
        public void setCondutorCadastrado(cliente condutorCadastrado) {
            this.condutorCadastrado = condutorCadastrado;
        }
        public double getValorPrevisto() {
            return valorPrevisto;
        }
        public void setValorPrevisto(Double valorPrevisto){
            this.valorPrevisto = valorPrevisto;
        }
        public Double getValorFinal(){
            return valorFinal;
        }
        public void setValorFinal(Double valorFinal){
            this.valorFinal = valorFinal;
        }
}
