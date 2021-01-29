package com.example.demo.domain;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SwaggerPageable {



    private String sizeee;

    @Parameter(
            in = ParameterIn.QUERY,
            description = "Zero-based page index (0..N)",
            name = "page",
            schema = @Schema(
                    type = "integer",
                    defaultValue = "0"
            ))
    private String page;


    private String sort;

}

