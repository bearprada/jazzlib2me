package lab.prada.j2me.zip;

import java.io.IOException;
import java.io.InputStream;

public class ProxyInflaterInputStream extends InputStream {

	private final int available;
	protected int pos = 0;
	private InputStream realInputStream;

	public ProxyInflaterInputStream(InputStream in, int totalSize) {
		realInputStream = in;
		available = totalSize;
	}

	public int available() throws IOException {
		return available - pos;
	}

	public long skip(long n) throws IOException {
		int r = (int) realInputStream.skip(n);
		pos += r;
		return r;
	}

	public final int read() throws IOException {
		int r = realInputStream.read();
		if (r != -1)
			pos++;
		return r;
	}

	public final int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	public final int read(byte[] b, int off, int len) throws IOException {
		int tmp;
		int r = 0; 
		while(r<len){
			tmp = realInputStream.read(b, off + r , len - r );
			if (tmp != -1)
				r+=tmp;
		}
		pos += r;
		return r;
	}

	public final void close() throws IOException {
		realInputStream.close();
	}

	public final void mark(int readlimit) {
		realInputStream.mark(readlimit);
	}

	public final void reset() throws IOException {
		realInputStream.reset();
	}
	
	public final boolean markSupported(){
		return realInputStream.markSupported();
	}
}
