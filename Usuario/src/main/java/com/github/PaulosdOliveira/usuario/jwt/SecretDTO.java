package com.github.PaulosdOliveira.usuario.jwt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretDTO {
    private String encoded;
    private String algorithm;
}
