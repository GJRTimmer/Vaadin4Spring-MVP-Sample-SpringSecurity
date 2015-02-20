package org.vaadin.spring.sample.security.ui.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.vaadin.spring.annotation.VaadinUI;
import org.vaadin.spring.annotation.VaadinUIScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.mvp.MvpHasPresenterHandlers;
import org.vaadin.spring.mvp.MvpView;
import org.vaadin.spring.mvp.presenter.AbstractMvpPresenterView;
import org.vaadin.spring.navigator.annotation.VaadinView;
import org.vaadin.spring.sample.security.service.DummyService;
import org.vaadin.spring.sample.security.ui.ViewToken;
import org.vaadin.spring.security.VaadinSecurity;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

@SuppressWarnings("serial")
@VaadinUIScope
@VaadinView(name = ViewToken.HOME)
public class HomePresenter extends AbstractMvpPresenterView<HomePresenter.HomeView> implements HomePresenterHandlers {
	
	public interface HomeView extends MvpView, MvpHasPresenterHandlers<HomePresenterHandlers> {
		public void initView(String userName, String loginType);		
	}		
	
	@Autowired
	VaadinSecurity security;
	
	@Autowired
	DummyService dummyService;
	
	@Autowired
	public HomePresenter(HomeView view, EventBus eventBus) {
		super(view, eventBus);
		getView().setPresenterHandlers(this);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		/*
		 * UsernamePasswordAuthenticationToken OR
		 * AnonymousAuthenticationToken
		 */
		Authentication a = security.getAuthentication();
		getView().initView(a.getName(), a.getClass().getSimpleName());
		
	}

	
	
}
