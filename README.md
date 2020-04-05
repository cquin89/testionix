Ejercicio 2
    Considerar el siguiente caso:
    Una aplicación debe capturar data sensible y enviarla a un servicio de autorización. La data
    sensible debe ser transmitida a través de la APP API según se indica en el siguiente
    diagrama, sin embargo, no puede ser legible hasta que llegue al servicio de autorización.
    Describa un método para permitir la captura y transmisión de información de forma segura
    según lo planteado, sin considerar el uso de certificados SSL.

Respuesta: Para garantizar la entrega de los datos de manera segura utilizaría tls 1.3, ya que es
    mas seguro y robusto que SSL con su manejo de llaves privadas tanto en el cliente como en el
    servidor de autenticación y una llave publica que al combinarse con la privada incrementa la
    seguridad de los datos, igual puede ser capturado los datos pero poder volverlos legibles
    resulta mucho mas difícil que mediante el certificado SSL.