package com.demo.panel;

import com.demo.Context;
import com.demo.entity.MenuType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton amountBtn = new JButton("库存管理");
    private JButton saleBtn = new JButton("销售管理");
    private JButton userBtn = new JButton("会员管理");
    private JButton adminBtn = new JButton("用户管理");
    private JButton selfBtn = new JButton("个人信息");

    public MenuPanel() {

        setSize(200, 400);

        // 设置为Card布局
        setLayout(new GridLayout(5,1,0,0));

        // 点击事件
        amountBtn.addActionListener(new BtnActionListener(MenuType.amount));
        saleBtn.addActionListener(new BtnActionListener(MenuType.sale));
        userBtn.addActionListener(new BtnActionListener(MenuType.user));
        adminBtn.addActionListener(new BtnActionListener(MenuType.admin));
        selfBtn.addActionListener(new BtnActionListener(MenuType.self));

        add(amountBtn);
        add(saleBtn);
        add(userBtn);
        add(adminBtn);
        add(selfBtn);
    }

    private class BtnActionListener implements ActionListener {

        private MenuType menuType;

        BtnActionListener(MenuType type) {
            this.menuType = type;
        }

        /**
         * 点击事件 切换成相应的菜单内容
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Context.mainFrame.changeMenu(this.menuType);
        }
    }
}
