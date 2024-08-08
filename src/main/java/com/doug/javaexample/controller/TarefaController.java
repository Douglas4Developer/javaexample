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
import javax.faces.bean.ManagedBean;

@Controller
@ManagedBean
@SessionScope
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ProjetoService projetoService;

    private Projeto projetoSelecionado;  //para tratar os projetos selecionados


    private Tarefa tarefaSelecionada;//para tratar as tarefas  selecionados

    public List<Tarefa> getTarefas() {
        return tarefaService.getTarefas();
    }

    public List<Tarefa> getTarefasPorProjeto() {
        if (projetoSelecionado != null) {
            return tarefaService.getTarefasPorProjeto(projetoSelecionado.getId());
        } else {
            return null;
        }
    }
    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
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

    // Método para iniciar a visualização das tarefas de um projeto
    public String visualizarTarefas(Projeto projeto) {
        this.projetoSelecionado = projeto;
        return "listarTarefas?faces-redirect=true";
    }

    // Métodos adicionados para edição, exclusão e nova tarefa

    public String editarTarefa(Tarefa tarefa) {
        this.tarefaSelecionada = tarefa;
        return "editarTarefa?faces-redirect=true";
    }

    public String excluirTarefa(Tarefa tarefa) {
        tarefaService.deleteTarefa(tarefa.getId());
        return "listarTarefas?faces-redirect=true";
    }

    public String novaTarefa() {
        this.tarefaSelecionada = new Tarefa();
        if (projetoSelecionado != null) {
            this.tarefaSelecionada.setProjeto(projetoSelecionado);
        }
        return "cadastroTarefa?faces-redirect=true";
    }
}
