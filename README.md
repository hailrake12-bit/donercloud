# DonerCloud

Веб-приложение на Spring Boot для конструирования и заказа донеров.

Пользователь может выбрать ингредиенты, сформировать собственный донер и оформить заказ. Приложение содержит регистрацию пользователей, аутентификацию, серверный рендеринг HTML-страниц и слой работы с данными через Spring Data JPA.

## Возможности

- регистрация пользователей;
- аутентификация и авторизация;
- создание собственного донера из ингредиентов;
- выбор ингредиентов;
- оформление заказов;
- хранение пользователей, донеров, ингредиентов и заказов;
- валидация данных;
- серверный рендеринг страниц через Thymeleaf;
- REST-интерфейс на базе Spring Data REST.

## Архитектура

Проект построен вокруг стандартной архитектуры Spring Boot:

```text
Browser
   │
   ▼
Spring MVC Controllers
   │
   ├── DesignDonerController
   ├── OrderController
   └── RegistrationController
   │
   ▼
Spring Data Repositories
   │
   ├── DonerRepository
   ├── IngredientRepository
   ├── OrderRepository
   └── UserRepository
   │
   ▼
H2 Database
```

### Web layer

Контроллеры находятся в пакете `doner.web` и отвечают за пользовательские сценарии.

`DesignDonerController` обрабатывает конструирование донера и выбор ингредиентов.

`OrderController` отвечает за оформление заказов.

`RegistrationController` реализует регистрацию новых пользователей.

### Data layer

Для доступа к данным используются Spring Data JPA repositories:

- `DonerRepository`
- `IngredientRepository`
- `OrderRepository`
- `UserRepository`

Предметная модель включает:

- `User`
- `Doner`
- `Ingredient`
- `DonerOrder`

### Security

Безопасность приложения реализована с использованием Spring Security.

В пакете `doner.security` находятся:

- `SecurityConfig`;
- `RegistrationController`;
- `RegistrationForm`.

Security-конфигурация отвечает за правила доступа и механизм аутентификации пользователей.

## Предметная модель

Основные сущности приложения:

```text
User
 │
 └── Orders
       │
       └── Doner
             │
             └── Ingredients
```

Пользователь может создавать заказы, а заказ содержит сформированный донер с выбранными ингредиентами.

## REST

Проект содержит `spring-boot-starter-data-rest`, поэтому репозитории Spring Data могут предоставлять REST-доступ к данным через Spring Data REST.

Это позволяет использовать стандартный REST-механизм Spring поверх существующего repository layer.

## Технологии

- Java 17
- Spring Boot 3.4.1
- Spring MVC
- Spring Data JPA
- Spring Data REST
- Spring Security
- Thymeleaf
- Thymeleaf Extras Spring Security 6
- Bean Validation
- H2
- Maven
- Lombok

## Структура проекта

```text
src/main/java/doner/
├── data/
│   ├── DonerRepository.java
│   ├── IngredientRepository.java
│   ├── OrderRepository.java
│   └── UserRepository.java
│
├── security/
│   ├── RegistrationController.java
│   ├── RegistrationForm.java
│   └── SecurityConfig.java
│
├── web/
│   ├── api/
│   ├── DesignDonerController.java
│   ├── IngredientByIdConverter.java
│   └── OrderController.java
│
├── Doner.java
├── DonerOrder.java
├── Ingredient.java
├── OrderProperties.java
├── User.java
├── WebConfig.java
└── DonerСloudApplication.java
```

## Запуск

### Требования

- Java 17+
- Maven 3.8+

### Запуск через Maven Wrapper

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bat
mvnw.cmd spring-boot:run
```

### Сборка

```bash
./mvnw clean package
```

После сборки приложение можно запустить:

```bash
java -jar target/donercloud-0.0.1-SNAPSHOT.jar
```

## Конфигурация

Приложение использует H2 в качестве runtime-базы данных. Параметры подключения и другие настройки Spring Boot задаются через стандартные configuration properties.

## Что демонстрирует проект

- разработку веб-приложения на Spring Boot;
- построение MVC-приложения;
- работу с JPA и Spring Data repositories;
- реализацию регистрации и аутентификации через Spring Security;
- серверный рендеринг Thymeleaf;
- валидацию пользовательских данных;
- построение предметной модели и связей между сущностями;
- предоставление REST-интерфейса через Spring Data REST;
- использование dependency injection и конфигурации Spring.

## Репозиторий

https://github.com/hailrake12-bit/donercloud
