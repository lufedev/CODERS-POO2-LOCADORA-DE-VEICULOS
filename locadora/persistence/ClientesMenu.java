//package br.com.ada.grupo3.locadora.persistence;
//import br.com.ada.grupo3.locadora.domain.ClienteManager;
//import br.com.ada.grupo3.locadora.view.Mensagens;
//
//public class ClientesMenu {
//    Mensagens mensagens = new Mensagens();
//    public void menuClientes() {
//        boolean flag = false;
//        do {
//            boolean continuar;
////            mensagens.headerMenuClientes();
//            ClienteManager.listarClientes();
//            switch (Integer.toString(mensagens.menuClientes())) {
//
//                case "1":
//                    do {
//                        continuar = ClienteManager.menuClienteCadastrar();
//                    }while (continuar);break;
//
//                case "2":
//                    do{
//                    continuar = ClienteManager.menuClienteBusarId();
//            }while (continuar);break;
//
//                case "3":
//                    do{
//                    continuar = ClienteManager.menuClienteBuscarNome();
//                    }while (continuar);break;
//
//                case "4":
//                    do{
//                    continuar = ClienteManager.menuClienteAlterar();
//                    }while (continuar);break;
//
//                case "5":
//                    do {
//                    continuar = ClienteManager.menuClienteRemover();
//                    }while (continuar);break;
//
//                case "6":
//                    flag = mensagens.desejaSair();break;
//
//                default:
//                    System.out.println(mensagens.valorInvalido());break;
//
//            }
//        } while (!flag);
//    }
//}
