package mybelly;

public class Belly {

    private int cukes;

    public void eatCukes(int cukes) {
        this.cukes = cukes;
    }

    public String getSound(int waitingTime) {
        if (cukes <= 20)
            return "silent";
        else if (waitingTime >= 1)
            return "growl";
        else
            return "silent";
    }
}
