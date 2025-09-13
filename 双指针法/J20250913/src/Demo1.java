import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        /*File file = new File("./test");
        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.exists());

        System.out.println("=========");
        File file1 = new File("d:/test.txt");
        System.out.println("getname = "+ file1.getName());
        System.out.println("getParent = " + file1.getParent());
        System.out.println("getParentFile = "+file1.getParentFile());
        System.out.println("getPath = " + file1.getPath());
        System.out.println("getAbsolutePath = " + file1.getAbsolutePath());
        System.out.println("getCanonicalPath = " + file1.getCanonicalPath());
        file1.delete();
        System.out.println(file1.exists());*/

        /*File file = new File("d:/Code/J2025/Practise/test.txt");//默认不会创建
        //手动创建文件
        //有返回值 最好确认
        System.out.println(file.createNewFile());
        System.out.println("exists = " + file.exists());
        System.out.println("isFile = " + file.isFile());
        System.out.println("isDirectory = "+  file.isDirectory());
        File file1 = new File("d:/code/J2025/test.txt");*/
//        File[] files = file1.listFiles();
//        assert files != null;
//        for(File files2 : files) {
//            System.out.println(files2.getName());
//        }
//        System.out.println(file.renameTo(file1));

        /*Reader reader = new FileReader("d:/code/J2025/test.txt");
        System.out.println(reader.read());*/

        //创建目录
        /*File file = new File("./aaa/建材老王");
        System.out.println(file.mkdirs());*/

        /*File file1 = new File("./bbb");
        System.out.println(file1.mkdir());

        File file2 = new File("./test.jpg");
        System.out.println(file2.createNewFile());*/


        /*File file = new File("d:/code/J2025/test.txt");
        File file1 = new File("D:/Code/J2025/J20250913/test.txt");
        System.out.println(file.renameTo(file1));*/

        /*InputStream inputStream = new FileInputStream("D:/Code/J2025/J20250913/test.txt");
        while (true) {
            // 由于不知道文件大小, 可能很大, 超过了 1024.
            // 即使是使用 read 的版本二, 也需要搭配 循环.
            byte[] bytes = new byte[1024];
            int n = inputStream.read(bytes);
            if (n == -1) {
                // 读到文件末尾了.
                break;
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%x\n", bytes[i]);
            }
        }*/


        File file1 = new File("./test1.txt");
        System.out.println(file1.createNewFile());
        Reader reader = new FileReader(file1.getName());
        while (true) {
            char[] chars = new char[100000];
            int n = reader.read(chars);
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
    }

}
