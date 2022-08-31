package espol.discoveringecuador.model;

public class Game {
    private Character mode;
    private Country country;
    private boolean win;
    private Integer points;
    private Integer fails;
    private Integer corrects;

    public Game(Character mode, Country country) {
        this.mode = mode;
        this.country = country;

    }

    public Game() {
    }

    public Character getMode() {
        return mode;
    }

    public void setMode(Character mode) {
        this.mode = mode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getFails() {
        return fails;
    }

    public void setFails(Integer fails) {
        this.fails = fails;
    }

    public Integer getCorrects() {
        return corrects;
    }

    public void setCorrects(Integer corrects) {
        this.corrects = corrects;
    }

    @Override
    public String toString() {
        return "Game: {" +
                "mode:" + mode +
                ", country:" + country +
                ", win:" + win +
                ", points:" + points +
                ", fails:" + fails +
                ", corrects:" + corrects +
                '}';
    }
}
