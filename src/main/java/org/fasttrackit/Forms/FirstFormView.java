package org.fasttrackit.Forms;


import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstFormView extends WebLocator {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLocator.class);
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

        generateTDXpath();
    }

    public static void generateTDXpath () {


        WebLocator emailCell = new WebLocator().setText("peterparker@mail.com");
        WebLocator row = new WebLocator().setTag("tr").setChildNodes(emailCell);
        CheckBox select = new CheckBox(row);

        LOGGER.debug(select.getXPath());

        Table table = new Table();
        Row row1 = table.getRow(new Cell(4, "peterparker@mail.com"));
        CheckBox select1 = new CheckBox(row1);
        LOGGER.debug(select1.getXPath());



    }

//    WebLocator pref = new WebLocator(nav).setText("Preferences");
//    System.out.println();
}
