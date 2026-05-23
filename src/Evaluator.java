import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Evaluator {
    private final Map<String, Object> env = new HashMap<>();
    private final Random rand = new Random();
    private String context = "normal";
    private PeloscopeTurtle turtle = new PeloscopeTurtle();

    public void evaluate(AST.Node node) {
        if (node instanceof AST.ProgramNode) {
            for (AST.Node s : ((AST.ProgramNode) node).statements) evaluate(s);
        }
        else if (node instanceof AST.VarDeclNode) {
            AST.VarDeclNode d = (AST.VarDeclNode) node;
            env.put(d.name, evalExpr(d.value));
        }
        else if (node instanceof AST.BirthDateNode) {
            AST.BirthDateNode b = (AST.BirthDateNode) node;
            Scanner s = new Scanner(System.in);

            System.out.println("┌──────────────────────────────────────────────────┐");
            System.out.println("│ 🔮 PELOSCOPE: COSMIC INTERPRETER v2.0          │");
            System.out.println("├──────────────────────────────────────────────────┤");
            System.out.println("│ Peloscope, gökyüzünün matematiksel geometrisiyle │");
            System.out.println("│ kadim astroloji öğretilerini birleştiren özgün  │");
            System.out.println("│ bir programlama dilidir.                         │");
            System.out.println("│                                                  │");
            System.out.println("│ 🪐 Algoritma Motoru:                             │");
            System.out.println("│  - 12 Burç için 48 Farklı Yıldız Geometrisi     │");
            System.out.println("│  - Dinamik Retro, Dolunay ve Harita Kontrolleri  │");
            System.out.println("│  - Olasılıksal Matris Tabanlı 180 Eşsiz Kehanet  │");
            System.out.println("│  - Java Swing & Logo Turtle Grafik Entegrasyonu   │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.println("\n🌟 [Kâhin Gök Kubbeyi İnceliyor... Giriş Yapınız]");

            System.out.print(">> Doğduğunuz GÜN (1-31): ");
            int g = s.nextInt();
            System.out.print(">> Doğduğunuz AY (1-12):  ");
            int a = s.nextInt();

            String res = calculateZodiac(g, a);
            env.put(b.varName, res);
            System.out.println("\n✨ Gezegenler hizalandı! Hesaplanan Burç: " + res.toUpperCase());
        }
        else if (node instanceof AST.TuvalAcNode) {
            AST.TuvalAcNode t = (AST.TuvalAcNode) node;
            turtle.setup((Integer)evalExpr(t.w), (Integer)evalExpr(t.h));
        }
        else if (node instanceof AST.IzBirakNode) {
            turtle.move(((Number)evalExpr(((AST.IzBirakNode) node).dist)).doubleValue());
        }
        else if (node instanceof AST.KoseDonNode) {
            turtle.turn(((Number)evalExpr(((AST.KoseDonNode) node).deg)).doubleValue());
        }
        else if (node instanceof AST.PrintNode) {
            Object val = evalExpr(((AST.PrintNode) node).expression);
            if (String.valueOf(val).contains("Doğum Haritası")) context = "harita";
            else if (String.valueOf(val).contains("Yıldız Falı")) context = "yildiz";
            String burc = String.valueOf(val).trim();
            ZodiacAstrology.ZodiacData data = ZodiacAstrology.get(burc);
            if (data != null) {
                applyCosmicVisuals(data);
                System.out.println("\n┌──────────────────────────────────────────────────┐");
                System.out.println("│ 🪐 KOZMİK ENERJİ PANELİ                         │");
                System.out.println("└──────────────────────────────────────────────────┘");
                int idx = rand.nextInt(3);
                if (context.equals("harita")) System.out.println("🗺️ HARİTA ANALİZİ: " + data.dogumHaritalari[idx]);
                else if (context.equals("yildiz")) System.out.println("✨ YILDIZ FALI: " + data.yildizFalis[idx]);
                else if (context.equals("retro")) System.out.println("🔮 RETRO: " + data.retroFals[idx]);
                else if (context.equals("dolunay")) System.out.println("🌕 DOLUNAY: " + data.dolunayFals[idx]);
                else System.out.println("🔮 FAL: " + data.normalFals[idx]);
            } else System.out.println("🔮 " + val);
        }
        else if (node instanceof AST.IfNode) {
            AST.IfNode i = (AST.IfNode) node; String old = context; if (!context.equals("yildiz") && !context.equals("harita")) context = "retro";
            if ((Boolean) evalExpr(i.condition)) evaluate(i.thenBlock); else if (i.elseBlock != null) { context = old; evaluate(i.elseBlock); } context = old;
        }
        else if (node instanceof AST.WhileNode) {
            AST.WhileNode w = (AST.WhileNode) node; String old = context; if (!context.equals("yildiz") && !context.equals("harita")) context = "dolunay";
            while ((Boolean) evalExpr(w.condition)) evaluate(w.block); context = old;
        }
    }

    private void applyCosmicVisuals(ZodiacAstrology.ZodiacData data) {
        String[] cmds = data.getInstructions(context);
        if (context.equals("retro")) turtle.setPenColor(new Color(220, 38, 38));
        else if (context.equals("dolunay")) turtle.setPenColor(new Color(234, 179, 8));
        else turtle.setPenColor(new Color(17, 202, 160));
        for (String c : cmds) {
            String[] parts = c.split(" ");
            if (parts[0].equals("MOVE")) turtle.move(Double.parseDouble(parts[1]));
            else if (parts[0].equals("TURN")) turtle.turn(Double.parseDouble(parts[1]));
        }
    }

    private Object evalExpr(AST.Node n) {
        if (n instanceof AST.LiteralNode) { AST.LiteralNode l = (AST.LiteralNode) n; return l.type == TokenType.IDENTIFIER ? env.get(l.value) : l.value; }
        if (n instanceof AST.BinaryOpNode) {
            AST.BinaryOpNode b = (AST.BinaryOpNode) n; Object l = evalExpr(b.left), r = evalExpr(b.right);
            if (b.operator.type == TokenType.PLUS) return (Integer) l + (Integer) r;
            if (b.operator.type == TokenType.EQUALS) return l.equals(r);
        }
        return null;
    }

    private String calculateZodiac(int g, int a) {
        if (a < 1 || a > 12 || g < 1 || g > 31) { throw new RuntimeException("Semantic Error: Geçersiz tarih girdisi! Gün 1-31, Ay 1-12 arasında olmalıdır."); }
        if (a == 3) return g >= 21 ? "Koc" : "Balik"; if (a == 4) return g >= 21 ? "Boga" : "Koc"; if (a == 5) return g >= 22 ? "Ikizler" : "Boga";
        if (a == 6) return g >= 22 ? "Yengec" : "Ikizler"; if (a == 7) return g >= 23 ? "Aslan" : "Yengec"; if (a == 8) return g >= 23 ? "Basak" : "Aslan";
        if (a == 9) return g >= 23 ? "Terazi" : "Basak"; if (a == 10) return g >= 23 ? "Akrep" : "Terazi"; if (a == 11) return g >= 22 ? "Yay" : "Akrep";
        if (a == 12) return g >= 22 ? "Oglak" : "Yay"; if (a == 1) return g >= 22 ? "Kova" : "Oglak"; if (a == 2) return g >= 20 ? "Balik" : "Kova";
        return "Koc";
    }
}