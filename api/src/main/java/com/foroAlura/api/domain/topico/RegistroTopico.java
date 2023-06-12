package com.foroAlura.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Date fecha_creacion,
        @NotNull
        Boolean estatus,
        @NotBlank
        String autor,
        @NotNull
        Curso curso) {}
