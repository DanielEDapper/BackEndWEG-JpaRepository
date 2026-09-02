# API REST — COVID-19 Data Service (Spring Data JPA/Hibernate)

Camada de backend Java responsável por mapear via **ORM (Spring Data JPA/Hibernate)** o
schema relacional `covid` (PostgreSQL, já normalizado e carregado a partir do dataset
público *Our World in Data*) e expor uma **API REST** para consultas epidemiológicas,
demográficas e vacinais.

Este projeto consome o banco já estruturado — não recria schema, staging ou ETL.
Essas etapas ficam no repositório de dados (`sql/01_schema.sql` a `06_example_queries.sql`).

## Contexto

A OMS precisa expor os dados consolidados da pandemia de COVID-19 para integrar
dashboards globais. A equipe de Engenharia de Dados já processou a base pública OWID e
disponibilizou um banco PostgreSQL estruturado com o schema `covid`. Este serviço é a
camada backend Java que dá acesso a esses dados via API.

## Análise do schema relacional (`covid`)

| Tabela | Papel no modelo | Chave primária |
|---|---|---|
| `location_type` | Domínio/referência — tipos de localidade | `location_type_code` (texto) |
| `continent` | Domínio/referência — continentes | `continent_id` (numérico, identity) |
| `location` | Tabela principal de localidades/países. FK para `continent` e `location_type` | `location_id` (numérico, identity) |
| `location_profile` | Relacionamento **1:1** com `location`, compartilhando a mesma PK. Atributos estáveis (demografia, economia) | `location_id` (= PK de `location`) |
| `observation_day` | Grão canônico da série temporal | **Composta**: `location_id` + `observation_date` |
| `epidemiology_observation` | Série temporal — casos e óbitos. FK composta para `observation_day` | Composta: `location_id` + `observation_date` |
| `hospitalization_observation` | Série temporal — UTI e hospitalização | Composta: `location_id` + `observation_date` |
| `testing_observation` | Série temporal — testagem. FK adicional para `test_unit` | Composta: `location_id` + `observation_date` |
| `vaccination_observation` | Série temporal — vacinação | Composta: `location_id` + `observation_date` |
| `policy_observation` | Série temporal — índice de rigor das políticas | Composta: `location_id` + `observation_date` |
| `excess_mortality_observation` | Série temporal — mortalidade em excesso | Composta: `location_id` + `observation_date` |
| `test_unit` | Domínio/referência — unidade de medida dos testes | `test_unit_code` (texto) |
| `vw_latest_country_summary` | **View** — último registro epidemiológico por país | *(sem PK própria; mapeada como entidade somente leitura)* |

## Requisitos técnicos obrigatórios

- Mapear explicitamente o schema em todas as entidades: `@Table(schema = "covid", name = "...")`.
- Usar `@Embeddable` + `@EmbeddedId` para as tabelas de série temporal com chave composta
  (`location_id` + `observation_date`).
- Mapear o relacionamento 1:1 de `LocationProfile` com `@OneToOne` + `@MapsId`.
- Mapear a view `vw_latest_country_summary` como entidade somente leitura (`@Immutable`
  do Hibernate, ou `@Subselect`), já que não há PK física na view.
- Expor a API REST com uma classe `@RestController`, seguindo boas práticas RESTful
  (paginação, filtros por query param, DTOs de resposta separados das entidades).

## Estrutura de pacotes proposta

```
src/main/java/com/example/coviddata
├── entity
│   ├── LocationType.java
│   ├── Continent.java
│   ├── Location.java
│   ├── LocationProfile.java
│   ├── ObservationDay.java
│   ├── ObservationDayId.java          (chave composta @Embeddable)
│   ├── EpidemiologyObservation.java
│   ├── HospitalizationObservation.java
│   ├── TestUnit.java
│   ├── TestingObservation.java
│   ├── VaccinationObservation.java
│   ├── PolicyObservation.java
│   ├── ExcessMortalityObservation.java
│   └── LatestCountrySummary.java      (mapeada sobre a view, somente leitura)
├── repository
│   └── ... (interfaces Spring Data JPA, uma por entidade)
├── dto
│   └── ... (records de resposta da API)
├── service
│   └── ... (regras de agregação e filtros)
└── controller
    └── LocationController.java
    └── DashboardController.java
```

## Mapeamento de entidades — tipos PostgreSQL x Java

| Coluna típica | Tipo PostgreSQL | Tipo Java |
|---|---|---|
| `*_id` (PK numérica) | `bigint` / `smallint` | `Long` / `Short` |
| `*_code` (PK textual) | `varchar` | `String` |
| `iso_code`, `name` | `varchar` | `String` |
| `observation_date` | `date` | `LocalDate` |
| `loaded_at` | `timestamptz` | `OffsetDateTime` |
| `population` | `bigint` | `Long` |
| Métricas (`total_cases`, `stringency_index`, `human_development_index`, etc.) | `numeric` | `BigDecimal` |

> Todas as métricas em `numeric` viram `BigDecimal` no Java — nunca `double`/`float`,
> para não perder precisão em cálculos e comparações.

## Especificação dos endpoints REST

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/api/v1/locations` | Lista todas as localidades com paginação (`?page=0&size=20`) |
| `GET` | `/api/v1/locations/{isoCode}` | Retorna dados detalhados da localidade pelo código ISO (ex: `BRA`) |
| `GET` | `/api/v1/locations/{isoCode}/profile` | Retorna o perfil demográfico (`LocationProfile`) da localidade |
| `GET` | `/api/v1/locations/{isoCode}/epidemiology` | Retorna o histórico de casos e mortes filtrado por intervalo de datas (`?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD`) |
| `GET` | `/api/v1/dashboards/latest-summary` | Retorna a visão resumida de todos os países mapeada da view `vw_latest_country_summary` |

## Configuração e execução

Pré-requisitos: banco `covid_db` já em execução (ver `compose.yaml` do repositório de
dados) e carregado via `load.sh`.

`src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5431/covid_db
spring.datasource.username=postgres
spring.datasource.password=123@Mudar
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.default_schema=covid
spring.jpa.show-sql=false
```

- `ddl-auto=validate`: o schema já existe e é gerenciado pelos scripts SQL; a aplicação
  Java só valida se as entidades batem com as tabelas, nunca cria/altera estrutura.
- Ajuste usuário/senha conforme o ambiente (não versionar credenciais reais).

Para subir a aplicação:

```bash
./mvnw spring-boot:run
```

## Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA / Hibernate 6
- PostgreSQL 16
- Maven

## Checklist de implementação

- [ ] Entidades de domínio (`LocationType`, `Continent`, `TestUnit`)
- [ ] `Location` com relacionamentos `@ManyToOne` para `Continent` e `LocationType`
- [ ] `LocationProfile` com `@OneToOne` + `@MapsId`
- [ ] `ObservationDayId` (`@Embeddable`) e `ObservationDay`
- [ ] Entidades de série temporal com `@EmbeddedId`
- [ ] Entidade somente leitura para `vw_latest_country_summary`
- [ ] Repositories Spring Data JPA
- [ ] DTOs de resposta (não expor entidades diretamente na API)
- [ ] Controllers com os 5 endpoints especificados
- [ ] Paginação em `/api/v1/locations`
- [ ] Filtro por intervalo de datas em `/api/v1/locations/{isoCode}/epidemiology`
- [ ] Tratamento de erros (404 para ISO code inexistente, 400 para datas inválidas)
