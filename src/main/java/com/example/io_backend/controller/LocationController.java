package com.example.io_backend.controller;

import com.example.io_backend.model.Location;
import com.example.io_backend.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("")
    public List<Location> getAll() {
        return locationService.getLocations();
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable Long id){
        return locationService.getLocationById(id);
    }

    @PostMapping("")
    public Location add(@RequestBody Location location){
        return locationService.addLocation(location);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Location location,@PathVariable Long id){
        locationService.updateLocation(location,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    /*@GetMapping("")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id){
        userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }*/

}
