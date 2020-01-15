package stringman;

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Decloration dec = new Decloration();
		String[] words = dec.wordList();
		HashMap<String, Integer> wordsHashMap = new HashMap<String, Integer>();

		for (String w: words)
		{
			if (wordsHashMap.get(w.toLowerCase()) != null)
			{
				Integer wordCount = wordsHashMap.get(w.toLowerCase());
				wordCount += 1;
				wordsHashMap.put(w.toLowerCase(), wordCount);
			} else {
				wordsHashMap.put(w.toLowerCase(), 1);
			}
		}

		// for (Map.Entry w : wordsHashMap.entrySet())
		// {
		// 	String key = (String)w.getKey();
		// 	int value = (int)w.getValue();
		// 	System.out.println(key + ": " + value);
		// }

		ArrayList<Map.Entry<String, Integer>> sortedMap = new ArrayList<Map.Entry<String, Integer>>();
		sortedMap.addAll(wordsHashMap.entrySet());

		Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer>>()
		{
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				if (o1.getValue() == o2.getValue())
				{
					return 0;
				} else if (o1.getValue() < o2.getValue())
				{
					return 1;
				} else {
					return -1;
				}
			}
		});
		int count = 1;
		for (Map.Entry hm: sortedMap)
		{
			if (count <=50 )
			{
				System.out.println(hm.getKey() + ": " + hm.getValue());
			} else {
				break;
			}
			count++;
		}

	}
}
