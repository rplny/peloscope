import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int pos = 0;
    public Lexer(String input) { this.input = input; }
    private char peek() { return pos >= input.length() ? '\0' : input.charAt(pos); }
    private char advance() { return pos >= input.length() ? '\0' : input.charAt(pos++); }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (pos < input.length()) {
            char current = peek();
            if (Character.isWhitespace(current)) { advance(); continue; }
            if (current == ';') { tokens.add(new Token(TokenType.SEMICOLON, ";")); advance(); continue; }
            if (current == ',') { tokens.add(new Token(TokenType.COMMA, ",")); advance(); continue; }
            if (current == '+') { tokens.add(new Token(TokenType.PLUS, "+")); advance(); continue; }
            if (current == '-') { tokens.add(new Token(TokenType.MINUS, "-")); advance(); continue; }
            if (current == '(') { tokens.add(new Token(TokenType.LPAREN, "(")); advance(); continue; }
            if (current == ')') { tokens.add(new Token(TokenType.RPAREN, ")")); advance(); continue; }
            if (current == '{') { tokens.add(new Token(TokenType.LBRACE, "{")); advance(); continue; }
            if (current == '}') { tokens.add(new Token(TokenType.RBRACE, "}")); advance(); continue; }
            if (current == '=') {
                advance();
                if (peek() == '=') { tokens.add(new Token(TokenType.EQUALS, "==")); advance(); }
                else { tokens.add(new Token(TokenType.ASSIGN, "=")); }
                continue;
            }
            if (current == '"') {
                advance(); StringBuilder sb = new StringBuilder();
                while (peek() != '"' && peek() != '\0') { sb.append(advance()); }
                advance(); tokens.add(new Token(TokenType.STRING, sb.toString()));
                continue;
            }
            if (Character.isDigit(current)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(peek())) { sb.append(advance()); }
                tokens.add(new Token(TokenType.NUMBER, sb.toString())); continue;
            }
            if (Character.isLetter(current) || current == '_') {
                StringBuilder sb = new StringBuilder();
                while (Character.isLetterOrDigit(peek()) || peek() == '_') { sb.append(advance()); }
                String str = sb.toString();
                switch (str) {
                    case "yildiz": tokens.add(new Token(TokenType.YILDIZ, str)); break;
                    case "kehanet": tokens.add(new Token(TokenType.KEHANET, str)); break;
                    case "retro": tokens.add(new Token(TokenType.RETRO, str)); break;
                    case "ilerleme": tokens.add(new Token(TokenType.ILERLEME, str)); break;
                    case "dolunay": tokens.add(new Token(TokenType.DOLUNAY, str)); break;
                    case "fal": tokens.add(new Token(TokenType.FAL, str)); break;
                    case "tuval_ac": tokens.add(new Token(TokenType.TUVAL_AC, str)); break;
                    case "iz_birak": tokens.add(new Token(TokenType.IZ_BIRAK, str)); break;
                    case "kose_don": tokens.add(new Token(TokenType.KOSE_DON, str)); break;
                    case "gokyuzu": case "yeryuzu": tokens.add(new Token(TokenType.BOOLEAN, str)); break;
                    default: tokens.add(new Token(TokenType.IDENTIFIER, str)); break;
                }
                continue;
            }
            throw new RuntimeException("Lexical Error: " + current);
        }
        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}