package com.Project.demo.modelo.DAOs;

import com.Project.demo.modelo.Entidades.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
}
