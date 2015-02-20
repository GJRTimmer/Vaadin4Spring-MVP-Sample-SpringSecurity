package org.vaadin.spring.sample.security.ui.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.vaadin.spring.annotation.VaadinUI;
import org.vaadin.spring.annotation.VaadinUIScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.mvp.MvpView;
import org.vaadin.spring.mvp.presenter.AbstractMvpPresenterView;
import org.vaadin.spring.sample.security.ui.ViewToken;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

@SuppressWarnings("serial")
@VaadinUIScope
@VaadinUI(path=ViewToken.ADMIN)
@Secured({"ROLE_ADMIN"})
public class AdminPresenter extends AbstractMvpPresenterView<AdminPresenter.AdminView> {
	
	public interface AdminView extends MvpView {
		
	}
	
	@Autowired
	public AdminPresenter(AdminView view, EventBus eventBus) {
		super(view, eventBus);		
	}

	@Override
	public void enter(ViewChangeEvent event) {		
		
	}

	

}
