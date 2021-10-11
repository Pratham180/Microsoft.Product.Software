/**
 * Write a description of class ProductGUI here.
 *
 * @author (pratham adhikari)
 * @version (a version number or a date)
 */
//importing java framework and classes
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//Class  declaration
public class ProductGUI extends JFrame {
    
    //variable declaration
    private JPanel bodyPanel;
    private JTextField productNoTextField;
    private JTextField productNameTextField;
    private JTextField companyNameTextField;
    private JTextField pricePerUserTextField;
    private JTextField totalPriceTextField;
    private JTextField activationKeyTextField;
    private JTextField activationDateTextField;
    private JTextField expireDateTextField;
    private JTextField noOfUserTextField;
    private JTextField productPriceSettingPPUTextField;
    
    //JLabel declaration 
    private JLabel productAdditionLabel;
    private JLabel productNoLabel;
    private JLabel productNameLabel;
    private JLabel pricePerUserLabel;
    private JLabel productPriceSettingLabel;
    private JLabel productPriceSettingProductNoLabel;
    private JLabel productPriceSettingPPULabel;
    private JLabel lblLicenseActivation;
    private JLabel licenseActivationProductNoLabel;
    private JLabel companyNameLabel;
    private JLabel noOfUserLabel;
    private JLabel totalPriceLabel;
    private JLabel activationKeyLabel;
    private JLabel activationDateLabel;
    private JLabel expireDateLabel;
    private JLabel licenseTerminationLabel;
    private JLabel licenseTerminationProductNoLabel;
    
    //JButton declaration 
    private JButton addButton;
    private JButton setPricetButton;
    private JButton activateButton;
    private JButton expireButton;
    private JButton displayButton;
    private JButton clearButton;
    
    //Combobox declaration
    private JComboBox licenseTerminationProductNo;
    private JComboBox licenseActivationProductNo;
    private JComboBox productPriceSettingProductNo;
    
   
    //arraylist declaration
    private List<MicrosoftProduct> productData = new ArrayList<>();
    private List<Integer> productNoList = new ArrayList<>();
    
