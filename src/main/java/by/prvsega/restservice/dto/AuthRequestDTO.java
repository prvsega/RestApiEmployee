package by.prvsega.restservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequestDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;


}
