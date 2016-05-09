package org.fasttrackit.Example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;

public class GridsView {

    public void openGrid() {
        openGrid("Grids", "Grid Data Binding");
    }

    public void openGrid(String title, String example) {
        WebLocator gridTab = new WebLocator().setText(title);
        WebLocator gridDataBinding = new WebLocator().setText(example);
        gridTab.mouseOver();//mouseover because element is not visible  and must scroll to it
        gridTab.click();
        gridDataBinding.click();
    }



}
