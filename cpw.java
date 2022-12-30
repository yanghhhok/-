package ATMDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class cpw {
    JFrame jf2=new JFrame("修改密码界面");
    final int WIDTH=700;
    final int HEIGHT=300;
    //组装视图
    public void init(){
        //设置窗口相关的属性
        jf2.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        jf2.setResizable(false);
        //设置窗口内容
        JPanel jp2=new JPanel();
        //设置登陆相关元素
        Box vbox2=Box.createVerticalBox();
        //组装卡号
        Box ubox2=Box.createHorizontalBox();
        JLabel ulabel2=new JLabel("旧密码：");
        JTextField ufield2=new JTextField(10);
        ubox2.add(ulabel2);
        ubox2.add(Box.createHorizontalStrut(10));
        ubox2.add(ufield2);
        //组装密码
        Box pbox2=Box.createHorizontalBox();
        JLabel plabel2=new JLabel("新密码：");
        JTextField pfield2=new JTextField(10);
        ubox2.add(plabel2);
        ubox2.add(Box.createHorizontalStrut(10));
        ubox2.add(pfield2);
        Box pbox1=Box.createHorizontalBox();
        JLabel plabel1=new JLabel("再次输入：");
        JTextField pfield1=new JTextField(10);
        ubox2.add(plabel1);
        ubox2.add(Box.createHorizontalStrut(10));
        ubox2.add(pfield1);

        Box btnbox2=Box.createHorizontalBox();
        JButton ok=new JButton("确认");
        JButton cancel=new JButton("取消");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                String past = ufield2.getText().trim();
                String new1 = pfield2.getText().trim();
                String new2 = pfield1.getText().trim();
                boolean flag = false;
                for (int i = 1; i < new1.length(); i++) {
                    if (new1.charAt(0) != new1.charAt(i)){
                        flag = true;
                        break;
                    }
                }
                if (new1.equals(new2) && new1.length() >= 6 && past.equals(user.getPassword()) && flag) {
                    user.setPassword(new1);
                    JOptionPane.showMessageDialog(jf2, "修改成功！！！");
                    new MainInterface().init();
                    jf2.dispose();
                } else {
                    JOptionPane.showMessageDialog(jf2, "修改失败！！！");
                }
            }
        });



        btnbox2.add(ok);
        btnbox2.add(Box.createHorizontalStrut(20));
        btnbox2.add(cancel);

        vbox2.add(Box.createVerticalStrut(40));
        vbox2.add(ubox2);
        vbox2.add(Box.createVerticalStrut(40));
        vbox2.add(pbox2);
        vbox2.add(Box.createVerticalStrut(50));
        vbox2.add(btnbox2);

        jp2.add(vbox2);
        jf2.add(jp2);
        jf2.setVisible(true);

    }
    public static void main(String[] args){
        new cpw().init();
    }
}





