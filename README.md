Peloscope,Programlama Dillerinin Prensipleri dönem ödevim için sıfırdan tasarlayıp kodladığım, gücünü astrolojiden ve gökyüzü geometrisinden alan kendime ait özel bir programlama dili ve çalışma zamanı ortamıdır. Dilin temel amacı; kullanıcının interaktif olarak girdiği doğum tarihine göre burcunu hesaplamak, sembol tablosunda bu veriyi işlemek ve o burcun anlık astrolojik durumuna (Normal, Retro, Dolunay veya Harita) göre ekrana Java Swing penceresi fırlatarak Logo / Turtle Graphics mantığıyla neon yıldız şekilleri çizmektir. Bu projede bir derleyicinin ve yorumlayıcının geçtiği tüm temel aşamaları (Lexer, Parser, AST, Evaluator ve Symbol Table) tamamen saf Java kullanarak, harici hiçbir kütüphaneye bağımlı kalmadan tasarladım ve uyguladım.

🪐 Dilimin Öne Çıkan Özellikleri
Projemi şu şekilde özetleyebilirim:

Katı Tip Kontrolü (Type Checking): Dilimde metinlerle (String) sayıların (Integer) aritmetik işleme girmesi tamamen yasaktır. Örneğin, derleyicim "Akrep" + 5 veya "10" + 5 gibi uyumsuz bir işlem gördüğü an çalışmayı güvenli bir şekilde keser ve terminalde anlamsal hata (Semantic Error) fırlatır.

Sınır Kontrolleri ve Veri Doğrulama (Semantic Validation): Kullanıcı interaktif olarak doğum tarihini girerken takvim sınırlarının dışına çıkarsa (örneğin ay kısmına 33 yazarsa), yazdığım filtre bunu anında yakalar ve programın yanlış çalışmasını engelleyerek geçersiz tarih hatası fırlatır.

48 Farklı Yıldız Kombinasyonu: Sistemde 12 burcun tamamı tanımlıdır. Her burcun; Normal, Retro, Dolunay ve Harita olmak üzere 4 farklı bağlamda çizeceği yıldızın geometrik dönüş açıları (144°, 135°, 120°, 128°, 150°) ve yürüyeceği mesafeler tamamen farklıdır. Toplamda 48 benzersiz çizim kombinasyonu vardır.

Dinamik Renk Değişimi: Çizim motorum o anki astrolojik bağlama göre otomatik renk değiştirir. Retro durumlarında çizgiler Kırmızı, Dolunay'da Sarı, normal zamanlarda ise Neon Yeşil olarak harici bir pencerede adım adım çizilir.

Rastgelelik Havuzu: Bellekteki burç verileri çözümlendikten sonra ekrana basılacak olan fallar statik değildir. Her burcun her durumu için yazdığım 3 farklı alternatif fal cümlesi arasından rastgele (Random) seçim yapılır.

📐 Dilimin Resmi Gramer Yapısı (CFG)
Peloscope dilinin kurallarını, parantez sınırlarını ve keyword'lerini belirlemek için tasarladığım Context-Free Grammar (CFG) yapısı şu şekildedir:

```text
<Program>          ::= <Statement>* <EOF>
<Statement>        ::= <VarDecl> | <PrintStmt> | <IfStmt> | <WhileStmt> | <BirthDateStmt> | <GraphicStmt>

<VarDecl>          ::= "yildiz" <Identifier> "=" <Expression> ";"
<PrintStmt>        ::= "kehanet" <Expression> ";"
<BirthDateStmt>    ::= "fal" "(" <Identifier> ")" ";"
<GraphicStmt>      ::= "tuval_ac" "(" <Expression> "," <Expression> ")" ";" | "iz_birak" <Expression> ";" | "kose_don" <Expression> ";"

<IfStmt>           ::= "retro" "(" <Expression> ")" "{" <Statement>* "}" ( "ilerleme" "{" <Statement>* "}" )?
<WhileStmt>        ::= "dolunay" "(" <Expression> ")" "{" <Statement>* "}"

<Expression>       ::= <Primary> ( ( "+" | "-" | "==" ) <Primary> )*
<Primary>          ::= <Identifier> | <Number> | <String> | <Boolean>

<Boolean>          ::= "gokyuzu" | "yeryuzu"
<Identifier>       ::= [a-zA-Z_][a-zA-Z0-9_]*
<Number>           ::= [0-9]+
<String>           ::= '"' [^"\\]* '"'
```
🔮 Benim Sözlüğüm ve Java Karşılıkları:
yildiz: Değişken tanımlama anahtarı (Variable Declaration)

