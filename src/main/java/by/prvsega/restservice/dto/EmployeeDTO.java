package by.prvsega.restservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private int id;

    @NotEmpty
    @Size(max=20)
    private String firstName; //20

    @NotEmpty
    @Size(max=30)
    private String lastName; //30

    @NotEmpty
    @Size(max=100)
    @Email
    private String email; //100

    @NotEmpty
    @Size(max=100)
    private String jobTitle; //100

    @NotEmpty
    @Size(max=20)
    private String gender; //20

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private byte[] image;

    private Set<RoleDTO> rolesSet = new HashSet<>();
    private List<MediaDTO> mediaList = new ArrayList<>();
}
