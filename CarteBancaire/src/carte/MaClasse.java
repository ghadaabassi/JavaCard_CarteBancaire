package carte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import javax.swing.*;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.sun.javacard.apduio.Apdu;
import com.sun.javacard.apduio.CadT1Client;
import com.sun.javacard.apduio.CadTransportException;





public class MaClasse implements ActionListener {


    //########################################Constantes
    public static final byte CLA_MONAPP = (byte)0xB0;
    public static final byte INS_INCREMENTER_ARG = 0x00;
    public static final byte INS_DECREMENTER_ARG = 0x01;
    public static final byte INS_INTERROGER_ARG = 0x02;
    public static final byte INS_TRANSFERER_ARG = 0x03;

    JFrame Home;
    JFrame Op;
    JFrame Check;
    JFrame AddF;
    JFrame Trans;
    JFrame Extract;


    JFrame frame;
    JButton bt1;
    JButton bt2;
    JButton bt3;
    JButton bt4;
    JButton bt5;
    JLabel result;
    static CadT1Client cad;
    static Socket sckCarte;
    static Apdu apdu = new Apdu();



    //################################Home

    private javax.swing.JButton b1hom;
    private javax.swing.JPasswordField fhom;
    private javax.swing.JLabel jLabel1hom;
    private javax.swing.JLabel jLabel2hom;
    private javax.swing.JLabel jLabel3hom;
    private javax.swing.JPanel jPanel1hom;
    private javax.swing.JPanel jPanel2hom;
    private javax.swing.JPanel jPanel3hom;
    private javax.swing.JPanel jPanel4hom;
    int i = 3;


    //################################Check


    javax.swing.JButton back;
    javax.swing.JLabel check;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;


    //################################Operations

    private javax.swing.JButton addop;
    private javax.swing.JButton checkop;
    private javax.swing.JButton check2op;
    private javax.swing.JButton check3op;
    private javax.swing.JLabel jLabel1op;
    private javax.swing.JLabel jLabel2op;
    private javax.swing.JLabel jLabel3op;
    private javax.swing.JLabel jLabel4op;
    private javax.swing.JPanel jPanel1op;
    private javax.swing.JPanel jPanel2op;
    private javax.swing.JPanel jPanel3op;

    //###################################Add

    private javax.swing.JTextField addad;
    private javax.swing.JButton backad;
    private javax.swing.JLabel checkad;
    private javax.swing.JButton jButton1ad;
    private javax.swing.JLabel jLabel1ad;
    private javax.swing.JPanel jPanel1ad;
    private javax.swing.JPanel jPanel2ad;


    //###################################Transf

    private javax.swing.JTextField addtran;
    private javax.swing.JTextField add1tran;
    private javax.swing.JButton backtran;
    private javax.swing.JButton back1tran;
    private javax.swing.JButton back2tran;
    private javax.swing.JLabel checktran;
    private javax.swing.JButton jButton1tran;
    private javax.swing.JLabel jLabel1tran;
    private javax.swing.JLabel jLabel2tran;
    private javax.swing.JPanel jPanel1tran;
    private javax.swing.JPanel jPanel2tran;



    //###################################Extract

    private javax.swing.JTextField addext;
    private javax.swing.JButton back2ext;
    private javax.swing.JLabel checkext;
    private javax.swing.JButton jButton1ext;
    private javax.swing.JLabel jLabel1ext;
    private javax.swing.JPanel jPanel1ext;
    private javax.swing.JPanel jPanel2ext;


    MaClasse() {

        Home = new JFrame("welcome to your Bank Home ");
        Check = new JFrame("Check money");
        Op = new JFrame("Operations");
        AddF = new JFrame("Add");
        Trans = new JFrame("Transferer Money ");
        Extract = new JFrame("Get Money ");




        frame = new JFrame("Gerrer un compteur");
        frame.setSize(550, 380);

        JLabel label = new JLabel("Gerrer un compteur", JLabel.CENTER);
        label.setSize(350, 50);

        JLabel compt = new JLabel("Le Compteur = ");
        result = new JLabel("");


        JPanel panel = new JPanel();


        JPanel p1 = new JPanel();
        p1.setBackground(new Color(175, 200, 243));

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(175, 200, 243));
        JPanel p3 = new JPanel();
        p3.setBackground(new Color(175, 200, 243));


