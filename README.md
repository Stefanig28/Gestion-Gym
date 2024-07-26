
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


