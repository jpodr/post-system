import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import entity.*;

public class MainWindowForm extends JFrame {
    private JButton clickMEButton;
    private JPanel mainWindowPanel;
    private JTabbedPane mainWindowTabbedPane;
    private JTextField senderBuildingNumberTextField;
    private JTextField senderStreetTextField;
    private JLabel senderLabel;
    private JTextField senderCityTextField;
    private JTextField senderPostalCodeTextField;
    private JLabel receiverLabel;
    private JComboBox packageSizeComboBox;
    private JButton addPackageButton;
    private JLabel packageLabel;
    private JList allPackagesList;
    private JTextArea allPackagesInfoTextArea;
    private JTextField mainPagePackageIdTextField;
    private JButton mainPageTrackButton;
    private JTextArea mainPagePackageInfoTextArea;
    private JTextField receiverFirstNameTextField;
    private JTextField receiverLastNameTextField;
    private JTextField receiverEmailTextField;
    private JTextField receiverStreetTextField;
    private JLabel packageSizeLabel;
    private JLabel priorityLabel;
    private JComboBox priorityComboBox;
    private JTextField receiverCityTextField;
    private JTextField receiverPostalCodeTextField;
    private JTextField receiverBuildingNumberTextField;
    private JLabel receiverLastNameLabel;
    private JLabel receiverFirstNameLabel;
    private JLabel receiverEmailLabel;
    private JLabel receiverStreetLabel;
    private JLabel receiverBuildingNumberLabel;
    private JLabel receiverCityLabel;
    private JLabel receiverPostalCodeLabel;
    private JLabel senderPostalCodeLabel;
    private JLabel senderBuildingNumberLabel;
    private JLabel senderCityLabel;
    private JLabel senderStreetLabel;
    private JLabel mainPageEnterPackageIdLabel;
    private JPanel mainPagePanel;
    private JPanel addPackagePagePanel;
    private JPanel showAllPackagesPagePanel;
    private JLabel receiverPhoneNumberLabel;
    private JTextField receiverPhoneNumberTextField;
    private JPanel loginPagePanel;
    private JTextField loginLoginPageTextField;
    private JLabel loginLoginPageLabel;
    private JPasswordField passwordLoginPagePasswordField;
    private JLabel passwordLoginPageLabel;
    private JButton logInLoginPageButton;
    private JButton registerLoginPageButton;
    private JPanel createNewAccountPagePanel;
    private JTextField nameTextFieldNewAccountPage;
    private JTextField surnameTextFieldNewAccountPage;
    private JTextField mobileNumberTextFieldNewAccountPage;
    private JTextField emailTextFieldNewAccountPage;
    private JPasswordField passwordPasswordFieldNewAccountPage;
    private JCheckBox showPasswordCheckBox;
    private JTextField countryTextFieldNewAccountPage;
    private JTextField townTextFieldNewAccountPage;
    private JTextField buildingNumberTextFieldNewAccountPage;
    private JTextField streetTextFieldNewAccountPage;
    private JTextField postalCodeTextFieldNewAccountPage;
    private JSpinner dayNewAccountPageSpinner;
    private JComboBox monthNewAccountPageComboBox;
    private JSpinner yearNewAccountPageSpinner;
    private JButton createAccountButton;
    private JButton logInButton;
    private JTabbedPane loginTabbedPane;
    private JPanel courierPagePanel;
    private JList courierAllPackagesList;
    private JTextArea courierAllPackagesInfoTextArea;
    private JButton deleteSelectedPackageButton;
    private JPanel logOutTab;
    private JPasswordField passwordAgainPasswordFieldNewAccountPage;
    private JLabel weightLabel;
    private JTextField weightTextField;
    private JTextField senderCountryTextField;
    private JTextField receiverCountryTextField;
    private JTextField textOnClick;
    private DBManager dbManager;

    private Clients loggedInClient;
    private Employees loggedInEmployee;

    private String DescribedPackageAttributes(Object[] attrs){
        String resp = "";
        resp += "Package:\nID: " + attrs[0].toString();
        resp += "; Size: " + attrs[1].toString();
        resp += "; Priority: " + attrs[2].toString() + "\n\n";
        resp += "Address:\nStreet: " + attrs[3].toString() + " " + attrs[4].toString();
        resp += "; City: " + attrs[6].toString() + " " + attrs[5].toString() + "\n\n";
        resp += "Receiver:\nFirst name: " + attrs[7].toString();
        resp += "; Last name: " + attrs[8].toString();
        resp += "; Phone number: " + attrs[9].toString();
        return resp;
    }

