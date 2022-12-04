## Estrutura do Projeto
Codigo referente a exportacao de uma lista de objeto para CSV utilizando a OpenCSV no Java.

O OpenCSV utiliza de uma classe Bean para poder converter o objeto(entidade) para a linha do CSV.

No exemplo nos pegamos uma entidade Pessoa e convertemos para PessoaBean e utilizamos as anotações do OpenCSV em cara declaracão de parametro para que ele possa entender quais sao os parametros referente a qual coluna da tabela.

> Podemos realizar os mapeamentos entre cabeçalhos de coluna .csv usando as anotações @CsvBindByPosition ou @CsvBindByName, que especificam um mapeamento por posição ou correspondência da string do cabeçalho, respectivamente.

> Obs.: Por Padrao só pode ser utilizada uma unica anotação,  @CsvBindByPosition ou @CsvBindByName, mas na classe *CSVUtils* foi criado uma função que possiblita a utilizacao de ambas as anotações.

Dependencia Maven

```
    <dependency>
        <groupId>com.opencsv</groupId>
        <artifactId>opencsv</artifactId>
        <version>5.7.1</version>
    </dependency>
```
Seguindo os seguintes links:
- https://www.baeldung.com/opencsv
- https://zetcode.com/java/opencsv/
