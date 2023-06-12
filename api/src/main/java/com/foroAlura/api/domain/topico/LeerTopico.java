package com.foroAlura.api.domain.topico;

import java.util.Date;

public record LeerTopico(Long id, String titulo, String mensaje, Date fecha_creacion,String autor, Boolean estatus, Curso curso) {
}
