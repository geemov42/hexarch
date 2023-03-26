package io.geemov42.hexarch.application.business.api.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {

    private int id;
    private String title;
    private String description;
    private int version;
}
