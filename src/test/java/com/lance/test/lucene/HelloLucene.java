package com.lance.test.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by perdonare on 2015/6/6.
 */
public class HelloLucene {

    /**
     * 第一个lucence程序  创建索引
     * 1.创建directory
     * 2.创建IndexWriter
     * 3.创建Document对象
     * 4.为Document添加Field
     * 5.通过IndexWriter添加文档到索引中
     */
    @Test
    public void testWriterHelloWorld() throws Exception {
        //Directory directory = new RAMDirectory();//在内存中建立
        Directory directory = FSDirectory.open(Paths.get("e:/test/lucene/index"));
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory,iwc);
        File file = new File("e:/test/lucene/file");
        for (File f : file.listFiles()){
            System.out.println(f.getAbsolutePath());
            Document document = new Document();
            Field pathField = new StringField("path",f.getAbsolutePath(),Field.Store.YES);
            FileReader fileReader = new FileReader(f);
            Field contentField = new TextField("content",new FileReader(f));
            document.add(pathField);
            document.add(contentField);
            indexWriter.addDocument(document);
            fileReader.close();
        }
        indexWriter.close();
    }

    /**
     * 第一个lucence程序  查询
     * 1.创建Directory
     * 2.创建IndexReader
     * 3.根据IndexReader创建IndexSerchaer
     * 4.创建搜索的Query
     * 5.根据Searcher搜索并返回TopDocs
     * 6.根据TopDocs获取ScoreDoc
     * 7.根据Searcher和ScoredDoc对象获取具体的Document对象
     * 8.根据Document对象获取需要的值
     * 9.关闭IndexReader
     */
    @Test
    public void testSearcherHelloWorld() throws Exception {
        Directory directory = FSDirectory.open(Paths.get("e:/test/lucene/index"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Analyzer analyzer = new StandardAnalyzer();
        QueryParser queryParser = new QueryParser("content",analyzer);
        Query query = queryParser.parse("java");
        TopDocs topDocs = indexSearcher.search(query,10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println(document.get("path"));
        }
        indexReader.close();

    }
}
