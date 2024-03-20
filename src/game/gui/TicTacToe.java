package game.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private static final int SIZE = 3;
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    private String currentPlayer = PLAYER_X;
    private Button[][] buttons = new Button[SIZE][SIZE];
    private int xWins = 0;
    private int oWins = 0;
    private int xLosses = 0;
    private int oLosses = 0;

    private Label xWinsLabel = new Label("Player X Wins: 0");
    private Label oWinsLabel = new Label("Player O Wins: 0");
    private Label xLossesLabel = new Label("Player X Losses: 0");
    private Label oLossesLabel = new Label("Player O Losses: 0");
    private Label resultLabel = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = createGrid();
        addButtons(gridPane);

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetGame());

        HBox countersBox = new HBox(10);
        countersBox.getChildren().addAll(xWinsLabel, oWinsLabel, xLossesLabel, oLossesLabel);
        countersBox.setAlignment(Pos.CENTER);

        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridPane, resetButton, countersBox, resultLabel);

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        return gridPane;
    }

    private void addButtons(GridPane gridPane) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setOnAction(e -> handleButtonClick(button));
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (button.getText().isEmpty() && resultLabel.getText().isEmpty()) {
            button.setText(currentPlayer);
            if (checkForWinner()) {
                displayWinner(currentPlayer);
            } else if (isBoardFull()) {
                displayDraw();
            } else {
                currentPlayer = (currentPlayer.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
            }
        }
    }

    private boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (buttons[i][0].getText().equals(currentPlayer)
                    && buttons[i][1].getText().equals(currentPlayer)
                    && buttons[i][2].getText().equals(currentPlayer)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < SIZE; i++) {
            if (buttons[0][i].getText().equals(currentPlayer)
                    && buttons[1][i].getText().equals(currentPlayer)
                    && buttons[2][i].getText().equals(currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(currentPlayer)
                && buttons[1][1].getText().equals(currentPlayer)
                && buttons[2][2].getText().equals(currentPlayer)) {
            return true;
        }

        if (buttons[0][2].getText().equals(currentPlayer)
                && buttons[1][1].getText().equals(currentPlayer)
                && buttons[2][0].getText().equals(currentPlayer)) {
            return true;
        }

        return false;
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

    private void displayWinner(String winner) {
        resultLabel.setText("Player " + winner + " wins!");
        updateCounters(winner);
    }

    private void displayDraw() {
        resultLabel.setText("It's a draw!");
        updateCounters("");
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

        xWinsLabel.setText("Player X Wins: " + xWins);
        oWinsLabel.setText("Player O Wins: " + oWins);
        xLossesLabel.setText("Player X Losses: " + xLosses);
        oLossesLabel.setText("Player O Losses: " + oLosses);
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
            }
        }

        currentPlayer = PLAYER_X;
        resultLabel.setText("");
    }
}
