package com.foroAlura.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fecha_creacion;
    private Boolean estatus;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(RegistroTopico dt) {
        this.titulo = dt.titulo();
        this.mensaje = dt.mensaje();
        this.fecha_creacion = dt.fecha_creacion();
        this.estatus = dt.estatus();
        this.autor = dt.autor();
        this.curso = dt.curso();
    }

    public void actualizarTopico(ActualizarTopico actualizarTopico) {
        this.mensaje = actualizarTopico.mensaje();
        this.estatus = actualizarTopico.estatus();
    }
}
