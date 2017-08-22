package hello.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by scnyig on 8/16/2017.
 */
public class Transfer {
    public void transferFrom() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count    = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void transferTo() {
        try{
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel      fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count    = fromChannel.size();

            fromChannel.transferTo(position, count, toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
