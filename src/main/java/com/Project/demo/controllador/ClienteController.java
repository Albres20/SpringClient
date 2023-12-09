package com.Project.demo.controllador;

import com.Project.demo.modelo.DAOs.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class ClienteController {
    //@RequestMapping(value="listar")

    @Autowired
    @Qualifier("clienteDaoJPA")
    private IClienteDao clienteDao;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "Lista de Clientes");
        model.addAttribute("clientes", clienteDao.findAll());

        Object test=clienteDao.findAll();
        return "listar";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
