package es.aclavijo.bikeapp.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@AllArgsConstructor
@Data
public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

}
