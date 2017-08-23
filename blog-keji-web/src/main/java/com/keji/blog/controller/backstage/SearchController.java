package com.keji.blog.controller.backstage;

import com.keji.blog.controller.javabean.ConfigInfo;
import com.keji.blog.util.FileUtil;
import com.keji.blog.util.JdbcUtil;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/10.
 */
@Controller
@ResponseBody
@RequestMapping("/search")
public class SearchController {
    private static final String INDEX_PATH = "D:\\develop\\temp\\index";
    private static final String SCAN_PATH = "D:\\Develop\\学习资料\\常用框架\\lucenne和solr\\资料\\searchsource";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/blog_keji?useUnicode=true&characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PWD = "root";

    @RequestMapping("/createIndex")
    public void createIndex() {
        IndexWriter indexWriter = null;
        try
        {
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            //Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();// 清除以前的index
            // 获取被扫描目录下的所有文件，包括子目录
            List<File> files = FileUtil.listAllFiles(SCAN_PATH);
            for(int i=0; i<files.size(); i++)
            {
                Document document = new Document();
                File file = files.get(i);
                document.add(new Field("content", FileUtil.readFile(file.getAbsolutePath(),"UTF-8"), TextField.TYPE_STORED));
                document.add(new Field("fileName", file.getName(), TextField.TYPE_STORED));
                document.add(new Field("filePath", file.getAbsolutePath(), TextField.TYPE_STORED));
                document.add(new Field("updateTime", file.lastModified()+"", TextField.TYPE_STORED));
                indexWriter.addDocument(document);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(indexWriter != null) indexWriter.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/createIndexFromDb")
    public void createIndexFromDb() {
        IndexWriter indexWriter = null;
        try {
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            //Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new IKAnalyzer(true);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();// 清除以前的index

            JdbcUtil jdbc = new JdbcUtil(JDBC_URL, USER, PWD);
            ResultSet rs = jdbc.query("select * from blog_article");
            while(rs.next()) {
                Document document = new Document();
                document.add(new Field("id", rs.getString("article_id"), TextField.TYPE_STORED));
                document.add(new Field("title", rs.getString("article_title"), TextField.TYPE_STORED));
                document.add(new Field("content", rs.getString("article_content"), TextField.TYPE_STORED));
                indexWriter.addDocument(document);
            }
            jdbc.closeAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(indexWriter != null) indexWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @RequestMapping("searchIndex")
    public void searchIndex(String keyWord) {
        DirectoryReader directoryReader = null;
        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
            // 4、创建搜索的Query
             Analyzer analyzer = new StandardAnalyzer();
//            Analyzer analyzer = new IKAnalyzer(true); // 使用IK分词

            // 简单的查询，创建Query表示搜索域为content包含keyWord的文档
//            Query query = new QueryParser("content", analyzer).parse(keyWord);

            String[] fields = {"fileName", "content"}; // 要搜索的字段，一般搜索时都不会只搜索一个字段
            // 字段之间的与或非关系，MUST表示and，MUST_NOT表示not，SHOULD表示or，有几个fields就必须有几个clauses
            BooleanClause.Occur[] clauses = {BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};
            // MultiFieldQueryParser表示多个域解析， 同时可以解析含空格的字符串，如果我们搜索"上海 中国"
            Query multiFieldQuery = MultiFieldQueryParser.parse(keyWord, fields, clauses, analyzer);

            //复杂查询
//            Query termQuery = new TermQuery(new Term("content", keyWord));// 词语搜索,完全匹配,搜索具体的域
//            Query wildqQuery = new WildcardQuery(new Term("content", keyWord));// 通配符查询
//            Query prefixQuery = new PrefixQuery(new Term("content", keyWord));// 字段前缀搜索
//            Query fuzzyQuery = new FuzzyQuery(new Term("content", keyWord));// 相似度查询,模糊查询比如OpenOffica，OpenOffice
//            BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
//            queryBuilder.add(multiFieldQuery, BooleanClause.Occur.SHOULD);
//            queryBuilder.add(termQuery, BooleanClause.Occur.SHOULD);
//            queryBuilder.add(wildqQuery, BooleanClause.Occur.SHOULD);
//            queryBuilder.add(prefixQuery, BooleanClause.Occur.SHOULD);
//            queryBuilder.add(fuzzyQuery, BooleanClause.Occur.SHOULD);
//            BooleanQuery query = queryBuilder.build(); // 这才是最终的query

            // 5、根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(multiFieldQuery, 100); // 搜索前100条结果
            System.out.println("共找到匹配处：" + topDocs.totalHits); // totalHits和scoreDocs.length的区别还没搞明白
            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            System.out.println("共找到匹配文档数：" + scoreDocs.length);

            QueryScorer scorer = new QueryScorer(multiFieldQuery, "content");
            // 自定义高亮代码
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<span style=\"backgroud:red\">", "</span>");
            Highlighter highlighter = new Highlighter(htmlFormatter, scorer);
            highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 7、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);
                //TokenStream tokenStream = new SimpleAnalyzer().tokenStream("content", new StringReader(content));
                //TokenSources.getTokenStream("content", tvFields, content, analyzer, 100);
                //TokenStream tokenStream = TokenSources.getAnyTokenStream(indexSearcher.getIndexReader(), scoreDoc.doc, "content", document, analyzer);
                //System.out.println(highlighter.getBestFragment(tokenStream, content));
                System.out.println("-----------------------------------------");
                System.out.println(document.get("fileName") + ":" + document.get("filePath"));
                System.out.println(highlighter.getBestFragment(analyzer, "content", document.get("content")));
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (directoryReader != null) directoryReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("searchFromIndex")
    public void searchFromIndex(String keyWord) {
        DirectoryReader directoryReader = null;
        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
            // 4、创建搜索的Query
             Analyzer analyzer = new StandardAnalyzer();
//            Analyzer analyzer = new IKAnalyzer(true); // 使用IK分词

            // 简单的查询，创建Query表示搜索域为content包含keyWord的文档
            //Query query = new QueryParser("content", analyzer).parse(keyWord);

            String[] fields = {"title", "content"};
            // MUST 表示and，MUST_NOT 表示not ，SHOULD表示or
            BooleanClause.Occur[] clauses = {BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};
            // MultiFieldQueryParser表示多个域解析， 同时可以解析含空格的字符串，如果我们搜索"上海 中国"
            Query multiFieldQuery = MultiFieldQueryParser.parse(keyWord, fields, clauses, analyzer);

            // 5、根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(multiFieldQuery, 100); // 搜索前100条结果
            System.out.println("共找到匹配处：" + topDocs.totalHits);
            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            System.out.println("共找到匹配文档数：" + scoreDocs.length);

            QueryScorer scorer = new QueryScorer(multiFieldQuery, "content");
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<span style=\"backgroud:red\">", "</span>");
            Highlighter highlighter = new Highlighter(htmlFormatter, scorer);
            highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 7、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);
                String content = document.get("content");
                //TokenStream tokenStream = new SimpleAnalyzer().tokenStream("content", new StringReader(content));
                //TokenSources.getTokenStream("content", tvFields, content, analyzer, 100);
                //TokenStream tokenStream = TokenSources.getAnyTokenStream(indexSearcher.getIndexReader(), scoreDoc.doc, "content", document, analyzer);
                //System.out.println(highlighter.getBestFragment(tokenStream, content));
                System.out.println("-----------------------------------------");
                System.out.println("文章标题："+document.get("title"));
                System.out.println("文章内容：");
                System.out.println(highlighter.getBestFragment(analyzer, "content", content));
                System.out.println("");
                // 8、根据Document对象获取需要的值
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(directoryReader != null) directoryReader.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
