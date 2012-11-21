package lab.prada.j2me.zip;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;

public class RandomAccessFile implements DataInput {

	// private BufferedInputStream is;
	private int pos = 0;
	private final int count;
	private byte[] data;

	public RandomAccessFile(byte[] data, String permission) {
		// this.is = new BufferedInputStream(new ByteArrayInputStream(data));
		this.data = data;
		this.count = data.length;

	}

	public synchronized void seek(int l) throws IOException {
		if (l < 0)
			throw new IOException();
		if (l > data.length)
			pos = data.length - 1;
		else
			pos = l;
	}

	public synchronized void close() throws IOException {
		// is.close();
		data = null;
	}

	public synchronized int read(byte[] b, int off, int len) throws IOException {
		if (b == null) {
			throw new NullPointerException();
		} else if ((off < 0) || (off > b.length) || (len < 0)
				|| ((off + len) > b.length) || ((off + len) < 0)) {
			throw new IndexOutOfBoundsException();
		}
		if (pos > data.length) {
			return -1;
		}
		if (pos + len > data.length) {
			len = data.length - pos;
		}
		if (len <= 0) {
			return 0;
		}
		System.arraycopy(data, pos, b, off, len);
		pos += len;
		return len;
	}

	public synchronized void readFully(byte[] b) throws IOException {
		readFully(b, 0, b.length);
	}

	public synchronized void readFully(byte[] b, int off, int len) throws IOException {
//		read(b, off, len);
        int n = 0;
    	do {
    	    int count = this.read(b, off + n, len - n);
    	    if (count < 0)
    		throw new EOFException();
    	    n += count;
    	} while (n < len);
		// System.out.println("read : " + read(b, off, len));
	}

	public synchronized int skipBytes(int n) throws IOException {
		 if (pos + n > count) {
	         n = count - pos;
	     }
	     if (n < 0) {
	         return 0;
	     }
	     pos += n;
	     return n;
	}

	public int length() throws IOException {
		return data.length;
	}

	public synchronized int read() throws IOException {
		// return is.read();
		// System.out.println("data.length ="+data.length+" currentPosition = "
		// + currentPosition);
		return (data.length <= pos) ? -1 : data[pos++] & 0xff;
	}

	public byte readByte() throws IOException {
		int ch = this.read();
		if (ch < 0)
			throw new IOException();
		return (byte) (ch);
	}

	public boolean readBoolean() throws IOException {
		return false;
	}
	
	public char readChar() throws IOException {
		return '0';
	}

	public double readDouble() throws IOException {
		return -1;
	}

	public float readFloat() throws IOException {
		return -1;
	}

	public int readInt() throws IOException {
		return -1;
	}

	public long readLong() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public short readShort() throws IOException {
		return -1;
	}

	public String readUTF() throws IOException {
		return null;
	}

	public int readUnsignedByte() throws IOException {
		return -1;
	}

	public int readUnsignedShort() throws IOException {
		return -1;
	}

	public void seek(long l) throws IOException {
		seek((int) l);
	}
}
