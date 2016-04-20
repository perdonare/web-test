import com.lance.sax.SaxXmlHandler;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2016/4/18.
 */
public class SaxXmlTest {
    @Test
    public void testSax() throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxXmlHandler saxXmlHandler = new SaxXmlHandler("bean");

        saxParser.parse(new File("D:\\源码\\个人\\web-test\\src\\main\\resources\\spring-config.xml"),saxXmlHandler);
        List<Map<String,String>> mapList =  saxXmlHandler.getParsedList();
        System.out.println(mapList);
    }
}
