INSERT INTO usuarios (id, telefono, contrasena, nombre, apellido, email) VALUES(1200, 3054213580, '12345', 'Mateo', 'Ortiz Lopez', 'mateo.ortiz202@gmail.com');
INSERT INTO comentarios (id, id_usuario, respuesta, id_publicacion) VALUES(1200, 1, 'Me parece no muy inteligente tu pregunta crack', 24);
INSERT INTO publicaciones (id, id_usuario, asunto) VALUES(1300, 1, '¿Cual es el oso mas perezoso?');
INSERT INTO respuestas (id, respuesta_comentario,id_usuario, id_comentario) VALUES(1400, 'Que respuesta tan tonta', 1, 1);
