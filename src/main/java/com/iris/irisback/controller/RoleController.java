package com.iris.irisback.controller;

import com.iris.irisback.model.Role;
import com.iris.irisback.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role/")
@CrossOrigin(origins = "*")
public class RoleController {
  private final RoleRepository roleRepository;

  public RoleController(final RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  //  @GetMapping("add")
  //  public String showAddRoleForm() {
  //    return null;
  //  }

  @PostMapping("add")
  public Role addRole(@RequestBody final Role role) {
    return roleRepository.save(role);
  }
}
