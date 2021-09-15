package ru.jm.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jm.crud.dao.RoleDao;
import ru.jm.crud.model.Role;

import java.util.List;

// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    @Autowired
    public void setRole(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void edit(Role role) {
        roleDao.edit(role);
    }

    @Override
    public Role getById(long id) {
        return roleDao.getByID(id);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }
}
