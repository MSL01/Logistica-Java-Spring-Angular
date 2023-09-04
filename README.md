# Logistica-Java-Spring-Angular
# Logística Express API

![Captura](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/a5409469-2a0b-4b9f-90d7-64431e38dd48)


Este repositorio contiene el código fuente de la API web para Logística, que ofrece servicios de entregas terrestres y marítimas. La API está desarrollada en Java con el framework Spring, mientras que el frontend se ha construido con Angular. La base de datos utilizada es MongoDB.

## Características

- API RESTful Operaciones CRUD.
- Generación aleatoria de número de guía.
- Almacenamiento de datos para envíos terrestres y marítimos.
- Base de datos NoSql.
- Gestión de envíos terrestres y marítimos.
- Calcular tarifas de envío.
- Información detallada de envíos.
- Busqueda por Número de Guía.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Angular
- MongoDB

## Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/MSL01/Logistica-Java-Spring-Angular/
cd Logistica-Java-Spring-Angular
```
2. Configura la conexión a la base de datos MongoDB en target/classes/application.properties:
```bash
spring:
    data:
        mongodb:
            host:localhost
            port:27017
            database:logistica
```
3. Ejecuta la aplicación backend, compila o ejecuta "LogisticaAplicaciono.java"
4. Navega hasta el directorio del frontend y ejecuta la aplicación Angular:
```bash
  cd logistica-front
  ng serve -o
```
5. Abre un navegador y accede a http://localhost:4200/home para utilizar la interfaz de usuario.


## Previews del entorno
1. Lista de envíos terrestres.
```bash
  http://localhost:4200/terrestre
```
![t1](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/f6110d3e-d183-4562-8200-db0ce9c98d5f)
3. Lista de enviós maritimos.
```bash
  http://localhost:4200/maritimo
```
![m1](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/0a9d205a-205b-4560-8fb6-ac30adbee9bb)
4. Método view por medio de número de guía.
```bash
  Ejemplo: http://localhost:4200/detailM/FYW17319ZP
```
![a2](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/efcd6ed0-4ea7-42df-8462-daa2080f09af)
5. Método crear (Se requiere llenar los campos para crear nuevo formato).
```bash
Ejemplo: http://localhost:4200/createM
```
![d1](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/4fcd9dba-ab29-4606-8085-c727b60e81c2)
![d2](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/3f75fc1f-4b66-48f2-bc89-629498ab4be4)
6. Método editar.
```bash
Ejemplo: http://localhost:4200/updateT/MT367273MX
```
![asddsa](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/7392ec4f-dae6-4f9e-8968-aa7f9ba1980f)

8. Método eliminar.
![e1](https://github.com/MSL01/Logistica-Java-Spring-Angular/assets/100708772/fcff637b-4a6d-42c1-a3cd-85bb8c8f9286)

