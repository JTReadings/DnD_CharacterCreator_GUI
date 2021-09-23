class playerCharacter extends Creature {
    protected String race;
    protected String background;
    protected String clas;
    protected int level;

    playerCharacter()
    {
        race = "race";
        background = "background";
        clas = "clas";
        level = 1;
    }
    playerCharacter(String race, String background, String clas, int level)
    {
        this.race = race;
        this.background = background;
        this.clas = clas;
        this.level = level;
    }
    
}
