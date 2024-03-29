package by.prvsega.restservice.security;

import by.prvsega.restservice.models.Employee;
import by.prvsega.restservice.models.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@Setter
public class EmployeeDetailsImpl implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    public static EmployeeDetailsImpl fromUser(Employee employee) {
        EmployeeDetailsImpl employeeDetails = new EmployeeDetailsImpl();
        employeeDetails.id = employee.getId();
        employeeDetails.password = employee.getPassword();
        employeeDetails.username = employee.getUsername();
        employeeDetails.authorities = mapToGrantedAuthorities(employee.getRolesSet());

        return employeeDetails;
    }

    private static List<SimpleGrantedAuthority> mapToGrantedAuthorities(Set<Role> userRoles) {
        List<SimpleGrantedAuthority> list = userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRolesName())
                ).collect(Collectors.toList());

        return list;
    }

}
