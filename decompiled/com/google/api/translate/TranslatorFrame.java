/*
 * Decompiled with CFR 0.152.
 */
package com.google.api.translate;

import com.google.api.Files;
import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TranslatorFrame
extends JFrame {
    private static final long serialVersionUID = 7916697355146649532L;
    private static final String REFERRER_PATH = System.getProperty("user.home") + System.getProperty("file.separator") + ".gtReferrer";
    private static final String API_KEY_PATH = System.getProperty("user.home") + System.getProperty("file.separator") + ".google-translate-api.key";
    private Translate translate;
    private Language languageFrom = Language.FRENCH;
    private Language languageTo = Language.ENGLISH;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JTextArea fromTextArea;
    private JMenu jMenu1;
    private JMenu jMenuFrom;
    private JMenu jMenuTo;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea toTextArea;

    public TranslatorFrame() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.translate = Translate.DEFAULT;
        File file = new File(API_KEY_PATH);
        if (file.exists()) {
            GoogleAPI.setKey(Files.read(file));
        }
        String string = null;
        File file2 = new File(REFERRER_PATH);
        if (file2.exists()) {
            string = Files.read(file2).trim();
        } else {
            string = JOptionPane.showInputDialog(this, "Please enter the address of your website.\n(This is just to help Google identify how their translation tools are used).", "Website address", 0);
            Files.write(file2, string);
        }
        if (string.length() > 0) {
            GoogleAPI.setHttpReferrer(string);
        } else {
            System.exit(1);
        }
    }

    private void translate() {
        try {
            this.toTextArea.setText(this.translate.execute(this.fromTextArea.getText().trim(), this.languageFrom, this.languageTo));
        }
        catch (Exception exception) {
            Logger.getLogger(TranslatorFrame.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.fromTextArea = new JTextArea();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.toTextArea = new JTextArea();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuTo = new JMenu();
        this.jMenuFrom = new JMenu();
        this.setDefaultCloseOperation(3);
        this.setTitle("Translator");
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 3));
        this.fromTextArea.setColumns(20);
        this.fromTextArea.setLineWrap(true);
        this.fromTextArea.setRows(5);
        this.fromTextArea.setWrapStyleWord(true);
        this.fromTextArea.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                TranslatorFrame.this.fromTextAreaKeyPressed(keyEvent);
            }
        });
        this.jScrollPane1.setViewportView(this.fromTextArea);
        GroupLayout groupLayout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 309, Short.MAX_VALUE).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 93, Short.MAX_VALUE).addContainerGap()));
        this.getContentPane().add(this.jPanel2);
        this.toTextArea.setColumns(20);
        this.toTextArea.setEditable(false);
        this.toTextArea.setLineWrap(true);
        this.toTextArea.setRows(5);
        this.toTextArea.setWrapStyleWord(true);
        this.jScrollPane2.setViewportView(this.toTextArea);
        GroupLayout groupLayout2 = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 309, Short.MAX_VALUE).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 93, Short.MAX_VALUE).addContainerGap()));
        this.getContentPane().add(this.jPanel3);
        this.jMenu1.setText("File");
        this.jMenuItem1.setText("Exit");
        this.jMenuItem1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TranslatorFrame.this.jMenuItem1ActionPerformed(actionEvent);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenuFrom.setText("From");
        this.jMenuTo.setText("To");
        for (final Language language : Language.values()) {
            JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem();
            jRadioButtonMenuItem.setText(language.name());
            if (language.equals((Object)this.languageFrom)) {
                jRadioButtonMenuItem.setSelected(true);
            }
            jRadioButtonMenuItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    TranslatorFrame.this.languageFrom = language;
                }
            });
            this.buttonGroup1.add(jRadioButtonMenuItem);
            this.jMenuFrom.add(jRadioButtonMenuItem);
            if (language == Language.AUTO_DETECT) continue;
            jRadioButtonMenuItem = new JRadioButtonMenuItem();
            jRadioButtonMenuItem.setText(language.name());
            if (language.equals((Object)this.languageTo)) {
                jRadioButtonMenuItem.setSelected(true);
            }
            jRadioButtonMenuItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    TranslatorFrame.this.languageTo = language;
                }
            });
            this.buttonGroup2.add(jRadioButtonMenuItem);
            this.jMenuTo.add(jRadioButtonMenuItem);
        }
        this.jMenuBar1.add(this.jMenuFrom);
        this.jMenuBar1.add(this.jMenuTo);
        this.setJMenuBar(this.jMenuBar1);
        this.pack();
    }

    private void jMenuItem1ActionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void fromTextAreaKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 10) {
            this.translate();
            keyEvent.consume();
        }
    }

    public static void main(String[] stringArray) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    new TranslatorFrame().setVisible(true);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        });
    }
}

