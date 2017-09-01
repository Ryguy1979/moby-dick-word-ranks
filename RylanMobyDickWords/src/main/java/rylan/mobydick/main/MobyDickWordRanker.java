package rylan.mobydick.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rylan.mobydick.fileio.WordListBuilder;
import rylan.mobydick.handler.BookWordListHandler;

public class MobyDickWordRanker {

	public static void main(String[] args) {
		int iterator = 1;
		WordListBuilder listBuilder = new WordListBuilder();
		BookWordListHandler listHandler = new BookWordListHandler();
		List<String> rankedWordList = new ArrayList<String>();
		List<String> stopWordList = new ArrayList<String>();
		
		rankedWordList = listBuilder.buildWordList("mobydick.txt");
		stopWordList = listBuilder.buildWordList("stop-words.txt");
		
        Map<String, Integer> wordMap = listHandler.handleWordLists(rankedWordList, stopWordList);	 
        
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			System.out.println("Number " + iterator + " most used word = " + entry.getKey() + ", times used = " + entry.getValue());
			iterator++;
			//ugly, but it works!
			if (iterator > 100) {
				break;
			}
		}
	}

}
