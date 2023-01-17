package br.com.ada.grupo3.locadora.view;

// Menu Geral
// LocateCar --
// 0. Menu Veiculos
// 1. Menu Agencias
// 2. Menu Clientes
// 3. Menu Alugueis
// 4. Menu Comprovantes

// Menu Veiculos
// 0. Cadastrar Veiculo
// 1. Alterar veiculo
// 2. Buscar veiculo por parte do nome (modelo)

// Menu Agencias
// 0. Cadastrar agencia
// 1. Alterar agencia
// 2. Buscar por parte do nome
// 3. Buscar por parte do logradouro

// Menu Clientes
// 0. Cadastrar cliente
// 1. Alterar cliente

// Menu Alugueis
// 0. Alugar veiculo
// 1. Devolver veiculo

// Menu Comprovantes
// 0. Comprovante de Aluguel
// 1. Comprovante de devolucao


public interface Menu {

    void exibir();

    void agir();

}
