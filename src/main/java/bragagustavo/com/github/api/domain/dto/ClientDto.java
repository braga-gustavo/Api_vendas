package bragagustavo.com.github.api.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {


    private Integer id;

    @NotEmpty(message = "Campo é obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 letras")
    private String name;

    @NotEmpty(message = "Campo email é obrigatório")
    @Email(message = "E-mail invalido")
    private String email;

    @NotEmpty(message = "Campo telefone é obrigatório")
    @Length(min = 8, max = 15, message = "Campo telefone deve possuir entre 8 e 15 caracteres")
    private String phone;
}
