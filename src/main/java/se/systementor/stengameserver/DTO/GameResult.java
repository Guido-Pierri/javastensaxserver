package se.systementor.stengameserver.DTO;

public class GameResult {
    private String winner;
    private String yourSelection;
    private String computerSelection;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getYourSelection() {
        return yourSelection;
    }

    public void setYourSelection(String yourSelection) {
        this.yourSelection = yourSelection;
    }

    public String getComputerSelection() {
        return computerSelection;
    }

    public void setComputerSelection(String computerSelection) {
        this.computerSelection = computerSelection;
    }
}
