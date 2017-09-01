package rylan.mobydick.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rylan.mobydick.util.MapUtil;

public class BookWordListHandler {
	
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();

	public Map<String, Integer> handleWordLists(List<String> rankedWordList, List<String> stopWordList) {
		List<String> handledList = rankedWordList;
		 
		Object[] bookWordArray = handledList.toArray();
		for (Object o : bookWordArray) {
			String[] wordsArray = o.toString().replaceAll("[—|-]", " ").replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for (String s : wordsArray) {
				if (s != null && !s.isEmpty()) {
					//System.out.println(s);
					pushWordsToMap(s);
				}
			}
		}		

		removeStopWords(stopWordList);
		wordMap = MapUtil.sortByValue(wordMap);		
		
		return wordMap;
	}

	private void pushWordsToMap(String s) {
		if (!wordMap.containsKey(s)) {
			wordMap.put(s, 1);	
			//System.out.println("Map has a key of " + s + " and a value of " + wordMap.get(s));			
		} else if(wordMap.containsKey(s)) {
			int count = wordMap.get(s);
			wordMap.put(s, ++count);
			//System.out.println("Map has a key of " + s + " and a value of " + wordMap.get(s));
		}
	}

	private void removeStopWords(List<String> stopWordList) {
		for (String stopWord : stopWordList) {
			if (wordMap.containsKey(stopWord.toLowerCase())) {
				wordMap.remove(stopWord.toLowerCase());
			}
		}		
	}
}
