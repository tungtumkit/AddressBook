package Main;

import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressPanel extends javax.swing.JPanel implements DocumentListener {
    private boolean         saved;
    private int             records, currentRecord;
    private File            file;
    private String          filePath;
    private final ArrayList<Person>  persons;
    private final JTextField textfields[];
  
    public AddressPanel() {
        initComponents();
        persons = new ArrayList<>();
        textfields = new JTextField[]{titleField, firstNameField, lastNameField,
            streetField, houseNumberField, cityField, countryField,
            postCodeField, telefonField, emailField};
        
        addUpdateSaveStatusToAllFields();
        reset();
    }
    
    //to update "saved" status whenever a text field changes
    private void addUpdateSaveStatusToAllFields() {
        for(JTextField field: textfields)
            field.getDocument().addDocumentListener(this);
    }
    
    // activate/deactivate all text fields
    private void activateAllFields() {
        for(JTextField field: textfields)
            field.setEditable(true);
    }
    
    private void deactivateAllFields() {
        currentRecordLabel.setText("No dataset. Please create a new one.");
        for(JTextField field: textfields)
            field.setEditable(false);
    }
    
    //Overwrite methods of DocumentListener
    @Override 
    public void changedUpdate(DocumentEvent e) {
        saved = false;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        saved = false;
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        saved = false;
    }
    
    //Read and write methods
    //load the dataset from file
    public void loadFromFile(File input) {
        reset();
        file = input;
        filePath = file.getPath();
        try (Scanner scanner = new Scanner(input)) {
            records = Integer.valueOf(scanner.nextLine());
            for(int i=0; i<records; i++) {   
                Person p = new Person();
                p.loadFromScanner(scanner);
                persons.add(p);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            
        }
        showRecordAt(0, false);
    }
    
    //load the dataset from a file path (in config)
    public void loadFromAddress(String path) {
        if (path == null)
            return;
        filePath = path;
        file = new File(path);
        loadFromFile(file);
    }
    
    //save current dataset to file
    public void saveToFile(File savefile) {
        saveCurrentRecord();
        file = savefile;
        filePath = file.getPath();

        try (FileWriter writer = new FileWriter(savefile)) {
            writer.write(records+"\n");
            for(Person p : persons) 
                p.writeToFile(writer);
        }
        catch (IOException e) {
        }
        
        saved = true;
    }
    
    public void saveCurrentFile() {   
        saveToFile(file);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        titleLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        houseNumberLabel = new javax.swing.JLabel();
        postCodeLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        streetField = new javax.swing.JTextField();
        houseNumberField = new javax.swing.JTextField();
        postCodeField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        currentRecordLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(710, 330));
        setLayout(new java.awt.GridBagLayout());

        titleLabel.setText("Title");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        titleLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(titleLabel, gridBagConstraints);

        firstNameLabel.setText("First name");
        firstNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        firstNameLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(firstNameLabel, gridBagConstraints);

        lastNameLabel.setText("Surname");
        lastNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lastNameLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(lastNameLabel, gridBagConstraints);

        streetLabel.setText("Street");
        streetLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        streetLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(streetLabel, gridBagConstraints);

        houseNumberLabel.setText("House number");
        houseNumberLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        houseNumberLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(houseNumberLabel, gridBagConstraints);

        postCodeLabel.setText("Postcode");
        postCodeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        postCodeLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(postCodeLabel, gridBagConstraints);

        cityLabel.setText("Citiy");
        cityLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cityLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        add(cityLabel, gridBagConstraints);

        telefonLabel.setText("Telephone");
        telefonLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        telefonLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        add(telefonLabel, gridBagConstraints);

        emailLabel.setText("Email");
        emailLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        emailLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        add(emailLabel, gridBagConstraints);

        countryLabel.setText("Country");
        countryLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        countryLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(countryLabel, gridBagConstraints);

        titleField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        add(titleField, gridBagConstraints);

        firstNameField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(firstNameField, gridBagConstraints);

        lastNameField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(lastNameField, gridBagConstraints);

        streetField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        add(streetField, gridBagConstraints);

        houseNumberField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        add(houseNumberField, gridBagConstraints);

        postCodeField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        add(postCodeField, gridBagConstraints);

        telefonField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        add(telefonField, gridBagConstraints);

        cityField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        add(cityField, gridBagConstraints);

        emailField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        add(emailField, gridBagConstraints);

        countryField.setPreferredSize(new java.awt.Dimension(600, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        add(countryField, gridBagConstraints);

        currentRecordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        currentRecordLabel.setText("record");
        currentRecordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        currentRecordLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(currentRecordLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    protected final void reset() {
        //first we create a pseudo person entry, then deactivate all text fields
        persons.clear();
        records = currentRecord = 0;
        createNewEmptyRecord(false);
        deactivateAllFields();
        
        //then we really empty the dataset
        persons.clear();
        records = currentRecord = 0;
        
        saved = true;
        filePath = null;
        file = null;
    }
        
    public void createNewEmptyRecord(boolean save) {
        persons.add(new Person());
        
        records++;
        saved = false;
        
        activateAllFields();
        showRecordAt(records-1, save);
    }
    
    //save all text fields information to current record
    private void saveCurrentRecord() {
        Person p = persons.get(currentRecord);
        p.setTitle(titleField.getText());
        p.setFirstName(firstNameField.getText());
        p.setLastName(lastNameField.getText());
        p.setStreet(streetField.getText());
        p.setCity(cityField.getText());
        p.setCountry(countryField.getText());
        p.setPostCode(postCodeField.getText());
        p.setTelefon(telefonField.getText());
        p.setEmail(emailField.getText());
        p.setHouseNumber(houseNumberField.getText());
    }
    
    //display current record on panel
    public void showCurrentRecord() {
        currentRecordLabel.setText("Current record : " + (currentRecord+1) + "/" + (records));
        
        Person p = persons.get(currentRecord);
        titleField.setText(p.getTitle());
        firstNameField.setText(p.getFirstName());
        lastNameField.setText(p.getLastName());
        streetField.setText(p.getStreet());
        houseNumberField.setText(p.getHouseNumber());
        postCodeField.setText(p.getPostCode());
        cityField.setText(p.getCity());
        countryField.setText(p.getCountry());
        telefonField.setText(p.getTelefon());
        emailField.setText(p.getEmail());   
    }
    
    public void showRecordAt(int index, boolean save) {
        if (isEmpty())
            return;
        
        activateAllFields();
        if (save)
            saveCurrentRecord();
        
        if (records < 1) //nothing to show
            return;
        
        if (index < 0)
            index = 0;
        
        if (index >= records)
            index = records-1;
        
        currentRecord = index;
        showCurrentRecord();     
    }
    
    //delete-methods    
    public void deleteRecordAt(int index) {   
        saved = false;
        persons.remove(index);     
        records--;
        if (index >= records)
            index = records-1;
        currentRecord = index;
        
        if (isEmpty())
            reset();
        else
            showRecordAt(index, false); 
    }
    
    public void deleteCurrentRecord() {
        if (records == 0)
            return;
        deleteRecordAt(currentRecord);
    }
    
    //accessors
    public boolean isEmpty() {
        return (records == 0);
    }
    
    public int getNumberOfRecord() {
        return records;
    }
    
    public int getCurrentRecord() {
        return currentRecord;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public boolean isSaved() {
        return saved;
    }
    
    public boolean haveFile() {
        return (file != null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel currentRecordLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField houseNumberField;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField postCodeField;
    private javax.swing.JLabel postCodeLabel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
