import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.util.List;

import entity.*;

public class MainWindowForm extends JFrame {
    private JButton clickMEButton;
    private JPanel mainWindowPanel;
    private JTabbedPane mainWindowTabbedPane;
    private JTextField senderBuildingNumberTextField;
    private JTextField senderLastNameTextField;
    private JTextField senderEmailTextField;
    private JTextField senderFirstNameTextField;
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
    private JLabel senderFirstNameLabel;
    private JLabel senderBuildingNumberLabel;
    private JLabel senderLastNameLabel;
    private JLabel senderEmailLabel;
    private JLabel senderCityLabel;
    private JLabel senderStreetLabel;
    private JLabel mainPageEnterPackageIdLabel;
    private JPanel mainPagePanel;
    private JPanel addPackagePagePanel;
    private JPanel showAllPackagesPagePanel;
    private JLabel senderPhoneNumberLabel;
    private JTextField senderPhoneNumberTextField;
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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JCheckBox showPasswordCheckBox;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JSpinner dayNewAccountPageSpinner;
    private JComboBox monthNewAccountPageComboBox;
    private JSpinner yearNewAccountPageSpinner;
    private JButton button1;
    private JTextField textOnClick;
    private DBManager dbManager;

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
        setVisible(true);
        senderLabel.setFont(new Font("", Font.PLAIN, 16));
        receiverLabel.setFont(new Font("", Font.PLAIN, 16));
        packageLabel.setFont(new Font("", Font.PLAIN, 16));
        mainPageTrackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BigInteger id = new BigInteger(mainPagePackageIdTextField.getText());
                Object[] attributes = (Object[]) dbManager.getFullPackageInfo(id).get(0);
                mainPagePackageInfoTextArea.setText(DescribedPackageAttributes(attributes));
            }
        });
        mainWindowTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (mainWindowTabbedPane.getSelectedIndex() == 2){
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
        addPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger senderId = dbManager.addPerson(
                        senderFirstNameTextField.getText(),
                        senderLastNameTextField.getText(),
                        senderEmailTextField.getText(),
                        Integer.parseInt(senderPhoneNumberTextField.getText())
                );
                BigInteger receiverId = dbManager.addPerson(
                        receiverFirstNameTextField.getText(),
                        receiverLastNameTextField.getText(),
                        receiverEmailTextField.getText(),
                        Integer.parseInt(receiverPhoneNumberTextField.getText())
                );
                BigInteger senderAddressId = dbManager.addAddress(
                        senderCityTextField.getText(),
                        senderStreetTextField.getText(),
                        senderBuildingNumberTextField.getText(),
                        senderPostalCodeTextField.getText()
                );
                BigInteger receiverAddressId = dbManager.addAddress(
                        receiverCityTextField.getText(),
                        receiverStreetTextField.getText(),
                        receiverBuildingNumberTextField.getText(),
                        receiverPostalCodeTextField.getText()
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
                dbManager.addPackage(
                        senderId, receiverId,
                        senderAddressId, receiverAddressId,
                        size, pri
                );
            }
        });
        logInLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        registerLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
