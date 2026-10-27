public class Main
{
    public static void main(String[] args)
    {
        Player ploo = new Player(134, "Plooful", 135);          // length 7  -> index 7
        Player subroza = new Player(4931, "Subroza", 604);      // length 7  -> collides! index 8
        Player annieDro = new Player(6919, "C9 Annie", 593);    // length 8  -> collides! index 9
        Player wardell = new Player(536, "TSM WardelL", 640);   // length 11 -> index 1
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34); // length 11 -> index 2

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(ploo.getName(), ploo);
        hashtable.put(wardell.getName(), wardell);
        hashtable.put(deadlyJimmy.getName(), deadlyJimmy);
        hashtable.put(subroza.getName(), subroza);
        hashtable.put(annieDro.getName(), annieDro);

        System.out.println("--- Initial Hashtable ---");
        hashtable.printHashTable();

        System.out.println("\n--- Removing 'Plooful' (index 7) ---");
        hashtable.remove("Plooful");

        System.out.println("\n--- Hashtable After Removal (Notice 'Subroza' shifted to fix the path) ---");
        hashtable.printHashTable();

        System.out.println("\n--- Testing Get after removal ---");
        System.out.println("Get Subroza: " + hashtable.get("Subroza"));
        System.out.println("Get C9 Annie: " + hashtable.get("C9 Annie"));
    }
}
