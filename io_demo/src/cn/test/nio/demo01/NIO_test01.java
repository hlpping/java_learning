package cn.test.nio.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

import org.junit.Test;

public class NIO_test01 {

	@Test
	public void test01() {

		// 开辟10个大小的缓冲区
		IntBuffer buf = IntBuffer.allocate(10);
		System.out.println("1.写入数据前的position,limit,capacity :");
		System.out.println("position: " + buf.position() + " limit: " + buf.limit() + " capacity: " + buf.capacity());
		int temp[] = { 5, 7, 9 };
		// 想缓冲区写入数据
		buf.put(3);
		buf.put(temp);
		System.out.println("2.写入数据后的position,limit,capacity :");
		System.out.println("position: " + buf.position() + " limit: " + buf.limit() + " capacity: " + buf.capacity());
		// 重设缓冲区
		buf.flip();

		System.out.println("3.准备输出数据前时position,limit,capacity :");
		System.out.println("position: " + buf.position() + " limit: " + buf.limit() + " capacity: " + buf.capacity());

		System.out.println("缓冲区中的内容:");
		// 只要缓冲区有内容
		while (buf.hasRemaining()) {
			// 去除当前内容并输出
			System.out.print(buf.get() + ",");
		}
	}

	@Test
	public void test02() {
		IntBuffer buf = IntBuffer.allocate(10);
		IntBuffer sub = null;
		for (int i = 0; i < 10; i++) {
			buf.put(i);
		}
		buf.position(2);
		buf.limit(6);
		sub = buf.slice();

		for (int i = 0; i < sub.capacity(); i++) {
			int temp = sub.get(i);
			sub.put(temp);
		}

		buf.slice();
		buf.limit(buf.capacity());

		System.out.println("主缓冲区的内容:");
		while (buf.hasRemaining()) {
			// 去除当前内容并输出
			System.out.print(buf.get() + ",");
		}
	}

	// 创建只读缓冲区
	@Test
	public void test03() {

		IntBuffer buf = IntBuffer.allocate(10);
		IntBuffer read = null;
		for (int i = 0; i < 10; i++) {
			buf.put(i);
		}

		read = buf.asReadOnlyBuffer();
		read.flip();

		System.out.println("缓冲区的内容:");
		while (read.hasRemaining()) {
			// 去除当前内容并输出
			System.out.print(read.get() + ",");
		}

	}

	@Test
	public void test04() {

		ByteBuffer buf = ByteBuffer.allocateDirect(10);

		byte temp[] = { 1, 3, 5, 7, 9 };
		buf.put(temp);
		buf.flip();
		System.out.println("缓冲区的内容:");
		while (buf.hasRemaining()) {
			// 去除当前内容并输出
			System.out.print(buf.get() + ",");
		}
	}

	@Test
	public void test05() throws IOException {

		String info[] = { "mldn", "mldnjava", "www.mldn.com", "www.mldn.cn", "lixinghua 理性化" };
		File file = new File("e:" + File.separator + "out.txt");
		FileOutputStream outputStream = null;
		outputStream = new FileOutputStream(file);

		FileChannel fileChannel = outputStream.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		for (int i = 0; i < info.length; i++) {
			buf.put(info[i].getBytes());
		}
		buf.flip();
		fileChannel.write(buf);
		fileChannel.close();
		outputStream.close();

	}

	@Test
	public void test06() throws IOException {

		File file1 = new File("e:" + File.separator + "in.txt");
		File file2 = new File("e:" + File.separator + "out.txt");

		FileInputStream inputStream = new FileInputStream(file1);
		FileOutputStream outputStream = new FileOutputStream(file2);

		FileChannel fin = inputStream.getChannel();
		FileChannel fout = outputStream.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		int temp = 0;
		while ((temp = fin.read(buf)) != -1) {
			buf.flip();
			fout.write(buf);
			buf.clear();
		}

		fin.close();
		fout.close();
		inputStream.close();
		outputStream.close();
	}

	@Test
	public void test07() throws IOException {

		File file1 = new File("e:" + File.separator + "in.txt");

		FileInputStream inputStream = new FileInputStream(file1);

		FileChannel fin = inputStream.getChannel();

		MappedByteBuffer mbuf = fin.map(FileChannel.MapMode.READ_ONLY, 0, file1.length());
		byte data[] = new byte[(int) file1.length()];

		int foot = 0;
		while (mbuf.hasRemaining()) {
			data[foot++] = mbuf.get();
		}
		System.out.println(new String(data));
		fin.close();
		inputStream.close();
	}

	@Test
	public void test08() throws IOException, Exception {

		File file1 = new File("e:" + File.separator + "in.txt");
		FileOutputStream output = new FileOutputStream(file1);
		FileChannel fout = output.getChannel();

		FileLock lock = fout.tryLock();
		if (lock != null) {
			System.out.println(file1.getName() + "锁定30秒");
			Thread.sleep(30 * 1000);
			lock.release();
			System.out.println(file1.getName() + "解除锁定");
		}

		fout.close();
		output.close();
	}

	@Test
	public void test09() {
		SortedMap<String, Charset> all = Charset.availableCharsets();
		Iterator<Entry<String, Charset>> it = all.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Charset> m = it.next();
			System.out.println(m.getKey() + "\t" + m.getValue());
		}
	}

	@Test
	public void test10() throws Exception {
		Charset latin1 = Charset.forName("GBK");
		CharsetEncoder encoder = latin1.newEncoder();
		CharsetDecoder decoder = latin1.newDecoder();

		CharBuffer cb = CharBuffer.wrap("撒娇凤凰是否合适积分是对话框");
		ByteBuffer buf = encoder.encode(cb);
		CharBuffer str = decoder.decode(buf);
		System.out.println(str);
	}

	@Test
	public void test11() throws IOException {

		int ports[] = { 8000, 8001, 8002, 8003 };
		Selector selector = Selector.open();
		for (int i = 0; i < ports.length; i++) {
			ServerSocketChannel initSer = ServerSocketChannel.open();
			initSer.configureBlocking(false);
			ServerSocket initSock = initSer.socket();
			InetSocketAddress address = new InetSocketAddress(ports[i]);
			initSock.bind(address);

			initSer.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println(ports[i] + "端口正在监听");
		}

		int keysAdd = 0;
		while ((keysAdd = selector.select()) > 0) {
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();

					SocketChannel client = server.accept();
					client.configureBlocking(false);

					ByteBuffer outBuf = ByteBuffer.allocate(1024);
					outBuf.put(("now : " + new Date()).getBytes());

					outBuf.flip();
					client.write(outBuf);
					client.close();
				}
			}
			selectedKeys.clear();
		}

	}

	@Test
	public void test12() {
	}

	@Test
	public void test13() {
	}

	@Test
	public void test14() {
	}

	@Test
	public void test15() {
	}

	@Test
	public void test16() {
	}
}
