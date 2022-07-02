package bragagustavo.com.github.api.domain.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome")
    @NotEmpty(message = "Campo é obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 letras")
    private String nome;

    @Column(name = "email")
    @NotEmpty(message = "Campo email é obrigatório")
    @Email(message = "E-mail invalido")
    private String email;


    @Column(name = "telefone")
    @NotEmpty(message = "Campo telefone é obrigatório")
    @Length(min = 8, max = 15, message = "Campo telefone deve possuir entre 8 e 15 caracteres")
    private String telefone;


    @Column(unique = true, name = "cpf")
    @CPF
    @NotEmpty(message = "Campo CPF nao pode ser vazio")
    private String cpf;
    
    @Column(name = "endereco")
    @Length(min = 5, max = 120, message = "O endereço deve possuir entre 5 e 120 caracteres")
    private String endereço;



    
}
