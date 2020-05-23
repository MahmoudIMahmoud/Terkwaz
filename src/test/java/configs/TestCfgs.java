package configs;

import configs.MyConfigReader;

public class TestCfgs {

	public static void main(String[] args) {
		String v = MyConfigReader.getCfgValue("Web.googlesearch.resultnum");
		System.out.println(v);

	}
}
