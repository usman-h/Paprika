package com.usmanhussain.paprika.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;

import java.util.HashMap;

public class DemoPage extends AbstractPage {
    protected final HashMap<String, By> WebElementPath = new HashMap();

    public DemoPage() {
        WebElementPath.put("changeNumberTextField", By.cssSelector("input[id='sys_readonly.change_number']"));
    }
}
