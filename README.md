
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


# API de Gestión de Gimnasio

Esta API permite la gestión de entrenadores y aprendices en un gimnasio. Proporciona endpoints para crear, actualizar, obtener y eliminar registros de entrenadores y aprendices, así como obtener reportes mensuales de actividades.

## Endpoints de Entrenadores

### Crear un Entrenador

**POST /api/entrenador**

**Este endpoint permite crear un nuevo entrenador. Se debe proporcionar toda la información necesaria del entrenador, como nombre completo, correo electrónico, contraseña, especialidad, experiencia y certificaciones. Si el entrenador ya existe o la información está incompleta, se devolverá un error adecuado.**

**Ejemplo de Cuerpo de Solicitud**:
```json
{
  "nombreCompleto": "Juan Pérez",
  "correoElectronico": "juan.perez@example.com",
  "contrasenia": "password123",
  "especialidad": "Fuerza",
  "experiencia": "5 años",
  "certificaciones": ["Certificación A", "Certificación B"]
}
```
### Actualizar un Entrenador

**PUT /api/entrenador/actualizar/{id}**

**Este endpoint permite actualizar la información de un entrenador existente. Se debe proporcionar el ID del entrenador en la URL y la nueva información en el cuerpo de la solicitud. Si el entrenador no es encontrado, se devolverá un error.**

**Ejemplo de Cuerpo de Solicitud**:
```json
{
  "nombreCompleto": "Luis García",
  "correoElectronico": "luis.garcia@example.com",
  "contrasenia": "newpassword123",
  "especialidad": "Cardio",
  "experiencia": "3 años",
  "certificaciones": ["Certificación C"]
}
```
### Obtener la Lista de Entrenadores

**GET /api/entrenador**

**Este endpoint permite obtener la lista de todos los entrenadores registrados en la base de datos. Devuelve una lista con la información de cada entrenador.**

**Ejemplo de Uso**:

```
http://localhost:8080/api/entrenador
```

### Obtener un Entrenador por ID

**GET /api/entrenador/{id}**

**Este endpoint permite obtener la información de un entrenador específico usando su ID. Si el entrenador no es encontrado, se devolverá un error.**

**Ejemplo de Uso**:

```
http://localhost:8080/api/entrenador/1
```

### Eliminar un Entrenador

**DELETE /api/entrenador/eliminar/{id}**

**Este endpoint permite eliminar un entrenador específico usando su ID. Si el entrenador no es encontrado, se devolverá un error.**

**Ejemplo de Uso**:

```
http://localhost:8080/api/entrenador/eliminar/1
```

### Excepciones
> [!WARNING]
> **EntrenadorExistenteExcepcion**: Se lanza cuando se intenta crear un entrenador con un correo electrónico ya existente.
> [!WARNING]
> InformacionIncompletaExcepcion: Se lanza cuando se proporciona información incompleta para crear o actualizar un entrenador o aprendiz.
> [!WARNING]
> EntrenadorNoEncontradoExcepcion: Se lanza cuando no se encuentra un entrenador con el ID proporcionado.
> [!WARNING]
> EntrenadorNoEncontradoExcepcion: Se lanza cuando no se encuentra un entrenador con el ID proporcionado.
> [!WARNING]
> AprendizExistenteExcepcion: Se lanza cuando se intenta crear un aprendiz con un correo electrónico ya existente.
> [!WARNING]
> AprendizNoEncontradoExcepcion: Se lanza cuando no se encuentra un aprendiz con el ID proporcionado.
> [!WARNING]
> AprendizNoExistenteExcepcion: Se lanza cuando no se encuentran aprendices en el repositorio.





