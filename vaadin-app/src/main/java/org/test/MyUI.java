package org.test;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.test.beans.Customer;
import org.test.beans.DarkSide;
import org.test.beans.DarkSideArmy;
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
public class MyUI extends UI implements ApplicationContextAware{
	//AbstractApplicationContext context = null;

	ApplicationContext context ;
	
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout leftPanel = new VerticalLayout();
		final VerticalLayout rightPanel = new VerticalLayout();
		final HorizontalSplitPanel hSplitPanel = new HorizontalSplitPanel();
		Label displayContentLbl = new Label();
		Button button = new Button("autowired by name");
		button.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("si_applicationcontext.xml");
			Customer student = (Customer) context.getBean("customer");
			displayContentLbl.setValue(student.getAddress().getFullAddress());
		});

		Button button1 = new Button("CI with Object");
		button1.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("application.xml");
			DarkSide darkSide1 = (DarkSide) context.getBean("darkside1");
			displayContentLbl.setValue(
					"leader: " + darkSide1.getLeaderName() + " trooper name: " + darkSide1.getTrooper().getName());

		});

		Button button2 = new Button("CI with list objects");
		StringBuffer strBuffer = new StringBuffer();
		button2.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("application.xml");
			DarkSideArmy darksideArmy = (DarkSideArmy) context.getBean("darksideArmy");
			darksideArmy.getArmy().forEach(trooper -> {
				strBuffer.append(trooper.getName()+"\n");
			});
			displayContentLbl.setValue(strBuffer.toString());
			

		});
		
		Button beanWithParentBtn = new Button("CI with Object");
		beanWithParentBtn.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("application.xml");
			Student studentObj = (Student) context.getBean("student");
			displayContentLbl.setValue(
					"leader: " + studentObj.getName() + " trooper name: " + studentObj.show());

		});
		
		Button autoWireByTypeBtn = new Button("autowired by constructor");
/*		autoWireByTypeBtn.addClickListener(e -> {
			context = new ClassPathXmlApplicationContext("si_applicationcontext.xml");
			Customer customerObj = (Customer) context.getBean("customerByType");
			displayContentLbl.setValue(customerObj.getAddress().getFullAddress());
		});*/

		leftPanel.addComponents(button, button1, button2,beanWithParentBtn,autoWireByTypeBtn);
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

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
	}
}
