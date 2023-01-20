package br.com.ada.grupo3.locadora.view;

import java.util.List;

public class PaginacaoListas {

    public static <T> void listarEmPaginas(List<T> itens, String cabecalho) {

        if (itens.isEmpty()) {
            System.out.println("\nNão há itens\n");
            return;
        }

        final int pageSize = 3;
        final var numberOfPages = (int) (Math.ceil(itens.size() / (float) pageSize));
        var pageNumber = 1;
        var loopPagination = true;

        do {
            System.out.printf("Página %d de %d %n", pageNumber, numberOfPages);
            System.out.println(cabecalho);
            itens.stream()
                    .skip((long) (pageNumber - 1) * pageSize)
                    .limit(pageSize)
                    .forEach(item ->
                            System.out.printf("""
                                            (%s)
                                                %s%n""",
                                    itens.indexOf(item) + 1,
                                    item.toString())
                    );
            if (numberOfPages == 1) {
                loopPagination = false;
            } else {
                final var selection = CapturadorDeEntrada.askSimpleInput("""
                                                    
                        Entre:
                                <a> para página anterior
                                <d> para próxima página
                                <x> para finalizar paginação
                        """).toLowerCase();
                switch (selection) {
                    case "a" -> pageNumber = pageNumber == 1 ? pageNumber : pageNumber - 1;
                    case "d" -> pageNumber = pageNumber == numberOfPages ? pageNumber : pageNumber + 1;
                    case "x" -> loopPagination = false;
                    default -> System.out.println("Seleção inválida, tente novamente");
                }
            }
        }
        while (loopPagination);
    }
}
