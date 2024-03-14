package com.elearningapp.api.controllers;

import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.payloads.RoleDto;
import com.elearningapp.api.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class Rolecontrollers {
    private final RoleService roleService;

    public Rolecontrollers(RoleService roleService) {
        this.roleService = roleService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<RoleDto> created(@Valid @RequestBody RoleDto roleDto){
        RoleDto  createDto = this.roleService.created(roleDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{roleId}")
    public ResponseEntity<RoleDto> update (@Valid @RequestBody RoleDto roleDto, @PathVariable("roleId") Integer uid){
        RoleDto update= this.roleService.update(roleDto, uid);
        return ResponseEntity.ok(update);
    }
    //Delete
    @DeleteMapping("/{roleId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("roleId") Integer uid){
        this.roleService.delete(uid);
        return new ResponseEntity(new ApiResponse("role delete Successfully",true),HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<RoleDto>>getAllRole(){
        return ResponseEntity.ok(this.roleService.getallRole());
    }
    //Get-user get
    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDto> getSingleRole(@PathVariable Integer roleId )
    {
        return ResponseEntity.ok(this.roleService.getRoleById(roleId));
    }
}
