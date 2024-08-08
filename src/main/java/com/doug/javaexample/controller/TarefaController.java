package com.doug.javaexample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.doug.javaexample.entity.Tarefa;
import com.doug.javaexample.entity.Projeto;
import com.doug.javaexample.service.TarefaService;
import com.doug.javaexample.service.ProjetoService;
import org.springframework.web.context.annotation.SessionScope;



@Controller
@SessionScope
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ProjetoService projetoService;

    public List<Tarefa> getTarefas() {
        return tarefaService.getTarefas();
    }

    @GetMapping("/list")
    public String listTarefas(Model model) {
        List<Tarefa> tarefas = tarefaService.getTarefas();
        model.addAttribute("tarefas", tarefas);
        return "listarTarefas";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Tarefa tarefa = new Tarefa();
        List<Projeto> projetos = projetoService.getProjetos();
        model.addAttribute("tarefa", tarefa);
        model.addAttribute("projetos", projetos);
        return "cadastroTarefa";
    }

    @PostMapping("/saveTarefa")
    public String saveTarefa(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaService.saveTarefa(tarefa);
        return "redirect:/tarefa/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("tarefaId") int id, Model model) {
        Tarefa tarefa = tarefaService.getTarefa(id);
        List<Projeto> projetos = projetoService.getProjetos();
        model.addAttribute("tarefa", tarefa);
        model.addAttribute("projetos", projetos);
        return "editarTarefa";
    }

    @GetMapping("/delete")
    public String deleteTarefa(@RequestParam("tarefaId") int id) {
        tarefaService.deleteTarefa(id);
        return "redirect:/tarefa/list";
    }
}
