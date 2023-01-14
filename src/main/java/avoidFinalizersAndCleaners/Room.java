package avoidFinalizersAndCleaners;

import java.lang.ref.Cleaner;

class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    //resources that require cleaning, CANNOT REFER TO ROOM CLASS
    private static class State implements Runnable {
        int numJunkPiles; //amount of rubbish heaps

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        //called by method close() or by cleaner
        @Override
        public void run() {
            System.out.println("Cleaning the room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
