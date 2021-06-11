package ml.bigbrains.statusnpd.model;

import lombok.Data;

@Data
public class GenericResponse {
    private String code;
    private String message;
    private String health;
    private String operationId;
    private String exceptionMessage;
}
