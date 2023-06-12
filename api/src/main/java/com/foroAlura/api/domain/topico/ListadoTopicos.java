package com.foroAlura.api.domain.topico;

import java.util.Date;

public record ListadoTopicos(Long id, String titulo, String mensaje, Date fecha_creacion,String autor, Boolean estatus, Curso curso) {
   public ListadoTopicos(Topico tp){
       this(tp.getId(), tp.getTitulo(), tp.getMensaje(),tp.getFecha_creacion(),tp.getAutor(),tp.getEstatus(),tp.getCurso());
   }
}
