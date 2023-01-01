# Anonymizer

Anonymization service will take a text as an input and will replace all occurrences of URLs, IDs and emails with fake
data.

- URL - domain name from any valid URL
- E-mail - any valid email address
- ID - any character sequence of number longer than 3 digits
- Name - predefined list of names (people first names, last names, company names)

## Getting Started

To build the project:

```shell
./gradlew build
```

Run Tests:

```shell
./gradlew test
```

## Usage

Request:

```shell
curl -v -X POST http://localhost:8080/anonymize \
  -H 'Content-Type: application/json' \
  -d '{"input": "Hello, my name is Andrei Pandeko.\nI am working in iTechArt.\nE: pandzeka.andrei@gmail.com.\nID: 12345678.\nhttps://google.com/help"}'
```

Response:

```http
HTTP/1.1 200 
Content-Type: application/json

{"output": "Hello, my name is Palmira Berge.\nI am working in Keebler and Sons.\nE: felicitas.feil@example.com.\nID: 35229149.\nhttps://kerluke.com/help"}
```

## Neuron implementation

For firstnames, lastnames, and companies by default we're using dictionary recognition.
To change implementation to neuron you can edit qualifier of NameRecognizer from `dictionaryNameRecognizer`
to `neuronNameRecognizer` in [BeanConfig](src/main/java/com/example/anonymizer/config/BeanConfig.java)

## Environment

- [dictionary](src/main/resources/application.properties) - contains recognizable first names, last names and company
  names
