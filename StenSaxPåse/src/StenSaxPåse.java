package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StenSaxPåse implements ActionListener {

    private JFrame frame;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;

    public StenSaxPåse() {
        frame = new JFrame("Rock Paper Scissors");
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        createGUI();
    }

    private void createGUI() {
        frame.setLayout(null);

        rockButton.setBounds(50, 50, 100, 50);
        paperButton.setBounds(50, 120, 100, 50);
        scissorsButton.setBounds(50, 190, 100, 50);

        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
//testar
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == rockButton || source == paperButton || source == scissorsButton) {
            String userChoice = ((JButton) source).getText();
            String computerChoice = generateComputerChoice();

            String result = determineWinner(userChoice, computerChoice);

            JOptionPane.showMessageDialog(null, "You chose: " + userChoice + "\nComputer chose: " + computerChoice + "\n" + result);
        }
    }

    private String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors"))
                || (userChoice.equals("Paper") && computerChoice.equals("Rock"))
                || (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer Wins!";
        }}}

    
