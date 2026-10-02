import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Easy3 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy3() {

        prepareGUI();
    }

    public static void main(String[] args) {
        Easy3 swingControlDemo = new Easy3();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        ta = new JTextArea(); // area that you can type in
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        mainFrame.add(mb);  //add menu bar
        mainFrame.add(ta);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel(); // panel is an invisiable area put on the mainframe for a specific purposes
        //  controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel - Flow small + in middle
        controlPanel.setLayout(new BorderLayout());

        // BorderLayout - 5 zones (N,S,E,W,Center)

        //put things in order - order matters
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);




    }

    private void showEventDemo() {

        JButton Button1 = new JButton("1");
        JButton Button2 = new JButton("2");
        JButton Button3 = new JButton("3");

        Button1.setActionCommand("1");
        Button2.setActionCommand("2");
        Button3.setActionCommand("3");

//        okButton.addActionListener(new ButtonClickListener());
//        submitButton.addActionListener(new ButtonClickListener());
//        cancelButton.addActionListener(new ButtonClickListener());

//        controlPanel.add(button1);
//        controlPanel.add(submitButton);
//        controlPanel.add(cancelButton);

        controlPanel.add(Button1, BorderLayout.WEST);
        controlPanel.add(Button2, BorderLayout.CENTER);
        controlPanel.add(Button3, BorderLayout.EAST);

        mainFrame.setVisible(true); // every time a change happens
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}
