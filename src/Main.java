import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String script = "examples/fal.peloscope";
        try {
            String code = new String(Files.readAllBytes(Paths.get(script)));
            Lexer l = new Lexer(code);
            Parser p = new Parser(l.tokenize());
            new Evaluator().evaluate(p.parse());
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
}