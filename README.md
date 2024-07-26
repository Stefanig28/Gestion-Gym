
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
 
## Modelos
  
### Aprendiz

```
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
```