    // method to initialize the frame,compontens and frame actions
    public ProductGUI() {
        initializeFrameActions();
        initializeComponents();
        initializeFrame();
    }
    // method to set the Jlabel,Jtextfield,text field, button and placement of all the components in the gui
    private void initializeComponents() {
        bodyPanel = new JPanel();
        getContentPane().add(bodyPanel, BorderLayout.CENTER);
        bodyPanel.setLayout(null);
            
        // Product addition label
        JLabel productAdditionLabel = new JLabel("Product Addition");
        productAdditionLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));  
        productAdditionLabel.setBounds(430, 10, 200, 20);
        bodyPanel.add(productAdditionLabel);
        
        //Prodcut label
        productNoLabel = new JLabel("Product No:");              
        productNoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productNoLabel.setBounds(87, 40, 110, 20);
        productNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(productNoLabel);
            
        //Product number text field
        productNoTextField = new JTextField();
        productNoTextField.setBounds(217, 40, 180, 20);
        productNoTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(productNoTextField);
        productNoTextField.setColumns(10);

        // product name label
        productNameLabel = new JLabel("Product Name");
        productNameLabel.setBounds(572, 40, 110, 20);
        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(productNameLabel);
        // product name text field
        productNameTextField = new JTextField();
        productNameTextField.setBounds(702, 40, 180, 20);
        productNameTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        productNameTextField.setColumns(10);
        bodyPanel.add(productNameTextField);
        // price per user label
        pricePerUserLabel = new JLabel("Price Per User:");
        pricePerUserLabel.setBounds(87, 65, 110, 20);
        pricePerUserLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(pricePerUserLabel);
        // price per user text field
        pricePerUserTextField = new JTextField();
        pricePerUserTextField.setBounds(217, 65, 180, 20);
        pricePerUserTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pricePerUserTextField.setColumns(10);
        bodyPanel.add(pricePerUserTextField);
        // add product button
        addButton = new JButton("Add Product");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addProduct(evt);
            }
        });
        addButton.setBounds(700, 75, 180, 30);
        bodyPanel.add(addButton);

        // Product Price Setting label
        productPriceSettingLabel = new JLabel("Product Price Setting");
        productPriceSettingLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        productPriceSettingLabel.setBounds(430, 110, 200, 22);
        bodyPanel.add(productPriceSettingLabel);
        // product number label
        productPriceSettingProductNoLabel = new JLabel("Product No:");
        productPriceSettingProductNoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productPriceSettingProductNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        productPriceSettingProductNoLabel.setBounds(87, 142, 110, 20);
        bodyPanel.add(productPriceSettingProductNoLabel);
        //producr number combobox
        productPriceSettingProductNo = new JComboBox();
        productPriceSettingProductNo.setBounds(217, 142, 180, 20);
        bodyPanel.add(productPriceSettingProductNo);
        // price per user label
        productPriceSettingPPULabel = new JLabel("Price Per User:");
        productPriceSettingPPULabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        productPriceSettingPPULabel.setBounds(572, 142, 110, 20);
        bodyPanel.add(productPriceSettingPPULabel);
        // price per user text field
        productPriceSettingPPUTextField = new JTextField();
        productPriceSettingPPUTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        productPriceSettingPPUTextField.setColumns(10);
        productPriceSettingPPUTextField.setBounds(702, 142, 180, 20);
        bodyPanel.add(productPriceSettingPPUTextField);
        // set product price button
        setPricetButton = new JButton("Set Product Price");
        setPricetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setProductPricePerUnit(e);
            }
        });
        setPricetButton.setBounds(700, 172, 180, 30);
        bodyPanel.add(setPricetButton);

        // License Activation label
        lblLicenseActivation = new JLabel("License Activation");
        lblLicenseActivation.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblLicenseActivation.setBounds(430, 215, 200, 20);
        bodyPanel.add(lblLicenseActivation);
        // license activation product number combobox
        licenseActivationProductNo = new JComboBox();
        licenseActivationProductNo.setBounds(217, 246, 180, 20);
        bodyPanel.add(licenseActivationProductNo);
        //licesne activion product no label
        licenseActivationProductNoLabel = new JLabel("Product No:");
        licenseActivationProductNoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        licenseActivationProductNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        licenseActivationProductNoLabel.setBounds(87, 246, 110, 20);
        bodyPanel.add(licenseActivationProductNoLabel);
        //company name label label
        companyNameLabel = new JLabel("Company Name");
        companyNameLabel.setBounds(572, 240, 110, 30);
        companyNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        companyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(companyNameLabel);
        //company name text field
        companyNameTextField = new JTextField();
        companyNameTextField.setBounds(702, 246, 180, 20);
        companyNameTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        companyNameTextField.setColumns(10);
        bodyPanel.add(companyNameTextField);
        //no of user label
        noOfUserLabel = new JLabel("No. of User:");
        noOfUserLabel.setBounds(87, 289, 110, 20);
        noOfUserLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bodyPanel.add(noOfUserLabel);
        //no of user text field
        noOfUserTextField = new JTextField();
        noOfUserTextField.setBounds(217, 289, 180, 20);
        noOfUserTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        noOfUserTextField.setColumns(10);
        noOfUserTextField.addKeyListener(new KeyListener() {

            
            public void keyTyped(KeyEvent e) {
                

            }

            //action event method to calculate the total price
            public void keyReleased(KeyEvent e) {
                int noOfUser = (int) convertStringToNumber(noOfUserTextField.getText(), "Number of user");
                if (noOfUser == -1) {  //if loop
                    return;
                }
                Optional<MicrosoftProduct> product = productData.stream().filter(pd -> pd.getProductNo() == Integer
                        .valueOf((String) licenseActivationProductNo.getSelectedItem())).findFirst();
                EnterpriseEdition edition = (EnterpriseEdition)product.get();
                System.out.println(edition.getPricePerUser());
                totalPriceTextField.setText(String.valueOf(noOfUser * edition.getPricePerUser()));
            }

            
            public void keyPressed(KeyEvent e) {
                

            }
        });
        bodyPanel.add(noOfUserTextField);
        // total price label
        totalPriceLabel = new JLabel("Total Price:");
        totalPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        totalPriceLabel.setBounds(87, 382, 110, 20);
        bodyPanel.add(totalPriceLabel);
        // total price text field
        totalPriceTextField = new JTextField();
        totalPriceTextField.setEditable(false);
        totalPriceTextField.setBounds(217, 382, 180, 20);
        totalPriceTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        totalPriceTextField.setColumns(10);
        bodyPanel.add(totalPriceTextField);
        // activation key label
        activationKeyLabel = new JLabel("Activation Key");
        activationKeyLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        activationKeyLabel.setBounds(572, 337, 110, 20);
        bodyPanel.add(activationKeyLabel);
        // activation key text field
        activationKeyTextField = new JTextField();
        activationKeyTextField.setBounds(702, 337, 180, 20);
        activationKeyTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        activationKeyTextField.setColumns(10);
        bodyPanel.add(activationKeyTextField);
        // activation date label
        activationDateLabel = new JLabel("Activation Date");
        activationDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        activationDateLabel.setBounds(572, 296, 110, 20);
        bodyPanel.add(activationDateLabel);
        // activation date text field
        activationDateTextField = new JTextField();
        activationDateTextField.setBounds(702, 296, 180, 20);
        activationDateTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        activationDateTextField.setColumns(10);
        bodyPanel.add(activationDateTextField);
        // activate license button
        activateButton = new JButton("Activate License");
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                activateProduct(evt);
            }
        });
        activateButton.setBounds(702, 383, 180, 30);
        bodyPanel.add(activateButton);
        // expiration date label
        expireDateLabel = new JLabel("Expiration Date");
        expireDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        expireDateLabel.setBounds(87, 330, 110, 20);
        expireDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        bodyPanel.add(expireDateLabel);
        // expiration date text field
        expireDateTextField = new JTextField();
        expireDateTextField.setBounds(217, 330, 180, 20);
        expireDateTextField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        expireDateTextField.setColumns(10);
        bodyPanel.add(expireDateTextField);

        // Terminate license label
        licenseTerminationLabel = new JLabel("License Termination");
        licenseTerminationLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        licenseTerminationLabel.setBounds(430, 434, 200, 20);
        bodyPanel.add(licenseTerminationLabel);
         // license termination product no label
        licenseTerminationProductNoLabel = new JLabel("Product No:");
        licenseTerminationProductNoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        licenseTerminationProductNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        licenseTerminationProductNoLabel.setBounds(87, 465, 110, 20);
        bodyPanel.add(licenseTerminationProductNoLabel);
        // license perimantion product no combo box
        licenseTerminationProductNo = new JComboBox<>();
        licenseTerminationProductNo.setBounds(217, 465, 180, 20);
        bodyPanel.add(licenseTerminationProductNo);
        // terminate licesne button
        expireButton = new JButton("Terminate License");
        expireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                terminateProduct(evt);
            }
        });
        expireButton.setBounds(702, 465, 180, 30);
        bodyPanel.add(expireButton);

        // Display button
        displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display(e);
            }
        });
        displayButton.setBounds(333, 555, 180, 30);
        bodyPanel.add(displayButton);
        // clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clear(evt);
            }
        });
        clearButton.setBounds(523, 555, 180, 30);
        bodyPanel.add(clearButton);

    }
    //event handaling method for add products. It will add the product to the array list if the product is not already present in the list
    private void addProduct(ActionEvent event) {
        int productNo = (int) convertStringToNumber(productNoTextField.getText(), "Product Number");
        if (productNo == -1)  //if loop
            return;
        float pricePerUser = convertStringToNumber(pricePerUserTextField.getText(), "Price Per Person");
        if (pricePerUser == -1)  //if loop
            return;
        String productName = productNameTextField.getText();
        if (productName.equals("")) {  // making sure that designation field does not get empty data
            JOptionPane.showMessageDialog(rootPane, "Product Name can not be empty.");
            return;
        }
        if (productData.stream().anyMatch(pd -> pd.getProductNo() == productNo)) {  //if/else loop
            JOptionPane.showMessageDialog(rootPane, "Product Number already exists."); 
        } else {
            EnterpriseEdition newEnterpriseEdition = new EnterpriseEdition(productNo, productName, pricePerUser);
            productData.add(newEnterpriseEdition);
            JOptionPane.showMessageDialog(rootPane, "Product Added.");
            productNoList.add(newEnterpriseEdition.getProductNo());
            updateComboBox();
        }
    }
    //event handaling method to activate a license. It will activate the product is the product is no already activated.
    private void activateProduct(ActionEvent event) {
        int productNo = (int) convertStringToNumber((String) licenseActivationProductNo.getSelectedItem(),
                "Product Number");
        if (productNo == -1) //if loop
            return;
        String clientCompanyName = companyNameTextField.getText();
        if (clientCompanyName.equals("")) { // making sure that designation field does not get empty data
            JOptionPane.showMessageDialog(rootPane, "Company name is empty.");
            return;
        }
        int noOfUser = (int) convertStringToNumber(noOfUserTextField.getText(), "Number of user");
        if (noOfUser == -1)  // if loop
            return;
        String activationDate = activationDateTextField.getText();
        if (activationDate.equals("")) { // making sure that designation field does not get empty data
            JOptionPane.showMessageDialog(rootPane, "Activation date is empty.");
            return;
        }
        String licenseExpireDate = expireDateTextField.getText();
        if (licenseExpireDate.equals("")) { // making sure that designation field does not get empty data
            JOptionPane.showMessageDialog(rootPane, "Expiration date is empty.");
            return;
        }
        String activationKey = activationKeyTextField.getText();
        if (activationKey.equals("")) { // making sure that designation field does not get empty data
            JOptionPane.showMessageDialog(rootPane, "Activation key is empty.");
            return;
        }
        Optional<MicrosoftProduct> product = productData.stream().filter(pd -> pd.getProductNo() == productNo)
                .findFirst();
        if (product.isPresent()) { // if/else loop
            EnterpriseEdition edition = (EnterpriseEdition)product.get();
            JOptionPane.showMessageDialog(rootPane, edition.activateLicense(clientCompanyName, noOfUser,
                    activationDate, licenseExpireDate, activationKey));
            product.get().displayProductInfo();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Product Number does not exists.");
        }
    }
    //event handaling method to terminate product it will terminate the license of the product which is activated 
    private void terminateProduct(ActionEvent event) {
        int productNo = (int) convertStringToNumber((String) licenseTerminationProductNo.getSelectedItem(),
                "Product Number");
        if (productNo == -1)// if loop
            return;
        Optional<MicrosoftProduct> product = productData.stream().filter(pd -> pd.getProductNo() == productNo)
                .findFirst();
        if (product.isPresent()) {// if/else loop
            EnterpriseEdition edition = (EnterpriseEdition)product.get();
            JOptionPane.showMessageDialog(rootPane, edition.teminateLicense());
            product.get().displayProductInfo();
            clear(event);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Product Number does not exists.");
        }
    }
    //event handaling method that  will set new product price is the product is not activated.
    private void setProductPricePerUnit(ActionEvent event) {
        int productNo = (int) convertStringToNumber((String) productPriceSettingProductNo.getSelectedItem(),
                "Product Number");
        if (productNo == -1) // if loop
            return;
        float pricePerUser = convertStringToNumber(productPriceSettingPPUTextField.getText(), "Price per user");
        if (pricePerUser == -1)
            return;
        Optional<MicrosoftProduct> product = productData.stream().filter(pd -> pd.getProductNo() == productNo)
                .findFirst();
        if (product.isPresent()) { // if/else loop
            EnterpriseEdition edition = (EnterpriseEdition)product.get();
            System.out.println("Old price per user = " + edition.getPricePerUser());
            JOptionPane.showMessageDialog(rootPane, edition.setPricePerUser(pricePerUser));
            System.out.println("New price per user = " + edition.getPricePerUser());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Product Number does not exists.");
        }
    }
    // method to print the list in the console
    private void display(ActionEvent event) {
       for(MicrosoftProduct mp:productData){
            EnterpriseEdition edition = (EnterpriseEdition)mp;
            edition.displayProductInfo();
            System.out.println("-----------------------------------------------------------");
       }
   }
    // method to clear all text filed from the GUI
    private void clear(ActionEvent event) {
        productNoTextField.setText("");
        productNameTextField.setText("");
        pricePerUserTextField.setText("");
        productPriceSettingPPUTextField.setText("");
        companyNameTextField.setText("");
        noOfUserTextField.setText("");
        totalPriceTextField.setText("");
        activationKeyTextField.setText("");
        activationDateTextField.setText("");
        expireDateTextField.setText("");
    }
    // method to convert string into float numbers
    private float convertStringToNumber(String data, String field) {
        try { // try code
            return Float.valueOf(data);
        } catch (NumberFormatException e) { // to handle error
            JOptionPane.showMessageDialog(rootPane, "Entered " + field + " is not a valid number.");
        }
        return -1;
    }
    // method to set the height, width, and title of the GUI frame
    private void initializeFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("MICROSOFT PRODUCT INFORMATION");
        setVisible(true);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    // It is a method for initializing frame actions. It defines the close action of frame. 
    private void initializeFrameActions() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    // method to update combo box to show product no in a list on every product no
    private void updateComboBox() {
        String[] array = new String[productNoList.size()];
        for (int i = 0; i < array.length; i++) { //for loop
            array[i] = String.valueOf(productNoList.get(i));
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(array);
        licenseTerminationProductNo.setModel(model);
        licenseActivationProductNo.setModel(model);
        productPriceSettingProductNo.setModel(model);

    }

    // for displaying confirmation box while closing application
    private void formWindowClosing(WindowEvent evt) {
        if (JOptionPane.showConfirmDialog(rootPane, "Do you really want to close the application?", "Confirm Dialogue !!!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    //main method to start productGUI
    public static void main(String[] args) {
        ProductGUI productGUI = new ProductGUI();
    }
}