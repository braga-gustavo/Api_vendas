package bragagustavo.com.github.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    @Column(name = "titulo", length = 100)
    @NotEmpty(message = "Campo titulo é obrigatório")
    private String title;

    @Column(name = "preco_unitario")
    @NotNull(message = "Campo preco é obrigatório")
    private Double price;
}
