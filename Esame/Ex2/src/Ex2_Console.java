public enum Ex2_Console {
    ARCADE("Arcade"),
    PC("Pc"),
    ATARI("Atari"),
    PS1("Ps1"),
    PS2("Ps2"),
    XBOX("Xbox"),
    XBOX360("Xbox360"),
    DS("Ds"),
    SWITCH("Switch"),
    SWITCH2("Switch2");

    private String consoleName;

    private Ex2_Console(String consoleName){
        this.consoleName = consoleName;
    }

    public String getConsoleName(){
        return consoleName;
    }
}
