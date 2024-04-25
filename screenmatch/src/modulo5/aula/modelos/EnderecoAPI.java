package modulo5.aula.modelos;

public record EnderecoAPI(String cep,
                          String logradouro,
                          String complemento,
                          String localidade,
                          String bairro,
                          String uf) {
}
