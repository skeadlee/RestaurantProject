package models;


public enum TimeSlot{

    SEVEN(1900),
    SEVENTHIRTY(1930),
    EIGHT(2000),
    EIGHTTHIRTY(2300),
    NINE(2100),
    NINETHIRTY(2130),
    TEN(2200),
    TENTHIRTY(2230),
    ELEVEN(2300);

    private int time;

    TimeSlot(int time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
