package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeSwing extends JFrame {
    private static final int SIZE = 3;
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    private String currentPlayer = PLAYER_X;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private int xWins = 0;
    private int oWins = 0;
    private int xLosses = 0;
    private int oLosses = 0;
    private int draws = 0;

    private JLabel xWinsLabel = new JLabel("Player 1 Wins: 0");
    private JLabel oWinsLabel = new JLabel("Player 2 Wins: 0");
    private JLabel xLossesLabel = new JLabel("Player 1 Losses: 0");
    private JLabel oLossesLabel = new JLabel("Player 2 Losses: 0");
    private JLabel drawsLabel = new JLabel("Draws: 0");

    public TicTacToeSwing() {
        setTitle("Tic Tac Toe");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = createGridPanel();
        JPanel countersPanel = createCountersPanel();

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

        add(countersPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);
    }

    private JPanel createGridPanel() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(100, 100));
                button.addActionListener(new ButtonClickListener());
                buttons[i][j] = button;
                gridPanel.add(button);
            }
        }

        return gridPanel;
    }

    private JPanel createCountersPanel() {
        JPanel countersPanel = new JPanel();
        countersPanel.setLayout(new FlowLayout());

        countersPanel.add(xWinsLabel);
        countersPanel.add(oWinsLabel);
        countersPanel.add(xLossesLabel);
        countersPanel.add(oLossesLabel);
        countersPanel.add(drawsLabel);

        return countersPanel;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton.getText().isEmpty()) {
                clickedButton.setText(currentPlayer);
                if (checkForWinner()) {
                    updateCounters(currentPlayer);
                    resetGame();
                } else if (isBoardFull()) {
                    draws++;
                    updateCounters("");
                    resetGame();
                } else {
                    currentPlayer = (currentPlayer.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
                }
            }
        }
    }

    private boolean checkForWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < SIZE; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }

        return checkDiagonals();
    }

    private boolean checkRow(int row) {
        return buttons[row][0].getText().equals(currentPlayer)
                && buttons[row][1].getText().equals(currentPlayer)
                && buttons[row][2].getText().equals(currentPlayer);
    }

    private boolean checkColumn(int col) {
        return buttons[0][col].getText().equals(currentPlayer)
                && buttons[1][col].getText().equals(currentPlayer)
                && buttons[2][col].getText().equals(currentPlayer);
    }

    private boolean checkDiagonals() {
        return (buttons[0][0].getText().equals(currentPlayer) && buttons[1][1].getText().equals(currentPlayer) && buttons[2][2].getText().equals(currentPlayer))
                || (buttons[0][2].getText().equals(currentPlayer) && buttons[1][1].getText().equals(currentPlayer) && buttons[2][0].getText().equals(currentPlayer));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateCounters(String winner) {
        if (winner.equals(PLAYER_X)) {
            xWins++;
            oLosses++;
        } else if (winner.equals(PLAYER_O)) {
            oWins++;
            xLosses++;
        } else {
            xLosses++;
            oLosses++;
        }

        xWinsLabel.setText("Player 1 Wins: " + xWins);
        oWinsLabel.setText("Player 2 Wins: " + oWins);
        xLossesLabel.setText("Player 1 Losses: " + xLosses);
        oLossesLabel.setText("Player 2 Losses: " + oLosses);
        drawsLabel.setText("Draws: " + draws);
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
            }
        }

        currentPlayer = PLAYER_X;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeSwing ticTacToeSwing = new TicTacToeSwing();
            ticTacToeSwing.setVisible(true);
        });
    }
}
