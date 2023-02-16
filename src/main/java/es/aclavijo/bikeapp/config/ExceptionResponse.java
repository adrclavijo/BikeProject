package es.aclavijo.bikeapp.config;

import static java.time.Instant.now;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RequiredArgsConstructor
@Data
public class ExceptionResponse {

    @NonNull
    private Instant date;
    private HttpStatus status;
    private String details;
    @NonNull
    private String path;

    public static ExceptionResponse fromRequest(WebRequest request) {
        return new ExceptionResponse(now(), request.getContextPath());
    }
}
