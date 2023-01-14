package avoidFinalizersAndCleaners;

class Adult {

    public static void main(String[] args) throws Exception {
        try(Room room = new Room(7)){
            System.out.println("Goodbye."); //method run() from Room.State class will be called
        }
    }
}
