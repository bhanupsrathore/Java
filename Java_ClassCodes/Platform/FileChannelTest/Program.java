import java.nio.ByteBuffer;
import java.nio.channels.FileLock;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class Program {

	public static void main(String[] args) throws Exception {
		Path doc = Path.of(args[0]);
		try(FileChannel channel = FileChannel.open(doc, StandardOpenOption.READ, StandardOpenOption.WRITE)){	
			int n = (int)channel.size();
			FileLock lock = channel.lock();
			ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, n);
			Transformer.transform(buffer, n);
			lock.release();
		}
	}
}

