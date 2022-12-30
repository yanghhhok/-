package ATMDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import ATMDemo.cpw;

public class MainInterface {
    JFrame jf=new JFrame("登陆界面");
    final int WIDTH=500;
    final int HEIGHT=300;
    //组装视图
    public void init(){
        //设置窗口相关的属性
        jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        jf.setResizable(false);
        //设置窗口内容
        JPanel jp=new JPanel();
        //设置登陆相关元素
        Box vbox=Box.createVerticalBox();
         //组装卡号
        Box ubox=Box.createHorizontalBox();
        JLabel ulabel=new JLabel("卡号：");
        JTextField ufield=new JTextField(15);
        ubox.add(ulabel);
        ubox.add(Box.createHorizontalStrut(20));
        ubox.add(ufield);
        //组装密码
        Box pbox=Box.createHorizontalBox();
        JLabel plabel=new JLabel("密码：");
        JTextField pfield=new JTextField(15);
        ubox.add(plabel);
        ubox.add(Box.createHorizontalStrut(20));
        ubox.add(pfield);
        Box btnbox=Box.createHorizontalBox();
        JButton logintbn=new JButton("登  录");
        JButton cpw=new JButton("修改密码");

        logintbn.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                           //获取用户输入的数据
                                           String card = ufield.getText().trim();
                                           String password = pfield.getText().trim();
                                           User user = new User();
                                           String cd= user.getIdcard();
                                            String pw = user.getPassword();




                                           if (card.equals(cd) && password.equals(pw)) {
                                               JOptionPane.showMessageDialog(jf, "登陆成功！！！");
                                               jf.setVisible(false);


                                               int sum = 10000;
                                               Scanner sc = new Scanner(System.in);
                                               int b=0;
                                               do {
                                                   while(true) {
                                                       System.out.println("查询余额请按0，存款请按1，取款请按2");
                                                       int n5 = sc.nextInt();
                                                       int n6;
                                                       if(n5==0){
                                                           System.out.println("当前余额为："+sum+"，是否继续服务’是‘请按‘1’，’否‘请按‘2’。");
                                                           int c= sc.nextInt();
                                                           if(c==1){
                                                               continue;
                                                           }
                                                           if(c==2){
                                                               System.out.println("服务结束！");
                                                               break;
                                                           }
                                                       }
                                                       if (n5 == 2) {
                                                           System.out.println("输入取款金额：");
                                                           n6 = sc.nextInt();
                                                           if (sum >= n6 && n6 % 100 == 0 && n6 <= 5000) {
                                                               sum -= n6;
                                                               System.out.println("剩余金额：" + sum + "，是否继续（'1'：结束，'2'：继续）：");
                                                               b = sc.nextInt();
                                                               break;
                                                           }

                                                           System.out.println("目前余额：" + sum + "无法满足您的取款需求！");
                                                       }

                                                       if (n5 == 1) {
                                                           System.out.println("请输入存款金额");
                                                           n6 = sc.nextInt();
                                                           if (n6 > 0) {
                                                               sum += n6;
                                                               System.out.println("当前余额为" + sum+"，是否继续服务‘是’请按‘1’，‘否’请按‘2‘");
                                                               int c= sc.nextInt();
                                                               if(c==1){
                                                                   continue;
                                                               }
                                                               if(c==2){
                                                                   System.out.println("服务结束！");
                                                                   break;
                                                               }
                                                           } else {
                                                               System.out.println("当前存款金额不符合规定");
                                                           }
                                                       }

                                                   }
                                               } while(b == 2);

                                               if (b == 1) {
                                                   System.out.println("取款结束！");
                                               }
                                           } else {
                                               JOptionPane.showMessageDialog(jf, "登陆失败！！！");
                                               return;
                                           }

                                       }
                                   });
        cpw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cpw().init();
                jf.dispose();
            }
        });

        btnbox.add(logintbn);
        btnbox.add(Box.createHorizontalStrut(20));
        btnbox.add(cpw);

        vbox.add(Box.createVerticalStrut(40));
        vbox.add(ubox);
        vbox.add(Box.createVerticalStrut(40));
        vbox.add(pbox);
        vbox.add(Box.createVerticalStrut(50));
        vbox.add(btnbox);

        jp.add(vbox);
        jf.add(jp);
        jf.pack();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
//客户端程序的入口
    public static void main(String[] args){
        new MainInterface().init();
    }
}
