package com.Project.demo.modelo.DAOs;

import com.Project.demo.modelo.Entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Cliente> findAll(){


        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        em.persist(cliente);
    }


}
