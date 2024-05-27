package Aux_arq;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUsuario {
    Scanner leitura = new Scanner(System.in);
    List<String> historicoConversoes = new ArrayList<>();

    public void menu() throws IOException, InterruptedException {
        boolean menu = true;
        while (menu) {
            System.out.println("""
                    
                    1 - BRL | ARS
                    2 - BRL | BOB
                    3 - BRL | CLP
                    4 - BRL | COP
                    5 - BRL | USD
                    6 - BRL | EUR
                    7 - BRL | CHF
                    8 - BRL | GBP
                    9 - BRL | MAD
                    0 - SAIR
                    
                    Escolha uma opção para converter:
                    """);
            String opcaoMenu = leitura.next();
            switch (opcaoMenu) {
                case "1":
                    this.converterMoeda("BRL", "ARS");
                    break;

                case "2":
                    this.converterMoeda("BRL", "BOB");
                    break;

                case "3":
                    this.converterMoeda("BRL", "CLP");
                    break;

                case "4":
                    this.converterMoeda("BRL", "COP");
                    break;

                case "5":
                    this.converterMoeda("BRL", "USD");
                    break;

                case "6":
                    this.converterMoeda("BRL", "EUR");
                    break;

                case "7":
                    this.converterMoeda("BRL", "CHF");
                    break;

                case "8":
                    this.converterMoeda("BRL", "GBP");
                    break;

                case "9":
                    this.converterMoeda("BRL", "MAD");
                    break;

                default:
                    if (opcaoMenu.equals("0")) {
                        System.out.println("Saindo... Até a próxima!\n");
                        mostrarHistorico();
                        menu = false;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
            }
        }
    }

    public void converterMoeda(String base_code, String target_code) throws IOException, InterruptedException {
        System.out.println("Digite o valor para ser convertido:");
        double valorInserido = this.leitura.nextDouble();
        ConversorMoedas conversor = new ConversorMoedas(base_code, target_code, valorInserido);
        RequisicaoAPI requisicaoApi = new RequisicaoAPI(conversor);
        String resultado = requisicaoApi.requisicaoApi();
        System.out.println(resultado);

        // Adiciona a conversão ao histórico com timestamp
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String conversao = String.format("[%s] Convertido %.2f %s para %s: %s", formattedTimestamp, valorInserido, base_code, target_code, resultado);
        historicoConversoes.add(conversao);
    }

    public void mostrarHistorico() {
        System.out.println("Histórico de Conversões:");
        if (historicoConversoes.isEmpty()) {
            System.out.println("Nenhuma conversão realizada.");
        } else {
            for (String conversao : historicoConversoes) {
                System.out.println(conversao);
            }
        }
    }
}
