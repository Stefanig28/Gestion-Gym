
# Aplicación de Gestión de Gimnasio

Desarollo del proyecto intregador dentro del BooCamp de Desarollo web BacKend en Betek





## 📌 Equipo de Trabajo

- luis
- stefani
- omar
  
 El repositorio corresponde al desarollo del proyecto intrgador dentro del bootcamp Betek, en el se desarolla la simulacion de una aplicacion de gestion de gimnasio utilizando Java, MySQL, SpringBoot, SpringData, swagger y railway.



# Introduccion! 👋
La Aplicación de Gestión de Gimnasio permite administrar entrenadores, aprendices y sus actividades de entrenamiento. Los aprendices pueden registrar y modificar su perfil, así como el tipo de entrenamiento y el tiempo dedicado. Simplifica la gestión y seguimiento en el gimnasio.


## 🛠 Skills
[![My Skills](https://skillicons.dev/icons?i=java,spring,gradle,idea,mongodb,mysql,postman)](https://skillicons.dev)

● Diagrama UML.
● Diagrama entidad relacion.
● Diagrama para representar las reglas de negocio.


API de Gestión de Gimnasio
Esta API permite la gestión de entrenadores y aprendices en un gimnasio. Proporciona endpoints para crear, actualizar, obtener y eliminar registros de entrenadores y aprendices, así como obtener reportes mensuales de actividades.

Modelos
Aprendiz
java
Copiar código
public Aprendiz(Long id, String nombreCompleto, String correoElectronico, String contrasenia, LocalDate fechaNacimiento, String genero, String objetivoEntrenamiento, String nivelCondicion, Entrenador entrenador) {
    this.id = id;
    this.nombreCompleto = nombreCompleto;
    this.correoElectronico = correoElectronico;
    this.contrasenia = contrasenia;
    this.fechaNacimiento = fechaNacimiento;
    this.genero = genero;
    this.objetivoEntrenamiento = objetivoEntrenamiento;
    this.nivelCondicion = nivelCondicion;
    this.entrenador = entrenador;
}
Entrenador
java
Copiar código
public Entrenador(Long id, String nombreCompleto, String contrasenia, String correoElectronico, String especialidad, String experiencia, Set<String> certificaciones, List<Aprendiz> aprendices) {
    this.id = id;
    this.nombreCompleto = nombreCompleto;
    this.contrasenia = contrasenia;
    this.correoElectronico = correoElectronico;
    this.especialidad = especialidad;
    this.experiencia = experiencia;
    this.certificaciones = certificaciones;
    this.aprendices = aprendices;
}
Servicios
EntrenadorServicio
Crear Entrenador
http
Copiar código
POST /api/entrenadores
Descripción: Crea un nuevo entrenador.
Cuerpo de la Solicitud:
json
Copiar código
{
    "nombreCompleto": "string",
    "correoElectronico": "string",
    "contrasenia": "string",
    "especialidad": "string",
    "experiencia": "string",
    "certificaciones": ["string"]
}
Actualizar Entrenador
http
Copiar código
PUT /api/entrenadores/{id}
Descripción: Actualiza la información de un entrenador existente.
Parámetros de Ruta: id - ID del entrenador a actualizar.
Cuerpo de la Solicitud:
json
Copiar código
{
    "nombreCompleto": "string",
    "correoElectronico": "string",
    "contrasenia": "string",
    "especialidad": "string",
    "experiencia": "string",
    "certificaciones": ["string"]
}
Obtener Entrenadores
http
Copiar código
GET /api/entrenadores
Descripción: Obtiene la lista de todos los entrenadores.
Obtener Entrenador por ID
http
Copiar código
GET /api/entrenadores/{id}
Descripción: Obtiene la información de un entrenador por su ID.
Parámetros de Ruta: id - ID del entrenador.
Eliminar Entrenador
http
Copiar código
DELETE /api/entrenadores/{id}
Descripción: Elimina un entrenador por su ID.
Parámetros de Ruta: id - ID del entrenador a eliminar.
AprendizServicio
Crear Aprendiz
http
Copiar código
POST /api/aprendices
Descripción: Crea un nuevo aprendiz.
Cuerpo de la Solicitud:
json
Copiar código
{
    "nombreCompleto": "string",
    "correoElectronico": "string",
    "contrasenia": "string",
    "fechaNacimiento": "YYYY-MM-DD",
    "genero": "string",
    "objetivoEntrenamiento": "string",
    "nivelCondicion": "string",
    "entrenadorId": "number"
}
Actualizar Aprendiz
http
Copiar código
PUT /api/aprendices/{id}
Descripción: Actualiza la información de un aprendiz existente.
Parámetros de Ruta: id - ID del aprendiz a actualizar.
Cuerpo de la Solicitud:
json
Copiar código
{
    "nombreCompleto": "string",
    "correoElectronico": "string",
    "contrasenia": "string",
    "genero": "string",
    "objetivoEntrenamiento": "string",
    "nivelCondicion": "string",
    "entrenadorId": "number"
}
Obtener Aprendices
http
Copiar código
GET /api/aprendices
Descripción: Obtiene la lista de todos los aprendices.
Obtener Aprendiz por ID
http
Copiar código
GET /api/aprendices/{id}
Descripción: Obtiene la información de un aprendiz por su ID.
Parámetros de Ruta: id - ID del aprendiz.
Eliminar Aprendiz
http
Copiar código
DELETE /api/aprendices/{id}
Descripción: Elimina un aprendiz por su ID.
Parámetros de Ruta: id - ID del aprendiz a eliminar.
ActividadesServicio
Obtener Reporte Mensual
http
Copiar código
GET /api/actividades/reporte
Descripción: Obtiene el reporte mensual de actividades para un aprendiz.
Parámetros de Consulta:
aprendizId: ID del aprendiz.
mes: Mes del reporte.
anio: Año del reporte.
Excepciones
EntrenadorExistenteExcepcion: Se lanza cuando se intenta crear un entrenador con un correo electrónico ya existente.
InformacionIncompletaExcepcion: Se lanza cuando se proporciona información incompleta para crear o actualizar un entrenador o aprendiz.
EntrenadorNoEncontradoExcepcion: Se lanza cuando no se encuentra un entrenador con el ID proporcionado.
AprendizExistenteExcepcion: Se lanza cuando se intenta crear un aprendiz con un correo electrónico ya existente.
AprendizNoEncontradoExcepcion: Se lanza cuando no se encuentra un aprendiz con el ID proporcionado.
AprendizNoExistenteExcepcion: Se lanza cuando no se encuentran aprendices en el repositorio.
Uso de la API
