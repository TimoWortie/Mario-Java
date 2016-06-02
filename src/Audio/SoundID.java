package Audio;

public enum SoundID {
    //template      (   id, name,           vol),
     
    //Music
    song        		(   1,  "song",        2),
    world1          (   2,  "athletic",     3),

     
    //Effects
    tot     		(   3,  "tot",        1),
    jump     		(   4,  "jump",         1),
    stomp	        (   5,  "stomp",         1),
    hit     		(   6,  "hit",  1),
    bounce		    (   7,  "bounce",  1),
    item           (   8,  "item",        1),
	appear           (  9,  "appear",        1);
     
    private int id;
    private String prefix = "res/";
    private String suffix = ".wav";
    private String name;
    // musicvol // effectvol // mastervol//
    private int[] volList = { -20, -10, -5};
    private int vol;
     
    SoundID(int id, String name, int vol) {
        this.id =id;
        this.name = name;
         
         
        for(int i = 0; i < volList.length; i++) {
            if(vol == i) {
                this.vol = volList[i];
            }
        }
    }
     
    public int getID() {
        return this.id;
    }
    public  String getPath() {
        return this.prefix + this.name + this.suffix;
    }
    public int getVolume() {
        return this.vol;
    }
}