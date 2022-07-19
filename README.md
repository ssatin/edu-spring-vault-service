# edu-spring-vault-service

Данное приложение содержит пример, который показывает:

1) как соединить spring-boot приложение с сервером конфигураций Vault
2) собрать и запустить приложение в docker, используя maven

## Подключение к Vault

Документацию о Vault можно почитать здесь: https://www.vaultproject.io/
Документацию по docker-image здесь: https://hub.docker.com/_/vault

### Локальный запуск Vault в docker

1) запускаем команду docker run --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e '
   VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:1234' -p 8200:8200 -p 1234:1234 vault
2) в конце установки в консоли увидим запись вида: Root Token: qwerty - это root token, его необходимо скопировать
3) Открываем http://localhost:8200. В method выбираем Token, в token вставляем Root token
4) Создадим простраство kv (слева сверху +, выбрать kv, вводим имя: edu)
5) Создадим конфиг - application

```json
{
  "application": {
    "concat": {
      "prefix": "root-preffix",
      "suffix": "root-suffix"
    }
  }
}
```
6) дописываем в bootstrap.yml
```yaml
spring:
  cloud:
    vault:
      kv:
        backend: edu
      uri: http://localhost:8200
      token: token
```
7) Запускаем приложение и делаем get: http://localhost:8080/concat?first=my-first&second=my-second
В данном случае prefix и suffix получим из Vault - application
   
8) Создадим конфиг - edu-spring-vault-service

```json
{
  "application": {
    "concat": {
      "prefix": "application-kv-preffix",
    }
  }
}

9) Запускаем приложение и делаем get: http://localhost:8080/concat?first=my-first&second=my-second
В данном случае prefix получим из Vault - edu - edu-spring-vault-service, 
а suffix получим из Vault - edu - application



