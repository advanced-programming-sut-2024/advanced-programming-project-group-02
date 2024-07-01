package model;

import enums.Statement;

import java.util.Date;

public class Game {
    private final User activePlayer;
    private User player1;
    private User player2;
    private Date date;
    private EachPlayerGame GamePlayer1;
    private EachPlayerGame GamePlayer2;
    private Statement statement;
    private int turnNo;
    private int roundNo;

    public Game(User player1, User player2, EachPlayerGame gamePlayer1, EachPlayerGame gamePlayer2) {
        this.player1 = player1;
        this.player2 = player2;
        GamePlayer1 = gamePlayer1;
        GamePlayer2 = gamePlayer2;
        this.statement = Statement.notStartedYet;
        this.activePlayer = player1;
        turnNo = 1;
        roundNo = 1;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EachPlayerGame getGamePlayer1() {
        return GamePlayer1;
    }

    public void setGamePlayer1(EachPlayerGame gamePlayer1) {
        GamePlayer1 = gamePlayer1;
    }

    public EachPlayerGame getGamePlayer2() {
        return GamePlayer2;
    }

    public void setGamePlayer2(EachPlayerGame gamePlayer2) {
        GamePlayer2 = gamePlayer2;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public int getTurnNo() {
        return turnNo;
    }

    public void setTurnNo(int turnNo) {
        this.turnNo = turnNo;
    }

    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public User getActivePlayer() {
        return activePlayer;
    }

    @Override
    public String toString() {
        //TODO
        //uses in game history in profile menu
        return "";
    }
}