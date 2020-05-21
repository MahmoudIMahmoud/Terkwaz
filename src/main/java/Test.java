import java.io.File;

public class Test {

	public static void main(String[] args) {
		File f = new File("./resources/quality.png");
		String absolutePath = f.getAbsolutePath();
		System.out.println(f.getName());
	}
}
