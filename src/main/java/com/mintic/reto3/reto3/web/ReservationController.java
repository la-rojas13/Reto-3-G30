package com.mintic.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.CountClient;
import com.mintic.reto3.reto3.model.Reservation;
import com.mintic.reto3.reto3.model.StatusReservation;
import com.mintic.reto3.reto3.service.ReservationService;

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
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public StatusReservation getReservation() {
        return reservationService.getRepStatusRes();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationDate(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo")String dateTwo ){
        return reservationService.reportTimeService(dateOne, dateTwo);
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getClients(){
        return reservationService.reportClientService();
    }
}
