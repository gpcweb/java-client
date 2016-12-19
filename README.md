# java-client

Para revisar este proyecto debes descargarlo con: ```git clone git@github.com:gpcweb/java-webservice.git```

Luego debes abrirlo con Spring STS y ejecutar como "Run as -> Spring Boot App"

Este proyecto cuenta con un pequeño formulario que te permite guardar un nuevo recurso en un webservice (Ver java-webservice).
Para ello solo debes ir a la siguiente url: ```localhost:8090/users/new```


* El webservice cuenta con validaciones, por lo tanto: 

  * Debes siempre como username enviar "usuario1", cualquier otro nombre devuelve un 401.
  * Debes siempre enviar el user name, sino lo envias devuelve un 400.
  * Debes siempre enviar adjuntar una imagen, sino la envias devuelve un 400.
