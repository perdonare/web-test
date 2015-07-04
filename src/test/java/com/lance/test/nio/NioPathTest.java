package com.lance.test.nio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by perdonare on 2015/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class NioPathTest {

    /**
     * 获取文件路径下的文件
     */
    @Test
    public void testNio1(){
        Path path = Paths.get("e:/data1.txt");
        FileSystem fileSystem = path.getFileSystem();
        System.out.println(fileSystem.getSeparator());
        Path path2 = Paths.get("e:/","data1.txt");
        FileSystem fileSystem2 = path2.getFileSystem();
        System.out.println(fileSystem2.getSeparator());
    }

    /**
     * 使用通配符 . 和 .. 代表当前目录和上级目录
     */
    @Test
    public void testNio2(){
        String path = "d:/a/b/./c/d/../f/g.txt";
        Path path1 = Paths.get(path);
        Path path2 = Paths.get(path).normalize();
        System.out.println(path1); //输出 d:\a\b\.\c\d\..\f\g.txt
        System.out.println(path2); //输出 d:\a\b\c\f\g.txt
    }

    /**
     * 获取路径的其他两种方法
     */
    @Test
    public void testNio3(){
        Path path = FileSystems.getDefault().getPath("d:/a/b/./c/d/../f/g.txt");//使用FileSystems对象获取路径
        System.out.println(path);
    }

    /**
     * 获取home目录
     */
    @Test
    public void testNio4(){
        Path path = Paths.get(System.getProperty("user.home"),"download","test.txt");
        System.out.println(path);//输出 C:\Users\perdonare\download\test.txt
    }

    /**
     * 获取给定路径下的文件或者文件夹名称
     * 获取父目录
     * 获取子目录
     */
    @Test
    public void testNio5(){
        String pathStr1 = "d:/a/b/c";
        String pathStr2 = "d:/a/b/c.txt";
        Path path = Paths.get(pathStr1);
        Path path2 = Paths.get(pathStr2);
        System.out.println(path.getFileName());     //输出    c
        System.out.println(path2.getFileName());    //输出    c.txt

        System.out.println(path.getParent());       //输出    d:\a\b
        System.out.println(path2.getParent());      //输出    d:\a\b

        //注意 输出不包含盘符 索引以0开始
        System.out.println(path.subpath(1,2));     //输出    b
        System.out.println(path.subpath(0,2));     //输出    a\b
    }

    /**
     * 路径的转换
     * 1.将 Path 转换为 String
     * 2.将 Path 转换为 URI
     * 3.将相对路径转换为绝对路径
     * 4.将 Path 转换为真实路径
     * 5.将 Path 转换为 File
     */
    @Test
    public void testNio6() throws IOException {
        //注意 /b/c.txt 和 b/c.txt的区别
        String pathStr = "/b/c.txt";
        Path path = Paths.get(pathStr);
        String pathString = path.toString();        //将 Path 转换为 String
        System.out.println(pathString);             //输出    \b\c.txt

        URI uri = path.toUri();                     //将 Path 转换为 URI
        System.out.println(pathString);             //输出

        Path absolutePath = path.toAbsolutePath();  //获取绝对路径
        System.out.println(absolutePath);           //输出    E:\b\c.txt

        Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS); //回一个已存在的文件的真实路径
        System.out.println(realPath);               //输出    抛出异常，因为没有 E:\program\git\web-test\b\c.txt这个文件

        File file = path.toFile();
        Path filePath = new File(pathStr).toPath();
    }

    /**
     * 1.合并两个path
     * 2.替换最后一个文件或者目录
     */
    @Test
    public void testNio7() {
        Path base = Paths.get("c:/a/b/c");

        Path path = base.resolve("d.txt");          //合并两个path
        System.out.println(path);                   //输出    c:\a\b\c\d.txt

        Path path2 = base.resolveSibling("d.txt");  //替换最后一个目录或者文件
        System.out.println(path2);                  //输出    c:\a\b\d.txt
    }

    /**
     * 文件导航
     */
    @Test
    public void testNio8() {
        Path path = Paths.get("/a/b/c/d.txt");
        Path path2 = Paths.get("/a/b/c/d/e.txt");
        Path relativizePath = path.relativize(path2);                     //从path导航到path2
        System.out.println(relativizePath);                               //输出  ..\d\e.txt
    }

    /**
     * 判断两个文件路径是否为同一个
     */
    @Test
    public void testNio9() throws IOException {
        Path path = Paths.get("/a/b/c.txt");
        System.out.println(path.toAbsolutePath());
        Path path2 = Paths.get("E:/a/b/c.txt");

        boolean strBool = path.equals(path2);                       //这种方式判断不会判断文件是否存在
        System.out.println(strBool);                                //输出    false

        boolean fileBool = Files.isSameFile(path,path2);            //使用这种方式比较会判断文件是否存在
        System.out.println(fileBool);                               //输出    false
    }

    /**
     * 迭代path中所有元素
     */
    @Test
    public void testNio10(){
        Path path = Paths.get("/a/b/c/d/d.txt");
        for (Path p : path) {
            System.out.println(p);
        }
        //输出 a  b   c   d   d.txt
    }

    /**
     * 通过获取属性   文件视图的使用 忽略
     */
    @Test
    public void testNio11() throws IOException {
        BasicFileAttributes attr = null;
        Path path = Paths.get("e:/", "data1.txt");

        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("File size: " + attr.size());
        System.out.println("File creation time: " + attr.creationTime());
        System.out.println("File was last accessed at: " + attr.lastAccessTime());
        System.out.println("File was last modified at: " + attr.lastModifiedTime());

        System.out.println("Is directory? " + attr.isDirectory());
        System.out.println("Is regular file? " + attr.isRegularFile());
        System.out.println("Is symbolic link? " + attr.isSymbolicLink());
        System.out.println("Is other? " + attr.isOther());
        //输出
        /*
         *      File size: 0
         *      File creation time: 2015-05-23T13:25:19.981845Z
         *      File was last accessed at: 2015-05-23T13:25:19.981845Z
         *      File was last modified at: 2015-06-04T15:15:27.148306Z
         *      Is directory? false
         *      Is regular file? true
         *      Is symbolic link? false
         *      Is other? false
        */

        //获取单个属性支持
        /**
         *      Basic 属性视图支持的属性名称如下：
         *      lastModifiedTime
         *      lastAccessTime
         *      creationTime
         *      size
         *      isRegularFile
         *      isDirectory
         *      isSymbolicLink
         *      isOther
         *      fileKey
         */

        /**
         *      DOS 属性视图支持以下属性名称：
         *      hidden
         *      readonly
         *      system
         *      archive
         **/

        /**
         *      File Owner 支持以下属性名称：
         *      owne
         */

        /**
         *      Posix 属性视图支持以下属性名：
         *      group
         *      permissions
         */

        /**
         *      ACL 属性视图支持以下属性名称：
         *      acl
         *      owner
         */

        //获取单个属性
        String fileSize = Files.getAttribute(path,"basic:size",LinkOption.NOFOLLOW_LINKS).toString();
        System.out.println(fileSize);       //输出        12
    }

    /**
     * 检查文件的属性
     */
    @Test
    public void testNio12() throws IOException {
        String str = "e:/data1.txt";
        Path path = Paths.get(str);
        boolean isExists = Files.exists(path);
        boolean isNotExists = Files.notExists(path);
        System.out.println(isExists);       //输出    true
        System.out.println(isNotExists);    //输出    false

        /**
         * 其他属性
         */
        boolean is_readable = Files.isReadable(path);
        boolean is_writable = Files.isWritable(path);
        boolean is_executable = Files.isExecutable(path);
        boolean is_regular = Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS);
        boolean is_hidden = Files.isHidden(path);
    }

    /**
     * 迭代目录下的目录或者文件
     * 迭代创建文件夹或 如果存在则返回
     */
    @Test
    public void testNio13() throws IOException {
        Iterable<Path> paths = FileSystems.getDefault().getRootDirectories();
        for (Path path : paths) {
            System.out.println(path);
        }
        //输出  C:\   D:\ E:\ F:\

        Path path = Paths.get("d:/");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        }catch(IOException e) {
            System.err.println(e);
        }

        Files.createDirectories(Paths.get("e:/a/b/c/d.txt"));       //注意这里创建的是d.txt文件夹而不是文件

    }



}
