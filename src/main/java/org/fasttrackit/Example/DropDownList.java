package org.fasttrackit.Example;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.ICombo;

public class DropDownList extends WebLocator implements ICombo{
    public DropDownList() {
        setTag("button");
        setBaseCls("dropdown-toggle");

    }

    @Override
    public boolean select(String value) {
        assertClick();
        WebLocator select = new WebLocator().setClasses("bootstrap-select", "open");
        WebLocator element = new WebLocator(select).withText(value);
        element.assertClick();
        return false;
    }

    @Override
    public String getValue() {
        return null;
    }
}
