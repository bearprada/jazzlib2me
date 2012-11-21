package lab.prada.j2me.zip;

import java.io.IOException;
import java.io.OutputStream;

public class FilterOutputStream extends OutputStream {

	protected OutputStream out;

	public FilterOutputStream(OutputStream os) {
		this.out = os;
	}

	public void write(int arg0) throws IOException {
		out.write(arg0);
	}

	public void close() throws IOException {
		out.close();
	}

}
