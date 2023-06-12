package com.foroAlura.api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(@NotNull Long id, String mensaje, Boolean estatus) {
}
