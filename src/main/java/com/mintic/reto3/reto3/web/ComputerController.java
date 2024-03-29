package com.mintic.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Computer;
import com.mintic.reto3.reto3.service.ComputerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Computer")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    
    /** 
     * @return List<Computer>
     */
    @GetMapping("/all")
    public List<Computer> getComputers() {
        return computerService.getAll();
    }

    
    /** 
     * @param id
     * @return Optional<Computer>
     */
    @GetMapping("/{id}")
    public Optional<Computer> getComputer(@PathVariable("id") int id) {
        return computerService.getComputer(id);
    }

    
    /** 
     * @param computer
     * @return Computer
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer computer) {
        return computerService.save(computer);
    }

    
    /** 
     * @param computer
     * @return Computer
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer computer){
        return computerService.update(computer);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteComputer(@PathVariable("id") int id){
        return computerService.deleteComputer(id);
    }
}
