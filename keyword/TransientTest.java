
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.*;

/**
 * Created by peijian280 on 17/2/14.
 */
public class TransientTest implements Serializable {

    //transient是类型修饰符,只能用来修饰字段。在对象序列号的过程中,标记为transient的字段不会被序列化
    private transient int num = 10;

    public static void main(String[] args) {
        TransientTest transientTest = new TransientTest();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("0xjh000")));
            out.writeObject(transientTest);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("0xjh000")));
            TransientTest tt;
            try {
                tt = (TransientTest) in.readObject();
                System.out.println(tt.num);      //输出结果：0
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