        bt1 = new JButton("Interroger");
        bt2 = new JButton("Incrementer");
        bt3 = new JButton("Dectrementer");
        bt4 = new JButton("Inisialiser");
        bt5 = new JButton("Quitter");



        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);




        //##########################################################################################HomeBank



        jPanel1hom = new javax.swing.JPanel();
        jPanel3hom = new javax.swing.JPanel();
        jPanel4hom = new javax.swing.JPanel();
        jLabel3hom = new javax.swing.JLabel();
        jLabel1hom = new javax.swing.JLabel();
        jLabel2hom = new javax.swing.JLabel();
        fhom = new javax.swing.JPasswordField();
        jPanel2hom = new javax.swing.JPanel();
        b1hom = new javax.swing.JButton();



        Home.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1hom.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1hom.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3hom.setBackground(new java.awt.Color(252, 243, 207));

        jPanel4hom.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3hom.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3hom.setText("Welcome to your Bank ");

        jLabel1hom.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\acceuil.png"));

        jLabel2hom.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2hom.setText("Tap the cart's code here :");

        fhom.setText("jPasswordField1");

        jPanel2hom.setBackground(new java.awt.Color(214, 234, 248));

        b1hom.setBackground(new java.awt.Color(252, 243, 207));
        b1hom.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18));
        b1hom.setText("Tap here");
        b1hom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layouthom = new javax.swing.GroupLayout(jPanel2hom);
        jPanel2hom.setLayout(jPanel2Layouthom);
        jPanel2Layouthom.setHorizontalGroup(
            jPanel2Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layouthom.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(b1hom, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layouthom.setVerticalGroup(
            jPanel2Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layouthom.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(b1hom, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layouthom = new javax.swing.GroupLayout(jPanel4hom);
        jPanel4hom.setLayout(jPanel4Layouthom);
        jPanel4Layouthom.setHorizontalGroup(
            jPanel4Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2hom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layouthom.createSequentialGroup()
                .addGroup(jPanel4Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layouthom.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel4Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2hom, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3hom, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fhom, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layouthom.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1hom)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layouthom.setVerticalGroup(
            jPanel4Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layouthom.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3hom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1hom, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2hom)
                .addGap(28, 28, 28)
                .addComponent(fhom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2hom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layouthom = new javax.swing.GroupLayout(jPanel3hom);
        jPanel3hom.setLayout(jPanel3Layouthom);
        jPanel3Layouthom.setHorizontalGroup(
            jPanel3Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layouthom.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layouthom.setVerticalGroup(
            jPanel3Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layouthom.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layouthom = new javax.swing.GroupLayout(jPanel1hom);
        jPanel1hom.setLayout(jPanel1Layouthom);
        jPanel1Layouthom.setHorizontalGroup(
            jPanel1Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layouthom.setVerticalGroup(
            jPanel1Layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layouthom = new javax.swing.GroupLayout(Home.getContentPane());
        Home.getContentPane().setLayout(layouthom);
        layouthom.setHorizontalGroup(
            layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layouthom.setVerticalGroup(
            layouthom.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1hom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Home.pack();


        //#######################################################################################Operations


        jPanel1op = new javax.swing.JPanel();
        jPanel2op = new javax.swing.JPanel();
        jPanel3op = new javax.swing.JPanel();
        checkop = new javax.swing.JButton();
        addop = new javax.swing.JButton();
        check2op = new javax.swing.JButton();
        check3op = new javax.swing.JButton();
        jLabel2op = new javax.swing.JLabel();
        jLabel3op = new javax.swing.JLabel();
        jLabel1op = new javax.swing.JLabel();
        jLabel4op = new javax.swing.JLabel();

        Op.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1op.setBackground(new java.awt.Color(214, 234, 248));

        jPanel2op.setBackground(new java.awt.Color(252, 243, 207));

        jPanel3op.setBackground(new java.awt.Color(214, 234, 248));

        checkop.setBackground(new java.awt.Color(252, 243, 207));
        checkop.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13));
        checkop.setText("Check Money");


        addop.setBackground(new java.awt.Color(252, 243, 207));
        addop.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13));
        addop.setText("Deposit Money");


        check2op.setBackground(new java.awt.Color(252, 243, 207));
        check2op.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13));
        check2op.setText("Withdraw Money");

        check3op.setBackground(new java.awt.Color(252, 243, 207));
        check3op.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13));
        check3op.setText("Transfer Money");

        jLabel2op.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\send.png"));

        jLabel3op.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\trans.png"));

        jLabel1op.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\check.png"));

        jLabel4op.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\save.png"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3op);
        jPanel3op.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2op, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check2op, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1op, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check3op, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3op)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4op, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1op, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkop, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addop, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2op, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3op))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check2op, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check3op, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2op);
        jPanel2op.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layoutop = new javax.swing.GroupLayout(jPanel1op);
        jPanel1op.setLayout(jPanel1Layoutop);
        jPanel1Layoutop.setHorizontalGroup(
            jPanel1Layoutop.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layoutop.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layoutop.setVerticalGroup(
            jPanel1Layoutop.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutop.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layoutop = new javax.swing.GroupLayout(Op.getContentPane());
        Op.getContentPane().setLayout(layoutop);
        layoutop.setHorizontalGroup(
            layoutop.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutop.setVerticalGroup(
            layoutop.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Op.pack();



        //#######################################################################################CHECK

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        check = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        Check.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 234, 248));

        jPanel2.setBackground(new java.awt.Color(252, 243, 207));

        jLabel1.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\card.png"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("You have :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("$");

        back.setBackground(new java.awt.Color(252, 243, 207));
        back.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\bck.png"));



        javax.swing.GroupLayout jPanel2Layoutck = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layoutck);
        jPanel2Layoutck.setHorizontalGroup(
            jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutck.createSequentialGroup()
                .addGroup(jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutck.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layoutck.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layoutck.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        jPanel2Layoutck.setVerticalGroup(
            jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutck.createSequentialGroup()
                .addGroup(jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutck.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutck.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layoutck = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layoutck);
        jPanel1Layoutck.setHorizontalGroup(
            jPanel1Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutck.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layoutck.setVerticalGroup(
            jPanel1Layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutck.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layoutck = new javax.swing.GroupLayout(Check.getContentPane());
        Check.getContentPane().setLayout(layoutck);
        layoutck.setHorizontalGroup(
            layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutck.setVerticalGroup(
            layoutck.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Check.pack();


        //###########################################################################Add


        jPanel1ad = new javax.swing.JPanel();
        jPanel2ad = new javax.swing.JPanel();
        jLabel1ad = new javax.swing.JLabel();
        checkad = new javax.swing.JLabel();
        addad = new javax.swing.JTextField();
        jButton1ad = new javax.swing.JButton();
        backad = new javax.swing.JButton();


        AddF.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1ad.setBackground(new java.awt.Color(214, 234, 248));

        jPanel2ad.setBackground(new java.awt.Color(252, 243, 207));

        jLabel1ad.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\card.png"));


        jButton1ad.setBackground(new java.awt.Color(214, 234, 248));
        jButton1ad.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton1ad.setText("Deposit");

        backad.setBackground(new java.awt.Color(252, 243, 207));

        backad.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\bck.png"));


        javax.swing.GroupLayout jPanel2Layoutad = new javax.swing.GroupLayout(jPanel2ad);
        jPanel2ad.setLayout(jPanel2Layoutad);
        jPanel2Layoutad.setHorizontalGroup(
            jPanel2Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutad.createSequentialGroup()
                .addGroup(jPanel2Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(checkad, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1ad))
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(addad, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jButton1ad, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel2Layoutad.setVerticalGroup(
            jPanel2Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutad.createSequentialGroup()
                .addGroup(jPanel2Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1ad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutad.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(addad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1ad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layoutad = new javax.swing.GroupLayout(jPanel1ad);
        jPanel1ad.setLayout(jPanel1Layoutad);
        jPanel1Layoutad.setHorizontalGroup(
            jPanel1Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutad.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layoutad.setVerticalGroup(
            jPanel1Layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutad.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layoutad = new javax.swing.GroupLayout(AddF.getContentPane());
        AddF.getContentPane().setLayout(layoutad);
        layoutad.setHorizontalGroup(
            layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutad.setVerticalGroup(
            layoutad.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AddF.pack();

        //###########################################################################Transf
        jPanel1tran = new javax.swing.JPanel();
        jPanel2tran = new javax.swing.JPanel();
        jLabel1tran = new javax.swing.JLabel();
        checktran = new javax.swing.JLabel();
        addtran = new javax.swing.JTextField();
        jButton1tran = new javax.swing.JButton();
        jLabel2tran = new javax.swing.JLabel();
        add1tran = new javax.swing.JTextField();
        back2tran = new javax.swing.JButton();

        Trans.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1tran.setBackground(new java.awt.Color(214, 234, 248));

        jPanel2tran.setBackground(new java.awt.Color(252, 243, 207));

        jLabel1tran.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\card.png"));


        jButton1tran.setBackground(new java.awt.Color(214, 234, 248));
        jButton1tran.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton1tran.setText("Send");


        jLabel2tran.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2tran.setText("To:");

        back2tran.setBackground(new java.awt.Color(252, 243, 207));
        back2tran.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\bck.png"));


        javax.swing.GroupLayout jPanel2Layouttran = new javax.swing.GroupLayout(jPanel2tran);
        jPanel2tran.setLayout(jPanel2Layouttran);
        jPanel2Layouttran.setHorizontalGroup(
            jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layouttran.createSequentialGroup()
                .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addtran, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layouttran.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back2tran, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(jLabel1tran))
                            .addGroup(jPanel2Layouttran.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel2tran, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checktran, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layouttran.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(add1tran, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton1tran, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layouttran.setVerticalGroup(
            jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layouttran.createSequentialGroup()
                .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layouttran.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1tran, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layouttran.createSequentialGroup()
                        .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layouttran.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1tran, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layouttran.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back2tran, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addComponent(addtran, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checktran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layouttran.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2tran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add1tran, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layouttran = new javax.swing.GroupLayout(jPanel1tran);
        jPanel1tran.setLayout(jPanel1Layouttran);
        jPanel1Layouttran.setHorizontalGroup(
            jPanel1Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layouttran.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2tran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layouttran.setVerticalGroup(
            jPanel1Layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layouttran.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2tran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layouttran = new javax.swing.GroupLayout(Trans.getContentPane());
        Trans.getContentPane().setLayout(layouttran);
        layouttran.setHorizontalGroup(
            layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1tran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layouttran.setVerticalGroup(
            layouttran.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1tran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Trans.pack();



        //#####################################################################Withdraw


        jPanel1ext = new javax.swing.JPanel();
        jPanel2ext = new javax.swing.JPanel();
        jLabel1ext = new javax.swing.JLabel();

        checkext = new javax.swing.JLabel();
        addext = new javax.swing.JTextField();
        jButton1ext = new javax.swing.JButton();
        back2ext = new javax.swing.JButton();

        Extract.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1ext.setBackground(new java.awt.Color(214, 234, 248));

        jPanel2ext.setBackground(new java.awt.Color(252, 243, 207));

        jLabel1ext.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\card.png"));



        jButton1ext.setBackground(new java.awt.Color(214, 234, 248));
        jButton1ext.setFont(new java.awt.Font("Segoe UI", 1, 18));

        jButton1ext.setText("Withdraw");



        back2ext.setBackground(new java.awt.Color(252, 243, 207));
        back2ext.setIcon(new javax.swing.ImageIcon("JavaCardProjectIcons\\bck.png"));


        javax.swing.GroupLayout jPanel2Layoutext = new javax.swing.GroupLayout(jPanel2ext);
        jPanel2ext.setLayout(jPanel2Layoutext);
        jPanel2Layoutext.setHorizontalGroup(
            jPanel2Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutext.createSequentialGroup()
                .addGroup(jPanel2Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutext.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkext, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layoutext.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(addext, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layoutext.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jButton1ext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutext.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back2ext, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1ext)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel2Layoutext.setVerticalGroup(
            jPanel2Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layoutext.createSequentialGroup()
                .addGroup(jPanel2Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layoutext.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1ext, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layoutext.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back2ext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(addext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkext, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1ext, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layoutext = new javax.swing.GroupLayout(jPanel1ext);
        jPanel1ext.setLayout(jPanel1Layoutext);
        jPanel1Layoutext.setHorizontalGroup(
            jPanel1Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutext.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layoutext.setVerticalGroup(
            jPanel1Layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layoutext.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2ext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layoutext = new javax.swing.GroupLayout(Extract.getContentPane());
        Extract.getContentPane().setLayout(layoutext);
        layoutext.setHorizontalGroup(
            layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1ext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layoutext.setVerticalGroup(
            layoutext.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1ext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Extract.pack();

        //########################################AddActionListener

        addop.addActionListener(this);
        checkop.addActionListener(this);
        back.addActionListener(this);
        backad.addActionListener(this);
        jButton1ad.addActionListener(this);
        b1hom.addActionListener(this);
        back2tran.addActionListener(this);
        bt3.addActionListener(this);
        jButton1ext.addActionListener(this);
        check2op.addActionListener(this);
        check3op.addActionListener(this);
        jButton1ext.addActionListener(this);
        jButton1tran.addActionListener(this);
        back2tran.addActionListener(this);
        back2ext.addActionListener(this);


        fhom.setText("");
        Home.setVisible(true);

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MaClasse c = new MaClasse();

        try {

            sckCarte = new Socket("localhost", 9025);
            sckCarte.setTcpNoDelay(true);
            BufferedInputStream input = new
                BufferedInputStream(sckCarte.getInputStream());
            BufferedOutputStream output = new
                BufferedOutputStream(sckCarte.getOutputStream());
            cad = new CadT1Client(input, output);
        }
        catch (Exception e1) {
            System.out.println("Erreur : impossible de se connecter a la Javacard");
            return;
        }
        /* Mise sous tension de la carte */
        try {
            cad.powerUp();
        }
        catch (Exception e1) {

            System.out.println("Erreur lors de l'envoi de la commande Powerup a la Javacard");
            return;
        }


        apdu.command[Apdu.CLA] = 0x00;
        apdu.command[Apdu.INS] = (byte)0xA4;
        apdu.command[Apdu.P1] = 0x04;
        apdu.command[Apdu.P2] = 0x00;
        byte[] appletAID = { 0x19,0x34,0x12,0x34,0x56,0x10,0x00,0x01 };
        apdu = new Apdu();
        apdu.command[Apdu.CLA] = MaClasse.CLA_MONAPP;
        apdu.command[Apdu.P1] = 0x00;
        apdu.command[Apdu.P2] = 0x00;
        apdu.setLe(0x7f);
        apdu.setDataIn(appletAID);


        try {
            cad.exchangeApdu(apdu);
        }
        catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        catch (CadTransportException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        if (apdu.getStatus() != 0x9000) {
            System.out.println("Erreur lors de la sélection de l'applet");
            System.exit(1);
        }

    }



    @Override
        public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub


    // Connection à la carte	
        if (e.getSource() == b1hom) {

            String t = fhom.getText();
            i--;
            // Vérification de mot de passe de la carte
            if (t.equals("12345") && i > 0) {
                Op.setVisible(true);
                Home.setVisible(false);


            }
            else if (i > 0) {
                JOptionPane.showMessageDialog(Home, "Code invalide !");
                fhom.setText("");

            }
            else {


                JOptionPane.showMessageDialog(Home, "Le nombre de tentatives autorisée est dépassé !");
                Home.setVisible(false);
            }

        }

        //check Money
        if (e.getSource() == checkop) {

            apdu.command[Apdu.INS] =
                MaClasse.INS_INTERROGER_ARG;
            try {
                cad.exchangeApdu(apdu);
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            catch (CadTransportException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (apdu.getStatus() != 0x9000) {
                System.out.println("Erreur : status word different de 0x9000");
            }
            else {

                Check.setVisible(true);
                Op.setVisible(false);
                check.setText("                                        " + apdu.dataOut[0]);

            }
        }


        //Transfer
        if (e.getSource() == jButton1tran) {

            String t = addtran.getText();
            int a = Integer.parseInt(t.toString());

            byte b = (byte)a;

            String dist = add1tran.getText();

            // Les codes des cartes pour lesquelles le transfert est autorisé

            if (dist.equals("0000") || dist.equals("5555") || dist.equals("1220") || dist.equals("3120")) {

                apdu.command[Apdu.INS] =
                    MaClasse.INS_TRANSFERER_ARG;
                byte[] donnees = new byte[1];
                donnees[0] = b;
                apdu.setDataIn(donnees);

                try {
                    cad.exchangeApdu(apdu);
                }
                catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                catch (CadTransportException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if (apdu.getStatus() != 0x9000) {
                    System.out.println("Erreur : status word different de 0x9000");
                }
                else {

                    JOptionPane.showMessageDialog(Trans, "Opération Terminée avec Succès");

                    addtran.setText("");
                    add1tran.setText("");
                }
            }
            else {
                addtran.setText("");
                add1tran.setText("");
                JOptionPane.showMessageDialog(Trans, "Vérifier numéro de la carte");
            }
        }


        // Deposit
        if (e.getSource() == jButton1ad) {

            String t = addad.getText();
            int a = Integer.parseInt(t.toString());

            byte b = (byte)a;

            apdu.command[Apdu.INS] =
                MaClasse.INS_INCREMENTER_ARG;
            byte[] donnees = new byte[1];
            donnees[0] = b;
            apdu.setDataIn(donnees);
            try {
                cad.exchangeApdu(apdu);
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            catch (CadTransportException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (apdu.getStatus() != 0x9000) {
                System.out.println("Erreur : status word different de 0x9000");
            }
            else {

                addad.setText("");
                JOptionPane.showMessageDialog(AddF, "Opération Terminée avec Succès");

            }
        }

        //Withdraw
        if (e.getSource() == jButton1ext) {

            String t = addext.getText();
            int a = Integer.parseInt(t.toString());

            byte b = (byte)a;

            apdu.command[Apdu.INS] =
                MaClasse.INS_DECREMENTER_ARG;
            byte[] donnees = new byte[1];
            donnees[0] = b;
            apdu.setDataIn(donnees);

            try {
                cad.exchangeApdu(apdu);
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            catch (CadTransportException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (apdu.getStatus() != 0x9000) {
                System.out.println("Erreur : status word different de 0x9000");
            }
            else {

                addext.setText("");
                JOptionPane.showMessageDialog(AddF, "Opération Terminée avec Succès");

            }
        }


        if (e.getSource() == back) {
            Check.setVisible(false);
            Op.setVisible(true);
        }

        if (e.getSource() == back2tran) {

            Trans.setVisible(false);
            Op.setVisible(true);
        }

        if (e.getSource() == back2ext) {

            Extract.setVisible(false);
            Op.setVisible(true);
        }



        if (e.getSource() == backad) {
            AddF.setVisible(false);
            Op.setVisible(true);

        }


        if (e.getSource() == addop) {

            AddF.setVisible(true);
            Op.setVisible(false);
        }


        if (e.getSource() == check2op) {

            Extract.setVisible(true);
            Op.setVisible(false);
        }


        if (e.getSource() == check3op) {

            Trans.setVisible(true);
            Op.setVisible(false);
        }


    }
}
