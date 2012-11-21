package lab.prada.j2me.zip;

import java.io.IOException;
import java.io.InputStream;

public class FilterInputStream extends InputStream {

	protected InputStream in;
	
	

	public FilterInputStream(InputStream in) {
		this.in = in;
//		this.pos = 0;
	}

	public int read() throws IOException {
//		pos++;
		return in.read();
		
	}

	public void close() throws IOException {
//		pos = -1;
		in.close();
	}
}
