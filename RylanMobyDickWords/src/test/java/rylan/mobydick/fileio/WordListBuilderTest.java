package rylan.mobydick.fileio;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

public class WordListBuilderTest {

	@Test
	public void testBuildBookWordList() {
		WordListBuilder classUnderTest = new WordListBuilder();
		List<String> testBookWordList = classUnderTest.buildWordList("mobydick.txt");
		
		assertFalse(testBookWordList.isEmpty());
	}
	
	@Test
	public void testBuildStopWordList() {
		WordListBuilder classUnderTest = new WordListBuilder();
		List<String> testBookWordList = classUnderTest.buildWordList("stop-words.txt");
		
		assertFalse(testBookWordList.isEmpty());
	}
}
