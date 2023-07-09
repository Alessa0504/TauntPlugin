package com.plugin.taunt;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TauntDialog extends DialogWrapper {

    private JLabel label;

    protected TauntDialog() {  //构造方法
        super(true);
        setTitle("每天一碗毒鸡汤");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        this.label = new JLabel(ContentUtil.getContent());
        panel.add(label);
        return panel;
    }

    /**
     * 覆写底部面板
     *
     * @return
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("next page");
        button.addActionListener(e -> {   //click事件
            String content = ContentUtil.getContent();
            label.setText(content);
        });
        panel.add(button);
        return panel;
    }
}
