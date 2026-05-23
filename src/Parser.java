import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;
    public Parser(List<Token> t) { this.tokens = t; }
    private Token peek() { return tokens.get(current); }
    private Token advance() { return tokens.get(current++); }
    private boolean isAtEnd() { return peek().type == TokenType.EOF; }
    private void consume(TokenType type, String msg) { if (peek().type == type) { advance(); return; } throw new RuntimeException("Syntax Error: " + msg); }

    public AST.ProgramNode parse() {
        List<AST.Node> stmts = new ArrayList<>();
        while (!isAtEnd()) { stmts.add(parseStatement()); }
        return new AST.ProgramNode(stmts);
    }

    private AST.Node parseStatement() {
        if (peek().type == TokenType.YILDIZ) return parseVarDecl();
        if (peek().type == TokenType.KEHANET) return parsePrint();
        if (peek().type == TokenType.RETRO) return parseIf();
        if (peek().type == TokenType.DOLUNAY) return parseWhile();
        if (peek().type == TokenType.FAL) return parseBirthDate();
        if (peek().type == TokenType.TUVAL_AC) return parseTuval();
        if (peek().type == TokenType.IZ_BIRAK) return parseIz();
        if (peek().type == TokenType.KOSE_DON) return parseKose();
        throw new RuntimeException("Error: " + peek().value);
    }

    private AST.Node parseTuval() { advance(); consume(TokenType.LPAREN, "("); AST.Node w = parseExpression(); consume(TokenType.COMMA, ","); AST.Node h = parseExpression(); consume(TokenType.RPAREN, ")"); consume(TokenType.SEMICOLON, ";"); return new AST.TuvalAcNode(w, h); }
    private AST.Node parseIz() { advance(); AST.Node d = parseExpression(); consume(TokenType.SEMICOLON, ";"); return new AST.IzBirakNode(d); }
    private AST.Node parseKose() { advance(); AST.Node d = parseExpression(); consume(TokenType.SEMICOLON, ";"); return new AST.KoseDonNode(d); }
    private AST.Node parseVarDecl() { advance(); Token name = advance(); consume(TokenType.ASSIGN, "="); AST.Node val = parseExpression(); consume(TokenType.SEMICOLON, ";"); return new AST.VarDeclNode(name.value, val); }
    private AST.Node parsePrint() { advance(); AST.Node e = parseExpression(); consume(TokenType.SEMICOLON, ";"); return new AST.PrintNode(e); }
    private AST.Node parseBirthDate() { advance(); consume(TokenType.LPAREN, "("); Token v = advance(); consume(TokenType.RPAREN, ")"); consume(TokenType.SEMICOLON, ";"); return new AST.BirthDateNode(v.value); }
    private AST.Node parseIf() { advance(); consume(TokenType.LPAREN, "("); AST.Node c = parseExpression(); consume(TokenType.RPAREN, ")"); consume(TokenType.LBRACE, "{"); AST.ProgramNode t = parseBlock(); consume(TokenType.RBRACE, "}"); AST.ProgramNode e = null; if (peek().type == TokenType.ILERLEME) { advance(); consume(TokenType.LBRACE, "{"); e = parseBlock(); consume(TokenType.RBRACE, "}"); } return new AST.IfNode(c, t, e); }
    private AST.Node parseWhile() { advance(); consume(TokenType.LPAREN, "("); AST.Node c = parseExpression(); consume(TokenType.RPAREN, ")"); consume(TokenType.LBRACE, "{"); AST.ProgramNode b = parseBlock(); consume(TokenType.RBRACE, "}"); return new AST.WhileNode(c, b); }
    private AST.ProgramNode parseBlock() { List<AST.Node> s = new ArrayList<>(); while (peek().type != TokenType.RBRACE && !isAtEnd()) { s.add(parseStatement()); } return new AST.ProgramNode(s); }
    private AST.Node parseExpression() { AST.Node l = parsePrimary(); while (peek().type == TokenType.PLUS || peek().type == TokenType.MINUS || peek().type == TokenType.EQUALS) { Token op = advance(); AST.Node r = parsePrimary(); l = new AST.BinaryOpNode(l, op, r); } return l; }
    private AST.Node parsePrimary() { Token t = advance(); if (t.type == TokenType.NUMBER) return new AST.LiteralNode(Integer.parseInt(t.value), t.type); if (t.type == TokenType.STRING) return new AST.LiteralNode(t.value, t.type); if (t.type == TokenType.BOOLEAN) return new AST.LiteralNode(t.value.equals("gokyuzu"), t.type); if (t.type == TokenType.IDENTIFIER) return new AST.LiteralNode(t.value, t.type); throw new RuntimeException("Error: " + t.value); }
}