    public MainWindowForm() {
        dbManager = new DBManager();
        setContentPane(mainWindowPanel);
        setTitle("PW Post");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createNewAccountPagePanel.setVisible(false);
        mainWindowTabbedPane.setVisible(false);
        setVisible(true);
        senderLabel.setFont(new Font("", Font.PLAIN, 16));
        receiverLabel.setFont(new Font("", Font.PLAIN, 16));
        packageLabel.setFont(new Font("", Font.PLAIN, 16));
        mainPageTrackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = new String(mainPagePackageIdTextField.getText());
                List<String> idList = Arrays.asList(id.split("\\s*,\\s*"));
                String attrsString = new String();
                for (int i = 0; i < idList.size(); i++) {
                    BigInteger oneId = new BigInteger(idList.get(i));
                    Object[] attributes = (Object[]) dbManager.getFullPackageInfo(oneId).get(0);
                    attrsString += DescribedPackageAttributes(attributes);
                    if (idList.size() > 1 && i < (idList.size() - 1)) {
                        attrsString += new String("\n---------------------------\n");
                    }
                }
                mainPagePackageInfoTextArea.setText(attrsString);
            }
        });
        mainWindowTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (mainWindowTabbedPane.getSelectedIndex() == 1){
                    allPackagesList.setModel(new DefaultListModel());
                    List infos = dbManager.getAllPackagesInfo();
                    for(int i = 0; i < infos.size(); i++){
                        Object[] o = (Object[]) infos.get(i);
                        String info = o[0] + ", " + o[1] + " " + o[2];
                        DefaultListModel newModel = new DefaultListModel();
                        newModel.addElement(info);
                        for (int j = 0; j < allPackagesList.getModel().getSize(); j++){
                            newModel.addElement(allPackagesList.getModel().getElementAt(j));
                        }
                        allPackagesList.setModel(newModel);
                    }
                }
                else if (mainWindowTabbedPane.getSelectedIndex() == 2){
                    courierAllPackagesList.setModel(new DefaultListModel());
                    List infos = dbManager.getAllPackagesInfo();
                    for(int i = 0; i < infos.size(); i++){
                        Object[] o = (Object[]) infos.get(i);
                        String info = o[0] + ", " + o[1] + " " + o[2];
                        DefaultListModel newModel = new DefaultListModel();
                        newModel.addElement(info);
                        for (int j = 0; j < courierAllPackagesList.getModel().getSize(); j++){
                            newModel.addElement(courierAllPackagesList.getModel().getElementAt(j));
                        }
                        courierAllPackagesList.setModel(newModel);
                    }
                }
                else if (mainWindowTabbedPane.getSelectedIndex() == 3){
                    mainWindowTabbedPane.setVisible(false);
                    loginTabbedPane.setVisible(true);
                    loginPagePanel.setVisible(true);
                    loggedInClient = null;
                    loggedInEmployee = null;
                    mainWindowTabbedPane.setSelectedIndex(0);
                }
            }
        });
        allPackagesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object selectedValue = ((JList) e.getSource()).getSelectedValue();
                if (selectedValue == null) return;
                String value = selectedValue.toString();
                String idStr = "";
                for (int i = 0; i < value.length(); i++){
                    if (value.charAt(i) == ','){
                        break;
                    }
                    idStr += value.charAt(i);
                }
                BigInteger packageId = new BigInteger(idStr);
                Object[] attributes = (Object[]) dbManager.getFullPackageInfo(packageId).get(0);
                allPackagesInfoTextArea.setText(DescribedPackageAttributes(attributes));
            }
        });
        courierAllPackagesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object selectedValue = ((JList) e.getSource()).getSelectedValue();
                if (selectedValue == null) return;
                String value = selectedValue.toString();
                String idStr = "";
                for (int i = 0; i < value.length(); i++){
                    if (value.charAt(i) == ','){
                        break;
                    }
                    idStr += value.charAt(i);
                }
                BigInteger packageId = new BigInteger(idStr);
                Object[] attributes = (Object[]) dbManager.getFullPackageInfo(packageId).get(0);
                courierAllPackagesInfoTextArea.setText(DescribedPackageAttributes(attributes));
            }
        });
        addPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger senderAddressId = dbManager.addAddress(
                        senderCityTextField.getText(),
                        senderStreetTextField.getText(),
                        senderBuildingNumberTextField.getText(),
                        senderPostalCodeTextField.getText(),
                        null
                );
                BigInteger receiverAddressId = dbManager.addAddress(
                        receiverCityTextField.getText(),
                        receiverStreetTextField.getText(),
                        receiverBuildingNumberTextField.getText(),
                        receiverPostalCodeTextField.getText(),
                        null
                );
                BigInteger senderId = dbManager.addClient(
                        senderFirstNameTextField.getText(),
                        senderLastNameTextField.getText(),
                        senderEmailTextField.getText(),
                        senderPhoneNumberTextField.getText(),
                        senderAddressId, null, null
                );
                BigInteger receiverId = dbManager.addClient(
                        receiverFirstNameTextField.getText(),
                        receiverLastNameTextField.getText(),
                        receiverEmailTextField.getText(),
                        receiverPhoneNumberTextField.getText(),
                        receiverAddressId, null, null
                );
                String size = "";
                String sizePrize = packageSizeComboBox.getSelectedItem().toString();
                for (int i = 0; i < sizePrize.length(); i++){
                    if (sizePrize.charAt(i) == ' '){
                        break;
                    }
                    size += sizePrize.charAt(i);
                }
                String pri = "";
                String priPrize = priorityComboBox.getSelectedItem().toString();
                for (int i = 0; i < priPrize.length(); i++){
                    if (priPrize.charAt(i) == ' '){
                        break;
                    }
                    pri += priPrize.charAt(i);
                }
