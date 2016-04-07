package org.fasttrackit.Forms;


import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

public class FirstFormView extends WebLocator {

    public FirstFormView() {
        setTag("form");
        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);
    }
  //  private WebLocator stopProcessContainer =new WebLocator(this).setElPath("/div[3]");
  //  private WebLocator enterContainer =new WebLocator(this).setElPath("/div[4]");
  //  public DatePicker datePicker = new DatePicker();
  public WebLocator stopProcessLabel = new WebLocator(this).setTag("Label").setText("Stop the process?", SearchType.TRIM);//am modificat si am considerat ca si container  labelurile.Are valoare pt ca asa putem sa ne asiguram ca nu se schimba textul labelului.
    public WebLocator enterLabel = new WebLocator(this).setTag("label").setText("Label with Enter.", SearchType.CHILD_NODE);

    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");
    public CheckBox stopProcessCheckbox = new CheckBox(stopProcessLabel);
    public CheckBox enterCheckbox = new CheckBox(enterLabel);




    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();
        System.out.println(formView.stopProcessCheckbox.getSelector());
    }
}
