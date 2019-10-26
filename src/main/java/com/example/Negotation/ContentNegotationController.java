package com.example.Negotation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ContentNegotationController {

    static HashMap<Integer, Employee> getEmployees() {
        HashMap<Integer, Employee> emplyeemap = new HashMap<>();
        emplyeemap.put(1, new Employee(1, "Naveen"));
        emplyeemap.put(2, new Employee(2, "Deleep"));
        emplyeemap.put(3, new Employee(3, "Nandu"));
        return emplyeemap;
    }

    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public HashMap<Integer, Employee> retrieveAll() {
        return getEmployees();
    }

    //Request URL:
    //          localhost:9089/addEmployee/4?name=madhuri
    @RequestMapping(value = "/addEmployee/{id}/", method = RequestMethod.POST)
    public Employee addEmployee(@RequestParam(value = "name") String name,
                                @PathVariable(value = "id") int id) {
        Employee employee = new Employee(id, name);
        int size = getEmployees().size();
        getEmployees().put(size + 1, employee);
        return employee;
    }
}
