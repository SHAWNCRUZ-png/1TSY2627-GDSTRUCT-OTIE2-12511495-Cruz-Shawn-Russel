public class SimpleHashtable
{
    private Player[] hashtable;

    public SimpleHashtable()
    {
        hashtable = new Player[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    private int findIndex(String key)
    {
        int hashedKey = hashKey(key);
        int startingIndex = hashedKey;

        while (hashtable[hashedKey] != null && !hashtable[hashedKey].getName().equals(key))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;

            if (hashedKey == startingIndex)
            {
                return -1;
            }
        }
        return hashedKey;
    }

    public void put(String key, Player player)
    {
        int index = findIndex(key);

        if (index == -1 || (hashtable[index] != null && !hashtable[index].getName().equals(key)))
        {
            System.out.println("Sorry, the hashtable is completely full!");
            return;
        }

        hashtable[index] = player;
    }

    public Player get(String key)
    {
        int index = findIndex(key);

        if (index != -1 && hashtable[index] != null && hashtable[index].getName().equals(key))
        {
            return hashtable[index];
        }
        return null;
    }

    public Player remove(String key)
    {
        int index = findIndex(key);

        if (index == -1 || hashtable[index] == null || !hashtable[index].getName().equals(key))
        {
            return null;
        }

        Player removedPlayer = hashtable[index];
        hashtable[index] = null;

        int nextIndex = (index + 1) % hashtable.length;
        while (hashtable[nextIndex] != null)
        {
            Player playerToRehash = hashtable[nextIndex];
            hashtable[nextIndex] = null;

            put(playerToRehash.getName(), playerToRehash);

            nextIndex = (nextIndex + 1) % hashtable.length;
        }

        return removedPlayer;
    }

    public void printHashTable()
    {
        for(int i = 0; i < hashtable.length; i++)
        {
            System.out.println("Element in : " + i + " : " + hashtable[i]);
        }
    }
}
