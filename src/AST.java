import java.util.List;

public class AST {
    public static abstract class Node {}
    public static class ProgramNode extends Node { public final List<Node> statements; public ProgramNode(List<Node> s) { this.statements = s; } }
    public static class VarDeclNode extends Node { public final String name; public final Node value; public VarDeclNode(String n, Node v) { this.name = n; this.value = v; } }
    public static class BirthDateNode extends Node { public final String varName; public BirthDateNode(String v) { this.varName = v; } }
    public static class PrintNode extends Node { public final Node expression; public PrintNode(Node e) { this.expression = e; } }
    public static class IfNode extends Node { public final Node condition; public final ProgramNode thenBlock, elseBlock; public IfNode(Node c, ProgramNode t, ProgramNode e) { this.condition = c; this.thenBlock = t; this.elseBlock = e; } }
    public static class WhileNode extends Node { public final Node condition; public final ProgramNode block; public WhileNode(Node c, ProgramNode b) { this.condition = c; this.block = b; } }
    public static class TuvalAcNode extends Node { public final Node w, h; public TuvalAcNode(Node w, Node h) { this.w = w; this.h = h; } }
    public static class IzBirakNode extends Node { public final Node dist; public IzBirakNode(Node d) { this.dist = d; } }
    public static class KoseDonNode extends Node { public final Node deg; public KoseDonNode(Node d) { this.deg = d; } }
    public static class LiteralNode extends Node { public final Object value; public final TokenType type; public LiteralNode(Object v, TokenType t) { this.value = v; this.type = t; } }
    public static class BinaryOpNode extends Node { public final Node left, right; public final Token operator; public BinaryOpNode(Node l, Token o, Node r) { this.left = l; this.operator = o; this.right = r; } }
}