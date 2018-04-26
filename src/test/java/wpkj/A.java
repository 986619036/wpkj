package wpkj;

import org.mybatis.generator.api.ShellRunner;

public class A {
	public static void main(String[] args) {
        args = new String[] { "-configfile", "src\\main\\resources\\mybatis-generator-config.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
