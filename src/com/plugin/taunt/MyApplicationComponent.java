package com.plugin.taunt;

import com.intellij.openapi.components.ApplicationComponent;

public class MyApplicationComponent implements ApplicationComponent {
    @Override
    public void initComponent() {   //idea启动时调用
        System.out.println("initComponent");
        TauntDialog tauntDialog = new TauntDialog();
        tauntDialog.show();
    }
}