kehanet: Ekrana yazdırma komutu (Print / System.out.println)

retro / ilerleme: Mantıksal koşul blokları (If / Else)

dolunay: Döngü bloğu (While Loop)

fal: Kullanıcıdan girdi alan interaktif fonksiyon (Scanner / Input)

gokyuzu: Mantıksal DOĞRU (True)

yeryuzu: Mantıksal YANLIŞ (False)

🛠️ Projeyi Nasıl Çalıştırabilirsiniz?
Projem tamamen taşınabilir (portable) şekilde tasarlandı. Bilgisayarınızda JDK 21 veya üzeri bir Java sürümü kuruluysa, terminal veya komut satırı üzerinden şu adımları izleyerek projemi çalıştırabilirsiniz:

Terminali projenin ana klasöründe açın.

Tüm Java dosyalarını derlemek için şu komutu yazın:
javac -d out src/*.java
(Bu komut src içindeki kodları derler ve out klasörünün altına atar).

Yorumlayıcıyı başlatmak için şu komutu koşturun:
java -cp out Main

📂 Kod Yapısı ve Örnek Bir Senaryo
Projemin kök dizininde src/ klasörünün altında derleyici mimarisine ait sınıflarım, examples/ klasörünün altında ise yazdığım örnek scriptler yer alıyor.

Örneğin examples/retro.peloscope dosyamın içeriği şu şekildedir:

tuval_ac(700, 700);
yildiz analiz_burcu = "Bos";
fal(analiz_burcu);
yildiz venus_derece = 5;
yildiz merkur_derece = 3;
yildiz toplam_etki = venus_derece + merkur_derece;
kehanet "--- Gezegen Retro Analizi Başlatılıyor ---";
retro (toplam_etki == 8) {
kehanet analiz_burcu;
} ilerleme {
kehanet "Gezegenler uyumlu konumda, retro etkisi bulunmuyor.";
}

Bu scripti çalıştırdığınızda sistem önce sizi şık bir tanıtım paneliyle karşılar, ardından interaktif olarak doğum tarihinizi ister. Hesaplanan burç sembol tablosuna yazılır ve retro bloğundaki matematiksel eşitlik doğruysa harici bir Java Swing penceresi fırlatıp rengini kırmızıya set ederek burcunuza özel o keskin yıldız geometrisini adım adım ekrana çizer.

🗂️ Mimari Proje Yapısı ve Sınıflarımız
Projemizin modüler yapısı ve hangi Java dosyasının ne işe yaradığı aşağıda kısaca özetlenmiştir:

TokenType.java: Dilimizdeki kelime türlerini (Keyword, Symbol, Literal) tanımlayan enum sözlüğüdür.

Token.java: Bulunan kelimelerin tipini ve değerini bir arada tutan kartvizit nesnesidir.

Lexer.java: Ham kodu harf harf tarayarak anlamlı kelimelere (Token) bölen sözcüksel analizcidir.

AST.java: Kod hiyerarşisini bilgisayarın anlayabileceği bir soy ağacına dönüştüren düğüm sınıflarıdır.

Parser.java: Kelime dizilimlerini gramer kurallarına (CFG) göre denetleyip sözdizim ağacını kuran ustadır.

PeloscopeTurtle.java: Java Swing ve Graphics2D kullanarak kaplumbağa çizimlerini gerçekleştiren görsel ekrandır.

Evaluator.java: Ağacı yukarıdan aşağıya dolaşan, değişkenleri sembol tablosunda saklayan ve kodu yürüten kalbimizdir.

ZodiacAstrology.java: 12 burç için toplam 48 farklı çizim algoritmasını ve 180 kehanet cümlesini saklayan veri bankasıdır.

Main.java: Script dosyasını okuyup tüm bu derleyici çarklarını sırayla tetikleyen ana giriş noktamızdır.
