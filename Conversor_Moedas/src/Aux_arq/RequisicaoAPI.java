package Aux_arq;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoAPI {

    private String cod_de;
    private String cod_para;
    private Double valor;

    List<ConversorMoedas> listaConversor = new ArrayList<>();

    public RequisicaoAPI(ConversorMoedas conversor){
        this.cod_de = conversor.getBase_code();
        this.cod_para = conversor.getTarget_code();
        this.valor = conversor.getValor();

    };

    public List<ConversorMoedas> getListaConversor() {
        return listaConversor;
    }

    public String requisicaoApi( )  throws IOException, InterruptedException {

        String chaveApi = "362d8f2a182479f2f397c9c3";
        String linkConexao = "https://v6.exchangerate-api.com/v6/"
                + chaveApi + "/pair/" + this.cod_de +  "/" + this.cod_para + "/" + this.valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkConexao))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        ConversorMoedas conversor = gson.fromJson(json, ConversorMoedas.class);
        listaConversor.add(conversor);
        return conversor.toString();
    }

}
