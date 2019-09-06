package p.hh.trymvc.ter.controller;

public class TerException extends RuntimeException {
    private String type;

    public TerException(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
