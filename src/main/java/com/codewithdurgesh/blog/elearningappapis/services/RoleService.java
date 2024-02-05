package com.codewithdurgesh.blog.elearningappapis.services;
import com.codewithdurgesh.blog.elearningappapis.payloads.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto created(RoleDto roleDto);
    RoleDto  update(RoleDto roleDto, Integer roleId);

    //delete
    void delete(Integer roleId);

    //getStudentsbyId

    RoleDto getRoleById(Integer roleId);

    //get get all User
    List<RoleDto> getallRole();

}
