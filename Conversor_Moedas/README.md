# Desafio de Conversor de Moedas

## Descrição do Desafio

O objetivo deste desafio é criar um programa em Java que permita a conversão de valores entre diferentes moedas 
utilizando uma API de taxa de câmbio. O programa deve solicitar que o usuário selecione uma opção dentre algumas opções
no menu para fazer a conversão, e então exibir o resultado da conversão. Quando o usuário escolher a opção "Sair" será
mostrado na tela o histórico de conversões que ele solicitou.

### Requisitos

1. **Entrada do Usuário**:
    - Seleção da opção de conversão no menu apresentado.
    - Quantia a ser convertida.

2. **Processamento**:
    - Utilizar uma API para obter a taxa de conversão entre as duas moedas.
    - Calcular o valor convertido com base na taxa de conversão obtida.

3. **Saída**:
    - Exibir a moeda de origem, a moeda de destino, a taxa de conversão utilizada e a quantia convertida.

### API Utilizada

Para realizar as conversões de moeda, foi utilizada a API da ExchangeRate-API (https://www.exchangerate-api.com/), que 
fornece taxas de câmbio atualizadas.

## Solução

A solução foi implementada em Java e consiste em quatro classes principais: `ConversorMoedas`, `RequisicaoAPI`, 
`MenuUsuario`, `Aplicativo`.

### Classe `ConversorMoedas`

Esta classe representa uma conversão de moeda. Ela armazena a moeda de origem, a moeda de destino, o valor a ser 
convertido, a taxa de conversão e o resultado da conversão.

### Classe `ApiConverter`
Esta classe é responsável por interagir com a API de conversão de moeda. Ela monta a URL da API, envia a requisição e 
processa a resposta para obter a taxa de conversão e o resultado da conversão.

### Classe `MenuUsuario`
Esta é classe onde foi criado todo o mundo para interação com o usuário. Ela deve solicitar a opção de conversão que o 
usuário deseja fazer, e a quantia que deseja converter. E por último mostrará na tela o histórico dos pedidos de 
conversão do usuário.

### Classe `Aplicativo`
Esta é a classe que fará rodar o programa.

### Como Executar
1. Certifique-se de ter o JDK instalado em sua máquina.
2. Compile as classes Java
3. Execute o programa
4. Siga as instruções exibidas no console para realizar conversões de moeda.


