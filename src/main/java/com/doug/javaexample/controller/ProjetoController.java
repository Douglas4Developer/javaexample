package com.doug.javaexample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import javax.faces.bean.ManagedBean;

import com.doug.javaexample.entity.Projeto;
import com.doug.javaexample.service.ProjetoService;

@Controller
@ManagedBean
@SessionScope
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private TarefaController tarefaController; // Injetando o TarefaController

    private Projeto projetoSelecionado;

    // Método que retorna a lista de projetos para uso no JSF
    public List<Projeto> getProjetos() {
        return projetoService.getProjetos();
    }

    // Método que é chamado ao clicar no botão "Entrar" na página bemVindo.xhtml
    public String listarProjetos() {
        return "listarProjetos?faces-redirect=true";
    }

    // Método para iniciar o cadastro de um novo projeto
    public String novoProjeto() {
        projetoSelecionado = new Projeto();
        return "cadastroProjeto?faces-redirect=true";
    }

    // Método para salvar o projeto
    public String saveProjeto() {
        projetoService.saveProjeto(projetoSelecionado);
        return "listarProjetos?faces-redirect=true";
    }

    // Método para iniciar a edição de um projeto
    public String editarProjeto(Projeto projeto) {
        this.projetoSelecionado = projeto;
        return "editarProjeto?faces-redirect=true";
    }

    // Método para excluir um projeto
    public String excluirProjeto(Projeto projeto) {
        projetoService.deleteProjeto(projeto.getId());
        return "listarProjetos?faces-redirect=true";
    }

    // Método para visualizar tarefas de um projeto
    public String visualizarTarefas(Projeto projeto) {
        this.projetoSelecionado = projeto;
        tarefaController.setProjetoSelecionado(projeto); // Define o projeto selecionado no TarefaController
        return "listarTarefas?faces-redirect=true";
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }
}
