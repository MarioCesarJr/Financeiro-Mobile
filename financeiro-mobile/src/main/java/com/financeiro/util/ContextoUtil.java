package com.financeiro.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.financeiro.controller.LoginUsuarioBean;

public class ContextoUtil {

	public static LoginUsuarioBean getContextoBean(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		
		HttpSession session = (HttpSession) external.getSession(true);
		LoginUsuarioBean contextoBean = (LoginUsuarioBean) session.getAttribute("contextoBean");
		return contextoBean;
	}
}
