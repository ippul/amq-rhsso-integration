import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println(Files.readString(Path.of("/home/ippul/development/git/amq-rhsso-integration/amq-clients-example/src/main/resources/log4j.xml")));
    }
    
}
