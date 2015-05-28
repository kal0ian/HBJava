import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
	public String indexDir;
	public String dataDir;
	
	public LuceneTester(String indexDir,String dataDir) {
		// TODO Auto-generated constructor stub
		this.indexDir = indexDir;
		this.dataDir = dataDir;
	}
   //String indexDir = "/home/kal0ian/Downloads/IndexLuceneDir";
   //String dataDir = "/home/kal0ian/Downloads/DataLuceneDir";
   //String dataDirPath=System.getProperty("user.home");
   Indexer indexer;
   Searcher searcher;

   public static void main(String[] args) {
      LuceneTester tester;
      try {
    	 String indexDir = "/home/kal0ian/Downloads/IndexLuceneDir";
    	 String dataDir = "/home/kal0ian/Downloads/DataLuceneDir";
         tester = new LuceneTester(indexDir,dataDir);
         tester.createIndex();
         tester.search("ocean summer beach pesho");
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

   private void createIndex() throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndexOfFileSystem(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

   private void search(String searchQuery) throws IOException, ParseException{
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH));
      }
      searcher.close();
   }
}