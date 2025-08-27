public class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();
            System.out.println("Falling asleep");
        }
    }
}


// task2.1
// Television can't be public
class Television {
    private int channel;
    private boolean on;

    public Television() {
        channel = 1; //default channel
        on = false;  //initial state is off
    }

    public void setChannel(int c) {
        // channel should loop between 1 and 10
        if (c < 1) {
            channel = 10;
        } else if (c > 10) {
            channel = 1;
        } else {
            channel = c;
        }
    }

    public int getChannel() {
        return channel;
    }

    public void pressOnOff() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }
}