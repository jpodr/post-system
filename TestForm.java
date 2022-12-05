import javax.swing.*;
import java.awt.*;

public class TestForm extends JFrame {
    private JButton clickMEButton;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel SenderLabel;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel ReceiverLabel;
    private JComboBox comboBox1;
    private JButton addPackageButton;
    private JLabel PackageLabel;
    private JList PackagesList;
    private JTextArea PackageInfoTextArea;
    private JTextField textField8;
    private JButton treckButton;
    private JTextArea MainPackageInfoTextArea;
    private JTextField textOnClick;

    public TestForm() {
        setContentPane(panel1);
        setTitle("Test form");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        SenderLabel.setFont(new Font("", Font.PLAIN, 16));
        ReceiverLabel.setFont(new Font("", Font.PLAIN, 16));
        PackageLabel.setFont(new Font("", Font.PLAIN, 16));
    }

    public static void main(String[] args) {

        TestForm form = new TestForm();
    }
}
