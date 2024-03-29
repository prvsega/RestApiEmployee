package by.prvsega.restservice.contollers;

import by.prvsega.restservice.dto.EmployeeDTO;
import by.prvsega.restservice.dto.PageResponseDTO;
import by.prvsega.restservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // Controller + ResponseBody
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping // all employees
    public List<EmployeeDTO> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping(params = { "offset", "limit" }) // page with param page = 0+,size = 1+
    public PageResponseDTO<EmployeeDTO> getEmployeesPageable(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        return employeeService.findAllPageable(offset, limit);
    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") int id) {

        return employeeService.findOne(id);
    }

//    @PostMapping()
//    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
//        return ResponseEntity.ok(employeeService.save(employeeDTO));
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("id") int id) {
        EmployeeDTO employeeDTO = employeeService.findOne(id);
        employeeService.delete(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int id, @RequestBody @Valid EmployeeDTO updateEmployeeDTO) {
        employeeService.update(id, updateEmployeeDTO);
        EmployeeDTO employeeDTO = getEmployee(id);

        return ResponseEntity.ok(employeeDTO);
    }
}