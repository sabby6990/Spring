package org.test;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.test.beans.DarkSide;
import org.test.beans.Student;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	AbstractApplicationContext context = null;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout leftPanel = new VerticalLayout();
		final VerticalLayout rightPanel = new VerticalLayout();
		final HorizontalSplitPanel hSplitPanel = new HorizontalSplitPanel();
		Label displayContentLbl = new Label();
		Button button = new Button("Simple bean");
		button.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("application.xml");
			Student student = (Student) context.getBean("studentbean");
			displayContentLbl.setValue(student.getName());
		});

		Button button1 = new Button("CI with Object");
		button1.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("application.xml");
			DarkSide darkSide1 = (DarkSide) context.getBean("darkside1");
			displayContentLbl.setValue(
					"leader: " + darkSide1.getLeaderName() + " trooper name: " + darkSide1.getTrooper().getName());

		});

		leftPanel.addComponents(button, button1);
		leftPanel.setMargin(true);
		leftPanel.setSpacing(true);

		rightPanel.addComponent(displayContentLbl);
		hSplitPanel.setFirstComponent(leftPanel);
		hSplitPanel.setSecondComponent(rightPanel);
		setContent(hSplitPanel);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}
