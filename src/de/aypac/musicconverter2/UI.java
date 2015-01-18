package de.aypac.musicconverter2;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class UI
        extends JFrame {

    private Filter[] filter = new Filter[1];
    static JTreeWalk converter;
    final String FIRST_STEPS_URL = "first_steps.html";
    final String TIPS_URL = "tips.html";
    private JDialog FilterSettings;
    private JMenu Information6;
    private JButton add;
    private JLabel buttonLabel;
    private JButton checkForUpdates;
    private JLabel checkedFiles;
    private JButton delete;
    private JDialog dirSelect;
    private JDialog disabled;
    private JButton down;
    private JButton edit;
    private JMenu file6;
    private JDialog filtermanager;
    private JTextField filtername;
    private JMenuItem info6;
    private JDialog information;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JList jList1;
    private JList jList2;
    private JMenuBar jMenuBar6;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JMenuItem load6;
    private JTextField path;
    private JTextField replace;
    private JTextField replace_by;
    private JButton start;
    private JButton submit;
    private JButton submitPath;
    private JMenu tips6;
    private JMenuItem tips_tricks;
    private JMenuItem tut;
    private JButton up;
    private JMenuItem update;
    private String VERSION = "3.0b";
    final String CHECK_FOR_UPDATE_URL = "http://aypac.de/musicconverter2.0/update.php?v=" + VERSION;

    public UI() {
        initComponents();
        this.filter[0] = new Filter("_", " ");
        this.jList1.setModel(lib.filterToModel(this.filter));
        this.jList1.setSelectedIndex(0);
    }

    private void initComponents() {
        this.FilterSettings = new JDialog();
        this.replace = new JTextField();
        this.replace_by = new JTextField();
        this.submit = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel16 = new JLabel();
        this.dirSelect = new JDialog();
        this.submitPath = new JButton();
        this.path = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.information = new JDialog();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jLabel10 = new JLabel();
        this.disabled = new JDialog();
        this.jLabel11 = new JLabel();
        this.jButton1 = new JButton();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.checkForUpdates = new JButton();
        this.filtermanager = new JDialog();
        this.jLabel14 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.jList2 = new JList();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.filtername = new JTextField();
        this.jButton4 = new JButton();
        this.jLabel15 = new JLabel();
        this.jButton5 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jList1 = new JList();
        this.down = new JButton();
        this.up = new JButton();
        this.add = new JButton();
        this.delete = new JButton();
        this.buttonLabel = new JLabel();
        this.edit = new JButton();
        this.checkedFiles = new JLabel();
        this.start = new JButton();
        this.jProgressBar1 = new JProgressBar();
        this.jMenuBar6 = new JMenuBar();
        this.file6 = new JMenu();
        this.load6 = new JMenuItem();
        this.tips6 = new JMenu();
        this.tut = new JMenuItem();
        this.tips_tricks = new JMenuItem();
        this.Information6 = new JMenu();
        this.info6 = new JMenuItem();
        this.update = new JMenuItem();

        this.FilterSettings.setTitle("Edit Filter");
        this.FilterSettings.setAlwaysOnTop(true);
        this.FilterSettings.setMinimumSize(new Dimension(400, 140));
        this.FilterSettings.setResizable(false);

        this.replace_by.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.replace_byActionPerformed(evt);
            }
        });
        this.submit.setText("- - - -  Submit - - - - -");
        this.submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.submitActionPerformed(evt);
            }
        });
        this.jLabel1.setText("With:");

        this.jLabel2.setText("Replace:");

        this.jLabel16.setFont(new Font("Tahoma", 1, 14));
        this.jLabel16.setText("New Filter");

        GroupLayout FilterSettingsLayout = new GroupLayout(this.FilterSettings.getContentPane());
        this.FilterSettings.getContentPane().setLayout(FilterSettingsLayout);
        FilterSettingsLayout.setHorizontalGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(FilterSettingsLayout.createSequentialGroup().addGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, FilterSettingsLayout.createSequentialGroup().addContainerGap(175, 32767).addComponent(this.submit)).addComponent(this.jLabel16).addGroup(FilterSettingsLayout.createSequentialGroup().addContainerGap().addGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.replace_by, -1, 250, 32767).addComponent(this.replace, -1, 250, 32767)))).addContainerGap()));

        FilterSettingsLayout.setVerticalGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, FilterSettingsLayout.createSequentialGroup().addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.replace, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(FilterSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.replace_by, -2, -1, -2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.submit)));

        this.submitPath.setText("SELECT");
        this.submitPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.submitPathActionPerformed(evt);
            }
        });
        this.path.setText("C:/");
        this.path.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent evt) {
                UI.this.pathCaretUpdate(evt);
            }
        });
        this.path.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.pathActionPerformed(evt);
            }
        });
        this.path.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                UI.this.pathPropertyChange(evt);
            }
        });
        this.jLabel3.setText("Path:");

        this.jLabel4.setText("<html><font color=\"#00FF00\">OKAY</font></html>");

        this.jCheckBox1.setText("Ignore Write Protection");

        GroupLayout dirSelectLayout = new GroupLayout(this.dirSelect.getContentPane());
        this.dirSelect.getContentPane().setLayout(dirSelectLayout);
        dirSelectLayout.setHorizontalGroup(dirSelectLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(dirSelectLayout.createSequentialGroup().addGroup(dirSelectLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(dirSelectLayout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jCheckBox1)).addComponent(this.path, -2, 506, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.submitPath, -1, 73, 32767).addContainerGap()));

        dirSelectLayout.setVerticalGroup(dirSelectLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(dirSelectLayout.createSequentialGroup().addGroup(dirSelectLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.path, -2, -1, -2).addComponent(this.submitPath)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(dirSelectLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4, -2, -1, -2).addComponent(this.jCheckBox1)).addContainerGap(8, 32767)));

        this.information.setDefaultCloseOperation(0);
        this.information.setTitle("Information");
        this.information.setAlwaysOnTop(true);
        this.information.setBounds(new Rectangle(50, 50, 400, 200));
        this.information.setCursor(new Cursor(0));
        this.information.setIconImage(null);
        this.information.setMinimumSize(new Dimension(400, 200));
        this.information.setResizable(false);
        this.information.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                UI.this.informationMouseClicked(evt);
            }
        });
        this.information.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                UI.this.informationKeyTyped(evt);
            }
        });
        this.jLabel5.setText("Version 2.0 beta");

        this.jLabel6.setText("Music Converter");

        this.jLabel7.setText("By René Vollmer");

        this.jLabel8.setText("Visit Aypac.de for further Information and updates.");

        this.jLabel9.setText("Type Any Key To Close...");

        this.jLabel10.setText("                  ...or press any key...");

        GroupLayout informationLayout = new GroupLayout(this.information.getContentPane());
        this.information.getContentPane().setLayout(informationLayout);
        informationLayout.setHorizontalGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(informationLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(informationLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(informationLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(informationLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel8)).addComponent(this.jLabel7)))).addContainerGap(56, 32767)))).addGroup(informationLayout.createSequentialGroup().addContainerGap().addComponent(this.jSeparator1, -1, 337, 32767).addContainerGap()).addGroup(informationLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel9).addContainerGap(224, 32767)).addGroup(informationLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel10).addContainerGap(189, 32767)));

        informationLayout.setVerticalGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(informationLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 4, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addContainerGap(40, 32767)));

        this.disabled.setTitle("Function Disabled In This Version");
        this.disabled.setAlwaysOnTop(true);
        this.disabled.setMinimumSize(new Dimension(300, 160));

        this.jLabel11.setText("This function is not working in This version.");

        this.jButton1.setText("OK");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel12.setText("It will be available in the next Version.");

        this.jLabel13.setText("Check http://Aypac.de for Updates.");

        this.checkForUpdates.setText("Check for updates");
        this.checkForUpdates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.checkForUpdatesActionPerformed(evt);
            }
        });
        GroupLayout disabledLayout = new GroupLayout(this.disabled.getContentPane());
        this.disabled.getContentPane().setLayout(disabledLayout);
        disabledLayout.setHorizontalGroup(disabledLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(disabledLayout.createSequentialGroup().addContainerGap().addGroup(disabledLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(disabledLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(disabledLayout.createSequentialGroup().addComponent(this.jLabel11).addContainerGap(16, 32767)).addGroup(disabledLayout.createSequentialGroup().addComponent(this.jLabel12).addContainerGap(39, 32767)).addGroup(GroupLayout.Alignment.TRAILING, disabledLayout.createSequentialGroup().addComponent(this.checkForUpdates).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, 32767).addComponent(this.jButton1).addContainerGap())).addGroup(GroupLayout.Alignment.TRAILING, disabledLayout.createSequentialGroup().addComponent(this.jLabel13).addGap(27, 27, 27)))));

        disabledLayout.setVerticalGroup(disabledLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(disabledLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(disabledLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.checkForUpdates))));

        this.filtermanager.setTitle("Filtermanager");
        this.filtermanager.setAlwaysOnTop(true);
        this.filtermanager.setMinimumSize(new Dimension(384, 210));

        this.jLabel14.setFont(new Font("Tahoma", 1, 14));
        this.jLabel14.setText("Filtermanager");

        this.jScrollPane2.setViewportView(this.jList2);

        this.jButton2.setText("Load Selected");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setText("Close");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.jButton3ActionPerformed(evt);
            }
        });
        this.filtername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.filternameActionPerformed(evt);
            }
        });
        this.jButton4.setText("Save");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.jButton4ActionPerformed(evt);
            }
        });
        this.jLabel15.setText("Save current filters. Name:");

        this.jButton5.setText("Load File");
        this.jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.jButton5ActionPerformed(evt);
            }
        });
        GroupLayout filtermanagerLayout = new GroupLayout(this.filtermanager.getContentPane());
        this.filtermanager.getContentPane().setLayout(filtermanagerLayout);
        filtermanagerLayout.setHorizontalGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(filtermanagerLayout.createSequentialGroup().addGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(filtermanagerLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 165, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton2, -1, -1, 32767).addComponent(this.jButton5, -1, -1, 32767).addGroup(filtermanagerLayout.createSequentialGroup().addGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(filtermanagerLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.filtername)).addComponent(this.jLabel15)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4)))).addComponent(this.jLabel14)).addContainerGap()).addComponent(this.jButton3, -1, 384, 32767));

        filtermanagerLayout.setVerticalGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(filtermanagerLayout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, filtermanagerLayout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(filtermanagerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.filtername, -2, -1, -2).addComponent(this.jButton4))).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -2, 118, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton3)));

        setDefaultCloseOperation(3);
        setTitle("Name Converter " + this.VERSION + "- By René Vollmer");

        this.jList1.setToolTipText("Processlist");
        this.jScrollPane1.setViewportView(this.jList1);

        this.down.setText("\\/");
        this.down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.downActionPerformed(evt);
            }
        });
        this.up.setText("/\\");
        this.up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.upActionPerformed(evt);
            }
        });
        this.add.setText("Add");
        this.add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.addActionPerformed(evt);
            }
        });
        this.delete.setText("Delete");
        this.delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.deleteActionPerformed(evt);
            }
        });
        this.buttonLabel.setText("Current Filter");

        this.edit.setText("Edit");
        this.edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.editActionPerformed(evt);
            }
        });
        this.checkedFiles.setText("Hello!");

        this.start.setText("Start");
        this.start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.starttActionPerformed(evt);
            }
        });
        this.file6.setText("File");
        this.file6.setActionCommand("Datei");

        this.load6.setAccelerator(KeyStroke.getKeyStroke(77, 2));
        this.load6.setText("<html>Filter<u>m</u>anager</html>");
        this.load6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.load6ActionPerformed(evt);
            }
        });
        this.file6.add(this.load6);

        this.jMenuBar6.add(this.file6);

        this.tips6.setText("Tips / Tricks");
        this.tips6.setActionCommand("Datei");

        this.tut.setAccelerator(KeyStroke.getKeyStroke(113, 0));
        this.tut.setText("<html>F<u>i</u>rst Steps</html>");
        this.tut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.tutinfoActionPerformed(evt);
            }
        });
        this.tips6.add(this.tut);

        this.tips_tricks.setAccelerator(KeyStroke.getKeyStroke(112, 0));
        this.tips_tricks.setText("Tips / Tricks");
        this.tips_tricks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.tips_tricksinfoActionPerformed(evt);
            }
        });
        this.tips6.add(this.tips_tricks);

        this.jMenuBar6.add(this.tips6);

        this.Information6.setText("Information\n");
        this.Information6.setActionCommand("Datei");

        this.info6.setAccelerator(KeyStroke.getKeyStroke(114, 0));
        this.info6.setText("Information About This Programm");
        this.info6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.infoActionPerformed(evt);
            }
        });
        this.Information6.add(this.info6);

        this.update.setText("Check for Updates");
        this.update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UI.this.updateinfoActionPerformed(evt);
            }
        });
        this.Information6.add(this.update);

        this.jMenuBar6.add(this.Information6);

        setJMenuBar(this.jMenuBar6);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 443, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.delete, -2, 88, -2).addComponent(this.buttonLabel).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.up, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.down, -2, 41, -2)).addComponent(this.add, -2, 88, -2)).addComponent(this.edit, -2, 88, -2)).addComponent(this.start, -2, 88, -2)).addContainerGap()).addComponent(this.jProgressBar1, -1, 557, 32767).addGroup(layout.createSequentialGroup().addComponent(this.checkedFiles, -1, 547, 32767).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.buttonLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.start).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.delete).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.edit).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.add).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.down).addComponent(this.up))).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jScrollPane1, -1, 377, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.checkedFiles, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jProgressBar1, -2, 13, -2)));

        layout.linkSize(1, new Component[]{this.add, this.delete, this.down, this.up});

        pack();
    }

    private void upActionPerformed(ActionEvent evt) {
        try {
            int selectedItem = this.jList1.getSelectedIndex();
            Filter cache = this.filter[selectedItem];
            this.filter[selectedItem] = this.filter[(selectedItem - 1)];
            this.filter[(selectedItem - 1)] = cache;
            this.jList1.setModel(lib.filterToModel(this.filter));
            this.jList1.setSelectedIndex(selectedItem - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("method: upActionPerformed:\n" + e);
        }
    }

    private void deleteActionPerformed(ActionEvent evt) {
        try {
            int selectedItem = this.jList1.getSelectedIndex();
            Filter[] newFilter = new Filter[this.filter.length - 1];
            for (int i = 0; i < newFilter.length; i++) {
                if (i < selectedItem) {
                    newFilter[i] = this.filter[i];
                } else {
                    newFilter[i] = this.filter[(i + 1)];
                }
            }
            this.filter = newFilter;
            this.jList1.setModel(lib.filterToModel(this.filter));
            this.jList1.setSelectedIndex(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("method: submitActionPerformed:\n" + e);
        }
    }

    private void addActionPerformed(ActionEvent evt) {
        try {
            int selectedItem = this.jList1.getSelectedIndex();
            Filter[] newFilter = new Filter[this.filter.length + 1];
            for (int i = 0; i < newFilter.length; i++) {
                if (i <= selectedItem) {
                    newFilter[i] = this.filter[i];
                } else if (i == selectedItem + 1) {
                    newFilter[i] = new Filter("default", "default");
                } else {
                    newFilter[i] = this.filter[(i - 1)];
                }
            }
            this.filter = newFilter;
            this.jList1.setModel(lib.filterToModel(this.filter));
            this.jList1.setSelectedIndex(selectedItem + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("method: submitActionPerformed:\n" + e);
        }
        this.FilterSettings.setVisible(true);
        this.replace.setText("");
        this.replace_by.setText("");
    }

    private void downActionPerformed(ActionEvent evt) {
        try {
            int selectedItem = this.jList1.getSelectedIndex();
            Filter cache = this.filter[selectedItem];
            this.filter[selectedItem] = this.filter[(selectedItem + 1)];
            this.filter[(selectedItem + 1)] = cache;
            this.jList1.setModel(lib.filterToModel(this.filter));
            this.jList1.setSelectedIndex(selectedItem + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("method: upActionPerformed:\n" + e);
        }
    }

    private void editActionPerformed(ActionEvent evt) {
        int selectedItem = this.jList1.getSelectedIndex();
        this.FilterSettings.setVisible(true);
        this.replace.setText(this.filter[selectedItem].getReplace());
        this.replace_by.setText(this.filter[selectedItem].getReplaceBy());
    }

    private void replace_byActionPerformed(ActionEvent evt) {
    }

    private void submitActionPerformed(ActionEvent evt) {
        try {
            int selectedItem = this.jList1.getSelectedIndex();
            this.filter[selectedItem].edit(this.replace.getText(), this.replace_by.getText());
            this.jList1.setModel(lib.filterToModel(this.filter));
            this.jList1.setSelectedIndex(selectedItem);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("method: submitActionPerformed:\n" + e);
        }
        this.FilterSettings.setVisible(false);
    }

    private void starttActionPerformed(ActionEvent evt) {
        if (this.start.getText().equals("Start")) {
            this.dirSelect.setVisible(true);
            this.dirSelect.setAlwaysOnTop(true);
            this.dirSelect.setBounds(10, 10, 600, 90);
        } else {
            this.start.setText("Start");
            this.checkedFiles.setText("Interrupted");
            this.up.setEnabled(true);
            this.down.setEnabled(true);
            this.edit.setEnabled(true);
            this.add.setEnabled(true);
            this.delete.setEnabled(true);
            converter.interrupt();
        }
    }

    private void pathPropertyChange(PropertyChangeEvent evt) {
    }

    private void pathActionPerformed(ActionEvent evt) {
    }

    private void submitPathActionPerformed(ActionEvent evt) {
        String path2 = this.path.getText();
        this.dirSelect.setVisible(false);
        this.start.setText("Stop");
        this.checkedFiles.setText("Starting... Please Wait...");
        this.up.setEnabled(false);
        this.down.setEnabled(false);
        this.edit.setEnabled(false);
        this.add.setEnabled(false);
        this.delete.setEnabled(false);
        converter = new JTreeWalk(path2, this.filter, this.jCheckBox1.isSelected());
        converter.start();
    }

    private void pathCaretUpdate(CaretEvent evt) {
        File f = new File(this.path.getText());
        if (f.isDirectory()) {
            this.jLabel4.setText("<html><font color=\"#00FF00\">OKAY!</font></html>");
            this.submitPath.setEnabled(true);
        } else {
            this.jLabel4.setText("<html><font color=\"#FF0000\">NOT OKAY</font></html>");
            this.submitPath.setEnabled(false);
        }
    }

    private void informationKeyTyped(KeyEvent evt) {
        this.information.setVisible(false);
    }

    private void infoActionPerformed(ActionEvent evt) {
        this.information.setVisible(true);
    }

    private void informationMouseClicked(MouseEvent evt) {
        this.information.setVisible(false);
    }

    private void tips_tricksinfoActionPerformed(ActionEvent evt) {
        try {
            Process r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler tips.html");
            r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler javascript:location.href=' tips.html ' ");
        } catch (IOException e) {
            Process s;
            e.printStackTrace();
        }
    }

    private void tutinfoActionPerformed(ActionEvent evt) {
        try {
            Process r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler first_steps.html");
            r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler javascript:location.href=' first_steps.html ' ");
        } catch (IOException e) {
            Process s;
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.disabled.setVisible(false);
    }

    private void checkForUpdatesActionPerformed(ActionEvent evt) {
        try {
            Process r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + CHECK_FOR_UPDATE_URL);
            r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler javascript:location.href=' " + CHECK_FOR_UPDATE_URL + " ' ");
        } catch (IOException e) {
            Process s;
            e.printStackTrace();
        }
    }

    private void load6ActionPerformed(ActionEvent evt) {
        this.jList2.setModel(lib.loadFilterlist());
        this.filtermanager.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        Filter[] a = lib.loadFilter((String) this.jList2.getSelectedValue());
        if (a != null) {
            this.filter = a;
        } else {
            System.err.println("EMPTY!");
            this.filter = new Filter[0];
        }
        this.filtermanager.setVisible(false);
        this.jList1.setModel(lib.filterToModel(this.filter));
        this.jList1.setSelectedIndex(0);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        lib.saveFilter(this.filter, this.filtername.getText());
        this.filtermanager.setVisible(false);
    }

    private void filternameActionPerformed(ActionEvent evt) {
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.filtermanager.setVisible(false);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        this.disabled.setVisible(true);
    }

    private void updateinfoActionPerformed(ActionEvent evt) {
        try {
            Process r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + CHECK_FOR_UPDATE_URL);
            r = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler javascript:location.href=' " + CHECK_FOR_UPDATE_URL + " ' ");
        } catch (IOException e) {
            Process s;
            e.printStackTrace();
        }
    }

    void ready() {
        this.start.setText("Start");
        this.up.setEnabled(true);
        this.down.setEnabled(true);
        this.edit.setEnabled(true);
        this.add.setEnabled(true);
        this.delete.setEnabled(true);
        this.checkedFiles.setText("Ready: " + this.checkedFiles.getText());
        this.jProgressBar1.setMaximum(100);
        this.jProgressBar1.setValue(100);
    }

    public void setStatus(int f, int d) {
        this.checkedFiles.setText(d + " files in " + f + " dirs checked");
        this.jProgressBar1.setMaximum(500);
        this.jProgressBar1.setValue((this.jProgressBar1.getValue() + 1) % 500);
    }
}
