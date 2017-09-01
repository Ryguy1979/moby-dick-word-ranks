package rylan.mobydick.fileio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordListBuilder {

	private List<String> wordList = new ArrayList<String>();
	
	public List<String> buildWordList(String filename) {
		try {
			URL url = getClass().getResource(filename);
			
			try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {
	            wordList = stream
	                    .map(String::toUpperCase)
	                    .collect(Collectors.toList());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        //wordList.forEach(System.out::println);	             

		} catch (URISyntaxException e) {
			System.out.println("Something went wrong with assigning the URI.");
			e.printStackTrace();
		}
		
        return wordList;			 
	}
}
