package com.doug.javaexample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.doug.javaexample.entity.Projeto;
import com.doug.javaexample.service.ProjetoService;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.bean.ManagedBean;

@Controller
@ManagedBean
@SessionScope
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    // Método que retorna a lista de projetos para uso no JSF
    public List<Projeto> getProjetos() {
        return projetoService.getProjetos();
    }

    // Método que é chamado ao clicar no botão "Entrar" na página bemVindo.xhtml
    public String listarProjetos() {
        return "listarProjetos?faces-redirect=true";
    }

    @RequestMapping("/projeto/list")
    public String listProjetos(Model model) {
        List<Projeto> projetos = projetoService.getProjetos();
        model.addAttribute("projetos", projetos);
        return "listarProjetos";
    }

    @RequestMapping("/projeto/showForm")
    public String showFormForAdd(Model model) {
        Projeto projeto = new Projeto();
        model.addAttribute("projeto", projeto);
        return "cadastroProjeto";
    }

    @RequestMapping(value = "/projeto/saveProjeto", method = RequestMethod.POST)
    public String saveProjeto(@ModelAttribute("projeto") Projeto projeto) {
        projetoService.saveProjeto(projeto);
        return "redirect:/projeto/list";
    }

    @RequestMapping("/projeto/updateForm")
    public String showFormForUpdate(@RequestParam("projetoId") int id, Model model) {
        Projeto projeto = projetoService.getProjeto(id);
        model.addAttribute("projeto", projeto);
        return "editarProjeto";
    }

    @RequestMapping("/projeto/delete")
    public String deleteProjeto(@RequestParam("projetoId") int id) {
        projetoService.deleteProjeto(id);
        return "redirect:/projeto/list";
    }
}
