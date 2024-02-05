package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.Role;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.payloads.RoleDto;
import com.codewithdurgesh.blog.elearningappapis.repositories.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    private final ModelMapper modelMapper;

    public RoleServiceImpl( RoleRepo roleRepo, ModelMapper modelMapper) {
        this.roleRepo = roleRepo;
        this.modelMapper = modelMapper;
    }

    //create
    @Override
    public RoleDto created(RoleDto roleDto){
        Role role = new Role();
        role.setId(role.getId());
        role.setRolename(role.getRolename());
        Role save = roleRepo.save(role);
        return mapToCls(save, RoleDto.class);
    }
    @Override
    public RoleDto update(RoleDto roleDto, Integer roleId) {
        return null;
    }

    //delete
    @Override
    public void delete(Integer roleId){
        Role role =this.roleRepo.findById(roleId)
                .orElseThrow(()->new ResourceNotFoundException("Role", "Id",roleId));
        this.roleRepo.delete(role);
    }
    //getTeacherById
    @Override
    public RoleDto getRoleById(Integer roleId){
        Role role =this.roleRepo.findById(roleId).orElseThrow(()-> new ResourceNotFoundException("role", "Id", roleId));
        return mapToCls(role,RoleDto.class);
    }
    //getall user

    public List<RoleDto> getallRole(){
        List<Role> roles = this.roleRepo.findAll();
        List<RoleDto> roleDtos = roles.stream().map(role -> mapToCls(role, RoleDto.class)).toList();
        return roleDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }



}