//                dbManager.addPackage(
//                        senderId, receiverId,
//                        senderAddressId, receiverAddressId,
//                        size, pri
//                );
            }
        });
        logInLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginLoginPageTextField.getText();
                String password = new String(passwordLoginPagePasswordField.getPassword());
                String passwordFromDb = dbManager.getPasswordByLogin(login);
                Integer hash = password.hashCode();
                boolean passwordIsValid = password.hashCode() == Integer.parseInt(passwordFromDb);
                //ACCOUNT_TYPE: 0 - ADMIN, 1 - COURIER, 2 - CLIENT
                BigInteger accType = dbManager.getAccountTypeByLogin(login);

                if (passwordIsValid) {
                    mainWindowTabbedPane.setVisible(true);
                    loginTabbedPane.setVisible(false);
                    loginPagePanel.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Password is not valid! Try again");
                }
            }
        });
        registerLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPagePanel.setVisible(false);
                loginTabbedPane.setVisible(false);
                createNewAccountPagePanel.setVisible(true);
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAccountPagePanel.setVisible(false);
                loginTabbedPane.setVisible(true);
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextFieldNewAccountPage.getText();
                String surname = surnameTextFieldNewAccountPage.getText();
                String email = emailTextFieldNewAccountPage.getText();
                String phoneNumber = mobileNumberTextFieldNewAccountPage.getText();

                int day = (int) dayNewAccountPageSpinner.getValue();
                int month = (int) monthNewAccountPageComboBox.getSelectedIndex() + 1;
                int year = (int) yearNewAccountPageSpinner.getValue();
                LocalDate birthDate = LocalDate.of(year, month, day);


                char[] password1 = passwordPasswordFieldNewAccountPage.getPassword();
                char[] password2 = passwordAgainPasswordFieldNewAccountPage.getPassword();

//                address
                String countryName = countryTextFieldNewAccountPage.getText();
                String town = townTextFieldNewAccountPage.getText();
                String buildingNumber = buildingNumberTextFieldNewAccountPage.getText();
                String street = streetTextFieldNewAccountPage.getText();
                String postalCode = postalCodeTextFieldNewAccountPage.getText();

                BigInteger countryId = dbManager.getCountryIdByName(countryName);
                BigInteger addressId = dbManager.addAddress(town, street, buildingNumber, postalCode, countryId);
                if (Arrays.equals(password1, password2)) {
                    BigInteger loginDataId = dbManager.addLoginData(email, password1.toString());
                    BigInteger clientId = dbManager.addClient(name, surname, email, phoneNumber, addressId, birthDate, loginDataId);
                    loggedInClient = dbManager.getClient(clientId);

                    createNewAccountPagePanel.setVisible(false);
                    loginTabbedPane.setVisible(false);
                    mainWindowTabbedPane.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Passwords you entered are not the same, try again!");
                }
            }
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme");
        MainWindowForm form = new MainWindowForm();
        SpinnerModel sm = new SpinnerNumberModel(1, 1, 31, 1);
        form.dayNewAccountPageSpinner.setModel(sm);
        sm = new SpinnerNumberModel(2023, 1900, 2023, 1);
        form.yearNewAccountPageSpinner.setModel(sm);
    }
}
