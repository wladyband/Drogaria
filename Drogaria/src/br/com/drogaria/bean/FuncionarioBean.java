package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	public void salvar(){
		FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso");
	}

}
