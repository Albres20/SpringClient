package com.Project.demo.controllador;

import com.Project.demo.modelo.DAOs.IClienteDao;
import com.Project.demo.modelo.Entidades.Cliente;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.jsoup.Connection.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class ClienteController {
    public static final int maxPages = 20;
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

    @GetMapping("/form")
    public String crear (Map<String, Object> model){
        Cliente cliente=new Cliente();
        model.put("titulo","Formulario Cliente");
        model.put("cliente", cliente);
        return "form";
    }
    @PostMapping("/form")
    public String guardar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:listar";
    }



}
