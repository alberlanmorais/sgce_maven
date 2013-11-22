package br.com.sgce.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import br.com.sgce.dao.HibernateDAO;
import br.com.sgce.dao.InterfaceDAO;
import br.com.sgce.entity.Aluno;
import br.com.sgce.util.FacesContextUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbAluno")
@SessionScoped
public class MbAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    private Aluno aluno = new Aluno();
    private List<Aluno> alunos;

    public MbAluno() {
    }

    private InterfaceDAO<Aluno> alunoDAO() {
        InterfaceDAO<Aluno> alunoDAO = new HibernateDAO<Aluno>(Aluno.class, FacesContextUtil.getRequestSession());
        return alunoDAO;
    }

    public String limpAluno() {

        return "//restrict/cadastraraluno.jsf";
    }

    public String editAluno() {
        return "//restrict/cadastraraluno.jsf";
    }

    public String addAluno() {
        if (aluno.getId_aluno() == null || aluno.getId_aluno() == 0) {
            insertAluno();
        } else {
            updateAluno();
        }

        return null;
    }

    private void insertAluno() {
        alunoDAO().save(aluno);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateAluno() {
        alunoDAO().update(aluno);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deleteAluno() {
        alunoDAO().remove(aluno);
    }
    
    public List<Aluno> getAlunos() {
        alunos = alunoDAO().getEntities();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
     
}
