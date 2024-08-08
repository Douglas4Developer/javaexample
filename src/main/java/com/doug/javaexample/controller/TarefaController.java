package com.doug.javaexample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.doug.javaexample.entity.Tarefa;
import com.doug.javaexample.entity.Projeto;
import com.doug.javaexample.service.TarefaService;
import com.doug.javaexample.service.ProjetoService;

@Controller
@ManagedBean
@SessionScope
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ProjetoService projetoService;

    private Projeto projetoSelecionado;

    private Tarefa tarefaSelecionada;

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

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }

    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    // Método para iniciar a visualização das tarefas de um projeto
    public String visualizarTarefas(Projeto projeto) {
        this.projetoSelecionado = projeto;
        return "listarTarefas?faces-redirect=true";
    }

    // Método para salvar a tarefa
    public String saveTarefa() {
        if (projetoSelecionado != null) {
            tarefaSelecionada.setProjeto(projetoSelecionado);
        }
        tarefaService.saveTarefa(tarefaSelecionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa salva com sucesso!"));
        return "listarTarefas?faces-redirect=true";
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
    public String saveTarefaForm(@ModelAttribute("tarefa") Tarefa tarefa) {
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

    // Método para iniciar a edição de uma tarefa
    public String editarTarefa(Tarefa tarefa) {
        this.tarefaSelecionada = tarefa;
        return "editarTarefa?faces-redirect=true";
    }

    // Método para cancelar a edição de uma tarefa
    public String cancelarEdicao() {
        return "listarTarefas?faces-redirect=true";
    }

    // Método para adicionar uma nova tarefa
    public String novaTarefa() {
        this.tarefaSelecionada = new Tarefa();
        return "cadastroTarefa?faces-redirect=true";
    }

    // Método para excluir uma tarefa
    public String deleteTarefa(Tarefa tarefa) {
        tarefaService.deleteTarefa(tarefa.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa excluída com sucesso!"));
        return "listarTarefas?faces-redirect=true";
    }
}
