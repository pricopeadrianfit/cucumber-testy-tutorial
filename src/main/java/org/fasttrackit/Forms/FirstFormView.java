package org.fasttrackit.Forms;


import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

public class FirstFormView extends WebLocator {

    public FirstFormView() {
        setTag("form");
        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);
    }
    private WebLocator stopProcessContainer =new WebLocator(this).setElPath("/div[3]");
    private WebLocator enterContainer =new WebLocator(this).setElPath("/div[4]");
    public DatePicker datePicker = new DatePicker();
    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");
    public CheckBox stopProcessCheckbox = new CheckBox(stopProcessContainer);
    public CheckBox enterCheckbox = new CheckBox(enterContainer);

    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();
        System.out.println(formView.stopProcessCheckbox.getSelector());
    }
}
