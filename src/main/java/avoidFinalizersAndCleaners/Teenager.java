package avoidFinalizersAndCleaners;

class Teenager {

    public static void main(String[] args) {
        new Room(99);
        System.out.println("Cya!"); //method run() from Room.State class WILL NOT be called
        System.gc(); //adding System.gc() will call method run() from Room class
    }
}
