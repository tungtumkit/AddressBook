package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.util.Properties;
import java.awt.event.*;

public class AppWindow extends javax.swing.JFrame {
    private final String CONFIG_PATH = "settings/config.dat";
    private JFileChooser fileChooser;
    private Properties property;
    private boolean autosave;
    
    public AppWindow() {
        initComponents();
        init();
        applyConfig();
    }
    
    private void init() {
        setTitle("Adressbuch 'Nestor'");
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) { 
                exitAction();
            }      
        });
        
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("data"));
        
        //load config
        property = new Properties();
        try {
            property.load(new FileInputStream(CONFIG_PATH));
        }
        catch (IOException e)   {
            property = null;
            System.out.println("Unable to load config from " + CONFIG_PATH);
        }
    }
    
    private String getProperty(String s) {
        if (property == null)
            return null;
        return property.getProperty(s);
    }
    
    private boolean getBooleanProperty(String s) {
        return Boolean.valueOf(getProperty(s));
    }
    
    private int getIntProperty(String s) {
        return Integer.valueOf(getProperty(s));
    }
    
    private void applyConfig() {
        if (getBooleanProperty("saveLocation"))
            setLocation(getIntProperty("xValue"), getIntProperty("yValue"));
        else
            setLocationRelativeTo(null); //centralize
        
        if (getBooleanProperty("centralize"))
            setLocationRelativeTo(null);
        
        autosave = getBooleanProperty("autoSave");
        if (getBooleanProperty("openLastFile"))
            panel.loadFromAddress(getProperty("lastFilePath"));
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        firstButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        panel = new Main.AddressPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        closeFileMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        dataMenu = new javax.swing.JMenu();
        newRecordMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        searchMenu = new javax.swing.JMenu();
        nextRecordMenuItem = new javax.swing.JMenuItem();
        prevRecordMenuItem = new javax.swing.JMenuItem();
        firstRecordMenuItem = new javax.swing.JMenuItem();
        lastRecordMenuItem = new javax.swing.JMenuItem();
        findRecordMenuItem = new javax.swing.JMenuItem();
        optionMenu = new javax.swing.JMenu();
        configMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(346, 50));
        jToolBar1.setPreferredSize(new java.awt.Dimension(353, 40));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newButton.png"))); // NOI18N
        newButton.setToolTipText("Einen neunen Datensatz hinzufügen");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setPreferredSize(new java.awt.Dimension(40, 40));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newButton);

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        closeButton.setToolTipText("Datei schließen");
        closeButton.setFocusable(false);
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeButton.setPreferredSize(new java.awt.Dimension(40, 40));
        closeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(closeButton);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saveButton.png"))); // NOI18N
        saveButton.setToolTipText("Datensätzen speichern");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setPreferredSize(new java.awt.Dimension(40, 40));
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setToolTipText("Diesen Datensatz löschen");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setPreferredSize(new java.awt.Dimension(40, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteButton);

        firstButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/firstButton.jpg"))); // NOI18N
        firstButton.setToolTipText("Erster Datensatz");
        firstButton.setFocusable(false);
        firstButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        firstButton.setPreferredSize(new java.awt.Dimension(40, 40));
        firstButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(firstButton);

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prevButton.jpg"))); // NOI18N
        prevButton.setToolTipText("Vorheriger Datensatz");
        prevButton.setFocusable(false);
        prevButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        prevButton.setPreferredSize(new java.awt.Dimension(40, 40));
        prevButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(prevButton);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nextButton.jpg"))); // NOI18N
        nextButton.setToolTipText("Nächster Datensatz");
        nextButton.setFocusable(false);
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setPreferredSize(new java.awt.Dimension(40, 40));
        nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(nextButton);

        lastButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lastButton.jpg"))); // NOI18N
        lastButton.setToolTipText("Letzter Datensatz");
        lastButton.setFocusable(false);
        lastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lastButton.setPreferredSize(new java.awt.Dimension(40, 40));
        lastButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(lastButton);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchButton.png"))); // NOI18N
        searchButton.setToolTipText("Datensatz suchen");
        searchButton.setFocusable(false);
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton.setPreferredSize(new java.awt.Dimension(40, 40));
        searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(searchButton);

        fileMenu.setText("File");
        fileMenu.setToolTipText("");

        newMenuItem.setText("New dataset");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setText("Open dataset");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        closeFileMenuItem.setText("Delete dataset");
        closeFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(closeFileMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save as");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        dataMenu.setText("Dataset");

        newRecordMenuItem.setText("New entry");
        newRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRecordMenuItemActionPerformed(evt);
            }
        });
        dataMenu.add(newRecordMenuItem);

        deleteMenuItem.setText("Delete entry");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        dataMenu.add(deleteMenuItem);

        mainMenuBar.add(dataMenu);

        searchMenu.setText("Search");

        nextRecordMenuItem.setText("Next entry");
        nextRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextRecordMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(nextRecordMenuItem);

        prevRecordMenuItem.setText("Previous entry");
        prevRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevRecordMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(prevRecordMenuItem);

        firstRecordMenuItem.setText("First entry");
        firstRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstRecordMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(firstRecordMenuItem);

        lastRecordMenuItem.setText("Last entry");
        lastRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastRecordMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(lastRecordMenuItem);

        findRecordMenuItem.setText("Entry by number");
        findRecordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findRecordMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(findRecordMenuItem);

        mainMenuBar.add(searchMenu);

        optionMenu.setText("Option");

        configMenuItem.setText("Configs");
        configMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(configMenuItem);

        mainMenuBar.add(optionMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRecordMenuItemActionPerformed
        newRecordAction();
    }//GEN-LAST:event_newRecordMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        deleteRecordAction();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        saveFileAction();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exitAction();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutDialog dialog = new AboutDialog(this,true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void configMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuItemActionPerformed
        OptionDialog dlg = new OptionDialog(this, property);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_configMenuItemActionPerformed

    private void nextRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextRecordMenuItemActionPerformed
        nextRecordAction();
    }//GEN-LAST:event_nextRecordMenuItemActionPerformed

    private void prevRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevRecordMenuItemActionPerformed
        prevRecordAction();
    }//GEN-LAST:event_prevRecordMenuItemActionPerformed

    private void firstRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstRecordMenuItemActionPerformed
        firstRecordAction();
    }//GEN-LAST:event_firstRecordMenuItemActionPerformed

    private void lastRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastRecordMenuItemActionPerformed
        lastRecordAction();
    }//GEN-LAST:event_lastRecordMenuItemActionPerformed

    private void findRecordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findRecordMenuItemActionPerformed
        searchRecordAction();
    }//GEN-LAST:event_findRecordMenuItemActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newRecordAction();
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        saveFileAsAction();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        newFileAction();
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        loadFileAction();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveFileAction();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteRecordAction();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        firstRecordAction();
    }//GEN-LAST:event_firstButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        prevRecordAction();
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        nextRecordAction();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        lastRecordAction();
    }//GEN-LAST:event_lastButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchRecordAction();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        closeAction();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void closeFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileMenuItemActionPerformed
        closeAction();
    }//GEN-LAST:event_closeFileMenuItemActionPerformed

    //laden-speichern Methoden
    private void checkSaved() {
        if (panel.isSaved()) //nothing to do
            return;
        
        if (autosave) {
            saveFileAction();
            return;     
        }
        
        AskSaveDialog dialog = new AskSaveDialog(this,true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void exitAction() {
        saveConfig();
        if (autosave) {
            saveFileAction();
            System.exit(0);
        }
        
        if (!panel.isSaved()) {   
            ExitDialog dialog = new ExitDialog(this,true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);   
        }   
        else
            System.exit(0);
    }
    
    private void closeAction() {
        checkSaved();
        panel.reset();
    }
    
    private void newFileAction() {
        checkSaved();
        panel.reset();
    }
    
    private void loadFileAction() {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            checkSaved();
            panel.loadFromFile(fileChooser.getSelectedFile());
        }
    }
    
    public void saveFileAction() {   
        if (panel.haveFile())
            panel.saveCurrentFile();    
        else saveFileAsAction();
    }
    
    private void saveFileAsAction() {
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
            panel.saveToFile(fileChooser.getSelectedFile());
    }
    
    //toolbar methods
    private void newRecordAction() {
        panel.createNewEmptyRecord(true);
    }
    
    private void deleteRecordAction() {
        panel.deleteCurrentRecord();
    }
    
    private void nextRecordAction() {
        panel.showRecordAt(panel.getCurrentRecord()+1, true);
    }
    
    private void firstRecordAction() {
        panel.showRecordAt(0,true);
    }
    
    private void prevRecordAction() {
        panel.showRecordAt(panel.getCurrentRecord()-1, true);
    }
    
    private void lastRecordAction() {
        panel.showRecordAt(panel.getNumberOfRecord()-1, true);
    }
    
    private void searchRecordAction() {   
        if (panel.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Keine Datei zu zeigen."); 
            return;
        }
        
        int records = panel.getNumberOfRecord();
        
        int index = -1;
        while (index<1 || index>records) {
            try {
                String s = JOptionPane.showInputDialog( "Bitte Zahl eingeben" ); 
                if (s == null)
                    return;
                index = Integer.valueOf(s); 
                
                if (index<1 || index>records)
                JOptionPane.showMessageDialog(this,
                        "Falsche Angabe. Bitte einen Wert zwischen 1 und "
                            + records + " eingeben.");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Falsche Angabe. Bitte nochmal versuchen");
            }
        }
        panel.showRecordAt(index,true);
    }
    
    //save properties
    private void setProperty(String s1, String s2) {
        if (s2 != null)
            property.setProperty(s1,s2);
    }
    
    protected void saveConfig() {
        //save properties
        setProperty("lastFilePath", panel.getFilePath());
        setProperty("xValue",String.valueOf(getX()));
        setProperty("yValue",String.valueOf(getY()));
        autosave = getBooleanProperty("autoSave");
        
        //store property
        try {
            property.store(new FileOutputStream(CONFIG_PATH), "config file from Nestor");
        }
        catch (IOException e) {
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton closeButton;
    private javax.swing.JMenuItem closeFileMenuItem;
    private javax.swing.JMenuItem configMenuItem;
    private javax.swing.JMenu dataMenu;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem findRecordMenuItem;
    private javax.swing.JButton firstButton;
    private javax.swing.JMenuItem firstRecordMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton lastButton;
    private javax.swing.JMenuItem lastRecordMenuItem;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JButton newButton;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem newRecordMenuItem;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem nextRecordMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenu optionMenu;
    private Main.AddressPanel panel;
    private javax.swing.JButton prevButton;
    private javax.swing.JMenuItem prevRecordMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JMenu searchMenu;
    // End of variables declaration//GEN-END:variables
}
