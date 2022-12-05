import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
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
    private JTextField textOnClick;

    public MainWindowForm() {
        setContentPane(mainWindowPanel);
        setTitle("PW Post");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        senderLabel.setFont(new Font("", Font.PLAIN, 16));
        receiverLabel.setFont(new Font("", Font.PLAIN, 16));
        packageLabel.setFont(new Font("", Font.PLAIN, 16));
        mainPageTrackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger id = new BigInteger(mainPagePackageIdTextField.getText());
            }
        });
    }

    public static void main(String[] args) {


        MainWindowForm form = new MainWindowForm();
    }
}
