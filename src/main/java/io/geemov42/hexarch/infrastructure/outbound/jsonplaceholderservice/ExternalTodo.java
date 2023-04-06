package io.geemov42.hexarch.infrastructure.outbound.jsonplaceholderservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalTodo {

    private Long userId;
    private Long id;
    private String title;
    private boolean completed;

}
