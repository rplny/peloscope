import java.util.HashMap;
import java.util.Map;

public class ZodiacAstrology {
    public static class ZodiacData {
        public final String[] normalFals, retroFals, dolunayFals, yildizFalis, dogumHaritalari;
        private final Map<String, String[]> drawingInstructions = new HashMap<>();

        public ZodiacData(String[] n, String[] r, String[] d, String[] y, String[] h,
                          String[] drawN, String[] drawR, String[] drawD, String[] drawH) {
            this.normalFals = n; this.retroFals = r; this.dolunayFals = d; this.yildizFalis = y; this.dogumHaritalari = h;
            drawingInstructions.put("normal", drawN); drawingInstructions.put("retro", drawR);
            drawingInstructions.put("dolunay", drawD); drawingInstructions.put("harita", drawH);
            drawingInstructions.put("yildiz", drawN);
        }
        public String[] getInstructions(String ctx) { return drawingInstructions.getOrDefault(ctx, drawingInstructions.get("normal")); }
    }

    private static final Map<String, ZodiacData> data = new HashMap<>();

    static {
        // 1. KOÇ
        data.put("Koc", new ZodiacData(
                new String[]{"Koç enerjisi bugün liderlik vasıflarınızı parlatıyor.", "İçsel ateşiniz tüm zorlukları küle çevirecek güçte.", "Cesur kararlar almak için harika bir gün, adımlarınız koruma altında."},
                new String[]{"Retro sürecinde fevri çıkışlar ve ani öfke patlamalarından uzak durun.", "Eski iletişim krizleri veya yarım kalmış evraklar önünüze gelebilir.", "Sözlerinizi tartarak söylemeli, aceleci kararlar almamalısınız."},
                new String[]{"Dolunay, içinizdeki yaratıcı ateşi en üst seviyeye taşıyor.", "Uzun süredir emek verdiğiniz bir hedefin parlak hasat vakti geldi.", "Size yük olan tüm enerjilerden arınma ve yenilenme evresindesiniz."},
                new String[]{"Yıldızlar kariyer basamaklarında ani bir yükseliş ve parlama vadediyor.", "Şans çarkı kader sayınızın hizalanmasıyla lehinize dönüyor.", "Işığınızla göz kamaştıracağınız, özgüveninizin tazeleneceği anlar."},
                new String[]{"Haritanızdaki Mars yerleşimi, önümüzdeki günlerde savaşçı ruhunuzu tetikliyor.", "Güneş konumunuz karakterinize sarsılmaz bir yaşam enerjisi aşılıyor.", "Yükselen yerleşiminiz dış dünyaya müthiş karizmatik bir aura saçıyor."},
                new String[]{"MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60"},
                new String[]{"MOVE 20", "TURN 144", "MOVE 25", "TURN -90", "MOVE 20", "TURN 144", "MOVE 25"},
                new String[]{"MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 90", "MOVE 10"},
                new String[]{"MOVE 50", "TURN 144", "MOVE 50", "TURN 144", "MOVE 50", "TURN 144", "MOVE 50", "TURN 144", "MOVE 50", "TURN 30", "MOVE 30"}
        ));

        // 2. BOĞA
        data.put("Boga", new ZodiacData(
                new String[]{"Maddi konularda güven arayışınız olumlu sonuçlar veriyor.", "Sabrınızın ve emeğinizin meyvelerini toplayacağınız huzurlu bir evre.", "Mevcut konfor alanınızı koruyarak emin adımlarla ilerleme zamanı."},
                new String[]{"Finansal yatırımlarda risk almaktan kaçının, retro gecikmeler üretebilir.", "İnatçı tavırlarınız ikili ilişkilerde kilitlenmelere yol açabilir.", "Eski borçlar veya unutulmuş ödemeler bu dönemde tekrar gündeme gelebilir."},
                new String[]{"Maddi bir düğüm tamamen çözülüyor, finansal bir tamamlanma döngüsü.", "Hayatınızda sadeleşmeye gideceğiniz, yükleri bırakacağınız bir arınma fazı.", "İçsel huzuru ve bereketi derinden hissedeceğiniz netleşmeler kapıda."},
                new String[]{"Venüs'ün parıltısı aşk hayatınızda güvenli limanlar bulmanızı sağlıyor.", "Kozmik talih size kalıcı ve köklü kazanımların kapısını aralayacak.", "Estetik ve sanatsal yönlerinizin takdir göreceği şanslı bir gün."},
                new String[]{"Haritanızdaki Boğa baskınlığı, size yüksek bir sadakat ve sarsılmazlık veriyor.", "Köklenme ve dünyaya sağlam basma arzunuz haritanın temel direğidir.", "Sabırlı yapınız, haritanın sert transitlerini yumuşatmayı başaracak."},
                new String[]{"MOVE 50", "TURN 90", "MOVE 20", "TURN -90", "MOVE 50", "TURN 90", "MOVE 20", "TURN -90", "MOVE 50"},
                new String[]{"MOVE 30", "TURN 90", "MOVE 10", "TURN 135", "MOVE 30", "TURN -90", "MOVE 10"},
                new String[]{"MOVE 40", "TURN 90", "MOVE 40", "TURN 90", "MOVE 40", "TURN 90", "MOVE 40", "TURN 45", "MOVE 20"},
                new String[]{"MOVE 60", "TURN 90", "MOVE 60", "TURN 90", "MOVE 60", "TURN 90", "MOVE 60", "TURN 45", "MOVE 30"}
        ));

        // 3. İKİZLER
        data.put("Ikizler", new ZodiacData(
                new String[]{"Zihinsel enerjiniz en üst noktada, harika fikirler üreteceksiniz.", "Sosyal çevrenizde ilgi odağı haline gelebilir, yeni bağlar kurabilirsiniz.", "Kıvrak zekanız sayesinde karşınıza çıkan her engeli kolayca aşacaksınız."},
                new String[]{"Merkür retrosu zihninizi bulandırabilir, imzalara dikkat edin.", "Elektronik cihazlarda veya iletişim kanallarında aksamalar yaşanabilir.", "Düşünmeden konuşmak ikili ilişkilerde pot kırmanıza sebep olabilir."},
                new String[]{"Zihinsel karmaşalar yerini netliğe bırakıyor, aradığınız kararı veriyorsunuz.", "Bir eğitim veya seyahat planının başarıyla neticeleneceği güçlü bir faz.", "İkilemleriniz dolunayın güçlü ışığı altında nihayet son buluyor."},
                new String[]{"Hitabet yeteneğiniz sayesinde toplulukları peşinizden sürükleyebilirsiniz.", "Kozmik akış size aynı anda birden fazla şans kapısı aralayacaktır.", "Yaratıcı projelerde ve yazım işlerinde parıltılı başarılar yakın."},
                new String[]{"Doğum haritanızdaki çok yönlülük, adaptasyon gücünüzü zirveye taşıyor.", "Entelektüel merak ve bilgi açlığı ruhunuzun temel motivasyon kaynağıdır.", "Zihinsel dağılmaları önlemek adına odaklanma çalışmaları yapmalısınız."},
                new String[]{"MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 45", "MOVE 30", "TURN 144", "MOVE 30"},
                new String[]{"MOVE 20", "TURN -144", "MOVE 20", "TURN 90", "MOVE 20", "TURN -144", "MOVE 20"},
                new String[]{"MOVE 30", "TURN 144", "MOVE 30", "TURN 144", "MOVE 30", "TURN 15", "MOVE 10", "TURN 15", "MOVE 10"},
                new String[]{"MOVE 50", "TURN 135", "MOVE 50", "TURN 135", "MOVE 50", "TURN 135", "MOVE 50", "TURN 90", "MOVE 20"}
        ));

        // 4. YENGEÇ
        data.put("Yengec", new ZodiacData(
                new String[]{"Sezgileriniz bugün en doğru rehberiniz, kalbinizin sesini dinleyin.", "Sevdiklerinizle ve ailenizle geçireceğiniz vakit ruhunuza şifa olacak.", "Ev sıcaklığında huzur bulacağınız, manevi yönü güçlü bir gün."},
                new String[]{"Duygusal olarak fazla alıngan olabilirsiniz, kabuğunuza çekilme vakti.", "Geçmiş anılar veya eski dostlar zihninizi yoğun şekilde meşgul edebilir.", "Aile içi ilişkilerde eski kırgınlıkların tetiklenme riski bulunuyor."},
                new String[]{"Duygusal bir dönüm noktası, biriktirdiğiniz tüm yüklerden özgürleşiyorsunuz.", "Ev veya yuva hayatındaki belirsizlikler yerini tam bir netliğe bırakıyor.", "Ruhsal olarak olgunlaşacağınız güçlü bir döngüsel tamamlanma."},
                new String[]{"Kozmik koruma altındasınız, sezgileriniz sizi şanslı fırsatlara taşıyacak.", "Çevrenizdeki insanları şifalandıracağınız cömert bir dönemdesiniz.", "İçsel ışığınızın dış dünyaya şefkat olarak yansıyacağı özel bir gün."},
                new String[]{"Haritanızdaki Ay yönetimi, derin bir empati yeteneği ve koruyuculuk verir.", "Duygusal hafızanız son derece güçlü, haritanızın kökleri aileye bağlıdır.", "Kendi sınırlarınızı çizmeyi öğrenmek bu haritanın en büyük dersidir."},
                new String[]{"MOVE 40", "TURN 135", "MOVE 40", "TURN 135", "MOVE 40", "TURN 135", "MOVE 40", "TURN 135", "MOVE 40", "TURN 135", "MOVE 40"},
                new String[]{"MOVE 20", "TURN 135", "MOVE 10", "TURN -90", "MOVE 20", "TURN 135", "MOVE 10"},
                new String[]{"MOVE 30", "TURN 135", "MOVE 30", "TURN 135", "MOVE 30", "TURN 135", "MOVE 30", "TURN 10", "MOVE 15"},
                new String[]{"MOVE 45", "TURN 135", "MOVE 45", "TURN 135", "MOVE 45", "TURN 90", "MOVE 25", "TURN 135", "MOVE 25"}
        ));

        // 5. ASLAN
        data.put("Aslan", new ZodiacData(
                new String[]{"Işığınızla çevrenizi parlatıyorsunuz, sahne sırası sizde.", "Yaratıcılığınızı özgürce sergileyerek tüm dikkatleri üzerinize çekeceksiniz.", "Cömertliğiniz ve sarsılmaz karizmanız sayesinde kapılar açılıyor."},
                new String[]{"Egonuzun sesini kısmalısınız, gururlu tavırlar bağları zedeleyebilir.", "Liderlik etmeye çalışırken baskıcı algılanmamaya özen gösterin.", "Geçmişte hak ettiğiniz ama alamadığınız takdirler gecikmeli gelebilir."},
                new String[]{"Kişisel bir projenizin muazzam finali, spot ışıkları üzerinizde.", "Kendinizi en güçlü şekilde ortaya koyacağınız güçlü bir dolunay fazı.", "Yaratıcı enerjinizin ve gerçek kimliğinizin zirveye ulaştığı arınma anı."},
                new String[]{"Güneş'in gücüyle parlayacağınız, statünüzün yükseleceği bir dönem.", "Kozmik talih size prestijli ve dikkat çekici iş fırsatları sunuyor.", "Işığınızla göz kamaştıracağınız, özgüven tazeleyeceğiniz anlar."},
                new String[]{"Doğum haritanızdaki Güneş merkezi, size yüksek asalet ve duruş verir.", "Haritanız yaratıcılık, sahne ve yönetim dehasıyla bezenmiştir.", "Kibirden kaçındığınız müddetçe haritanızın kalitesi katlanarak artar."},
                new String[]{"MOVE 60", "TURN 120", "MOVE 60", "TURN 120", "MOVE 60", "TURN 60", "MOVE 30", "TURN 120", "MOVE 60"},
                new String[]{"MOVE 30", "TURN 120", "MOVE 30", "TURN -60", "MOVE 30", "TURN 120", "MOVE 30"},
                new String[]{"MOVE 50", "TURN 120", "MOVE 50", "TURN 120", "MOVE 50", "TURN 10", "MOVE 10", "TURN 10"},
                new String[]{"MOVE 40", "TURN 120", "MOVE 40", "TURN 120", "MOVE 40", "TURN 30", "MOVE 40", "TURN 120", "MOVE 40"}
        ));

        // 6. BAŞAK
        data.put("Basak", new ZodiacData(
                new String[]{"Detaylardaki odaklanma gücünüz bugün size büyük başarı getirecek.", "Üretkenliğiniz en üst seviyede, yarım kalan her işi bitirebilirsiniz.", "Pratik çözümlerinizle çevrenizdeki tüm karmaşaları tek tek çözeceksiniz."},
                new String[]{"Aşırı eleştirel tavırlardan kaçının, kusursuzluk arayışı sizi yorabilir.", "Planlarınızda ani aksamalar olabilir, akışta kalmayı deneyimleyin.", "Detaylarda boğulup projenin büyük resmini kaçırma riskine dikkat."},
                new String[]{"Analiz ettiğiniz tüm konular netleşiyor, emekler karşılık buluyor.", "Hayatınızda düzen kuracağınız, fazlalıkları eleyeceğiniz güçlü bir faz.", "Ruhsal ve fiziksel sağlığınızda şifalanma yaşayacağınız güçlü dolunay."},
                new String[]{"Metodik ve planlı çalışmanız sayesinde kalıcı başarıları yakalayacaksınız.", "Kozmik düzen, hayatınızdaki pürüzleri ayıklamanız için fırsatlar sunuyor.", "Zekanızın ve disiplininizin ödüllendirileceği şanslı bir dönem."},
                new String[]{"Haritanızdaki Başak vurgusu, muazzam bir hizmet ve analiz gücü verir.", "Pratik akıl ve mantık süzgeci haritanızın en güçlü savunma mekanizmasıdır.", "Evham ve endişeyi yönetmek, bu haritanın vermesi gereken en büyük sınavdır."},
                new String[]{"MOVE 30", "TURN 60", "MOVE 30", "TURN 120", "MOVE 30", "TURN 60", "MOVE 30", "TURN 120", "MOVE 30"},
                new String[]{"MOVE 20", "TURN 60", "MOVE 10", "TURN -60", "MOVE 20", "TURN 120", "MOVE 20"},
                new String[]{"MOVE 30", "TURN 60", "MOVE 30", "TURN 120", "MOVE 30", "TURN 15", "MOVE 12", "TURN 15"},
                new String[]{"MOVE 40", "TURN 60", "MOVE 40", "TURN 120", "MOVE 40", "TURN 90", "MOVE 20", "TURN 60", "MOVE 20"}
        ));

        // 7. TERAZİ
        data.put("Terazi", new ZodiacData(
                new String[]{"İlişkilerinizde denge ve uyum hakim, diplomatik gücünüz zirvede.", "Estetik ve sanatsal yönlerinizin ön plana çıkacağı keyifli bir gün.", "Adalet duygunuz sayesinde çevrenizde barışçıl rüzgarlar estireceksiniz."},
                new String[]{"Kararsızlığınız bugün sizi kilitleyebilir, seçim yapmakta zorlanabilirsiniz.", "Ortaklıklarda eski dengesizlikler veya uyum krizleri tetiklenebilir.", "Huzur bozulmasın diye sustuğunuz her şey retroda önünüze gelebilir."},
                new String[]{"İlişkilerinizde tam bir aynalanma süreci, sorunlar kökten çözülüyor.", "Hayatınızdaki adaletsiz durumların dengelendiği güçlü bir dolunay.", "Hak ettiğiniz adaletin ve huzurun hayatınıza dahil olacağı an."},
                new String[]{"Güzellik, zarafet ve ikili ilişkilerden yana şans rüzgarları esiyor.", "Diplomatik yetenekleriniz sayesinde krizleri fırsata çevireceksiniz.", "Venüs'ün parıltısı bugün üzerinizde, ikna kabiliyetiniz çok yüksek."},
                new String[]{"Doğum haritanızdaki Terazi yerleşimi, rafine bir zevk ve denge bilinci aşılar.", "Ortaklıklar ve ilişkiler üzerinden büyüyen bir kader yoluna sahipsiniz.", "Uyum sağlama uğruna kendi kimliğinizden ödün vermemeyi öğrenmelisiniz."},
                new String[]{"MOVE 30", "TURN 150", "MOVE 30", "TURN 150", "MOVE 30", "TURN 150", "MOVE 30", "TURN 150", "MOVE 30", "TURN 150", "MOVE 30"},
                new String[]{"MOVE 15", "TURN 150", "MOVE 15", "TURN -90", "MOVE 15", "TURN 150", "MOVE 15"},
                new String[]{"MOVE 25", "TURN 150", "MOVE 25", "TURN 150", "MOVE 25", "TURN 150", "MOVE 10", "TURN 20"},
                new String[]{"MOVE 35", "TURN 150", "MOVE 35", "TURN 150", "MOVE 35", "TURN 45", "MOVE 20", "TURN 150", "MOVE 20"}
        ));

        // 8. AKREP
        data.put("Akrep", new ZodiacData(
                new String[]{"Küllerinizden yeniden doğuyorsunuz, sezgileriniz ve gücünüz muazzam.", "Gizemli konuları çözmek, derin analizler yapmak için harika bir gün.", "Tutkunuz ve kararlılığınız sayesinde imkansızı başarma gücüne sahipsiniz."},
                new String[]{"Kıskançlık ve şüphecilik duygularına dikkat, kendinizi yıpratabilirsiniz.", "Gizli kalmış sırlar veya arkadan dönen oyunlar bu retroda önünüze dökülebilir.", "İntikam veya kriz odaklı düşünmek kozmik enerjinizi aşağı çeker."},
                new String[]{"Hayatınızda derin bir dönüşümün sonuna geldiniz; eski siz tamamen ölüyor.", "Gizli bir konunun tamamen aydınlanması ile yaşayacağınız büyük arınma.", "Maddi veya manevi büyük bir krizin çözülüp şifaya dönüştüğü an."},
                new String[]{"Manyetik çekim gücünüz zirvede; istediğiniz fırsatları kendinize çekeceksiniz.", "Kozmik akış size küllerinizden doğacağınız büyük finansal güçler vaat ediyor.", "Sezgilerinizin tam isabet kaydedeceği şanslı ve gizemli bir dönem."},
                new String[]{"Haritanızdaki Plütonik etkiler, muazzam bir dönüşüm gücü ve sarsılmaz irade verir.", "Yüzeysel olan hiçbir şey size göre değil; haritanız derinlik ve hakikat arar.", "Krizi ve kaosu yönetme kabiliyetiniz, haritanızın en gizemli hediyesidir."},
                new String[]{"MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60", "TURN 144", "MOVE 60"},
                new String[]{"MOVE 30", "TURN 144", "MOVE 10", "TURN 90", "MOVE 30", "TURN 144", "MOVE 10"},
                new String[]{"MOVE 45", "TURN 144", "MOVE 45", "TURN 144", "MOVE 45", "TURN 5", "MOVE 8", "TURN 5", "MOVE 8"},
                new String[]{"MOVE 50", "TURN 144", "MOVE 50", "TURN 144", "MOVE 50", "TURN 72", "MOVE 30", "TURN 144", "MOVE 30"}
        ));

        // 9. YAY
        data.put("Yay", new ZodiacData(
                new String[]{"İyimserliğiniz ve neşeniz çevrenize enerji saçıyor, macera zamanı.", "Yeni felsefeler keşfetmek, vizyonunuzu genişletmek için harika bir gün.", "Jüpiter bugün adımlarınızı koruyor, ufka doğru güvenle ilerleyin."},
                new String[]{"Abartılı tavırlardan kaçının, tutamayacağınız sözler vermemelisiniz.", "Seyahat planlarında veya akademik işlerde ani gecikmeler yaşanabilir.", "Gözü kara adımlar atmak yerine biraz durup durumu analiz etme zamanı."},
                new String[]{"İnançlarınız ve yaşam vizyonunuz netleşiyor, aradığınız yanıtı buluyorsunuz.", "Yurt dışı veya eğitim bağlantılı bir işin başarıyla tamamlanacağı evre.", "Ufkunuzu genişleten, özgürlüğünüzü ilan edeceğiniz güçlü bir dolunay."},
                new String[]{"Jüpiter'in büyütücü eli üzerinizde, talih sizden yana parlıyor.", "Uzak diyarlardan veya vizyoner projelerden büyük şanslar kapınızda.", "İyimser duruşunuzun kozmik mucizelerle ödüllendirileceği şanslı döngü."},
                new String[]{"Doğum haritanızdaki Yay vurgusu, bitmek bilmez bir keşif ve bilgelik verir.", "Haritanız geniş ufuklar, büyük hedefler ve felsefeyle kodlanmıştır.", "Detayları gözden kaçırma eğiliminizi, haritadaki dengeli yerleşimler çözmeli."},
                new String[]{"MOVE 80", "TURN 135", "MOVE 30", "TURN 180", "MOVE 30", "TURN 45", "MOVE 30"},
                new String[]{"MOVE 40", "TURN 135", "MOVE 20", "TURN -90", "MOVE 40", "TURN 135", "MOVE 20"},
                new String[]{"MOVE 60", "TURN 135", "MOVE 20", "TURN 180", "MOVE 20", "TURN 10", "MOVE 15"},
                new String[]{"MOVE 70", "TURN 135", "MOVE 25", "TURN 90", "MOVE 40", "TURN 135", "MOVE 25"}
        ));

        // 10. OĞLAK
        data.put("Oglak", new ZodiacData(
                new String[]{"Disiplininiz ve sorumluluk bilinciniz kariyerde zirveyi getiriyor.", "Uzun vadeli hedeflerinize odaklanmak, sağlam temeller atmak için harika bir gün.", "Zamanı çok iyi yöneterek tüm işlerinizi jilet gibi organize edeceksiniz."},
                new String[]{"Fazla katı ve soğuk görünmek ilişkilerinizi zora sokabilir, esnek olun.", "Kariyerde işlerin yavaşlaması sabrınızı sınayabilir, pes etmeyin.", "Aşırı görev odaklı olup hayatın neşesini kaçırma riskiniz var."},
                new String[]{"Kariyerinizde ve hayat hedeflerinizde zirveye ulaştınız; emekleriniz mühürleniyor.", "Sorumluluklarınızın ödülünü alacağınız, saygınlık kazanacağınız bir dolunay.", "Hayatınızda artık işlevini yitirmiş eski sistemleri yıkıp yenisini kurma anı."},
                new String[]{"Satürn'ün sabırlı gücü, size yıkılmaz ve kalıcı bir başarı kalesi vadediyor.", "Zirveye giden yolda engelleri tek tek aşacağınız prestijli fırsatlar kapıda.", "Disiplininizin ve ciddiyetinizin otorite figürlerince ödüllendirileceği an."},
                new String[]{"Haritanızdaki Satürn yönetimi, size genç yaşta büyük olgunluk ve dayanıklılık verir.", "Zamanın bilgeliği haritanızda saklı; siz yaş aldıkça gençleşen ve parlayan birisiniz.", "Başarısızlık korkusunu yenmek, haritanızın en büyük tekamül adımıdır."},
                new String[]{"MOVE 50", "TURN 128", "MOVE 50", "TURN 128", "MOVE 50", "TURN 128", "MOVE 50", "TURN 128", "MOVE 50", "TURN 128", "MOVE 50"},
                new String[]{"MOVE 25", "TURN 128", "MOVE 15", "TURN -45", "MOVE 25", "TURN 128", "MOVE 15"},
                new String[]{"MOVE 40", "TURN 128", "MOVE 40", "TURN 128", "MOVE 40", "TURN 30", "MOVE 20"},
                new String[]{"MOVE 45", "TURN 128", "MOVE 45", "TURN 128", "MOVE 45", "TURN 60", "MOVE 25", "TURN 128", "MOVE 25"}
        ));

        // 11. KOVA
        data.put("Kova", new ZodiacData(
                new String[]{"Sıra dışı fikirlerinizle geleceğe ışık tutuyorsunuz, vizyoner bir gün.", "Toplumsal projeler, takım çalışmaları ve dostluklar için harika enerjiler var.", "Özgürlüğünüze düşkün tavrınız bugün size yepyeni kapılar açabilir."},
                new String[]{"Çevrenize karşı fazla asi ve dikbaşlı davranmaktan kaçınmalısınız.", "Bireysellik dozunu kaçırıp yalnızlaşma veya anlaşılmama riski var.", "Teknolojik aletlerde veya planlarda ani duraksamalar yaşanabilir."},
                new String[]{"Zihinsel prangalarınızdan kurtuluyorsunuz; özgürlüğünüzü ilan etme vakti.", "Gelecek hedefleriniz ve dahil olduğunuz topluluklar içinde netleşme dönemi.", "İdealist fikirlerinizin toplumsal bir farkındalığa dönüştüğü güçlü bir dolunay."},
                new String[]{"Uranüs'ün dahi parıltısı size sıra dışı, vizyoner ve dahi fikirler sunacak.", "Toplulukları peşinizden sürükleyeceğiniz yenilikçi şanslar kapıda.", "Sıradanlığı yıkıp geçeceğiniz, özgünlüğünüzle parlayacağınız muazzam döngü."},
                new String[]{"Doğum haritanızdaki Kova vurgusu, bağımsız bir zeka ve insancıl bir vizyon verir.", "Siz bu dünyanın ötesini sezen, mistik bağları çok güçlü bir ruhsal haritaya sahipsiniz.", "Sürü psikolojisine karşı duruşunuz, haritanızın en asil sarsılmaz yönüdür."},
                new String[]{"MOVE 30", "TURN 60", "MOVE 30", "TURN -60", "MOVE 30", "TURN 120", "MOVE 30", "TURN -60", "MOVE 30"},
                new String[]{"MOVE 20", "TURN 90", "MOVE 20", "TURN -90", "MOVE 20", "TURN 144", "MOVE 20"},
                new String[]{"MOVE 25", "TURN 60", "MOVE 25", "TURN -60", "MOVE 25", "TURN 10", "MOVE 12"},
                new String[]{"MOVE 40", "TURN 60", "MOVE 40", "TURN 120", "MOVE 40", "TURN 45", "MOVE 25", "TURN 60", "MOVE 25"}
        ));

        // 12. BALIK
        data.put("Balik", new ZodiacData(
                new String[]{"Hayal gücünüzün ve sezgilerinizin sınırı yok, manevi yönünüz zirvede.", "Sanatsal faaliyetler ve meditasyon için ruhunuz çok açık ve dingin.", "Evrenle tam bir bütünlük hissedeceğiniz, şifalı rüzgarlar esen bir gün."},
                new String[]{"Gerçeklerden kaçıp hayal dünyasına saklanma eğilimine dikkat edin.", "Kurban psikolojisine girmek veya aşırı fedakarlık yapmak sizi yıpratabilir.", "Zihninizdeki illüzyonlar gerçekleri görmenizi zorlaştırabilir, uyanık olun."},
                new String[]{"Ruhsal arınmanın zirvesi; tüm korkularınızı ve bağımlılıklarınızı geride bırakıyorsunuz.", "Yaratıcı veya spiritüel bir çalışmanızın muazzam ruhsal meyvelerini toplama anı.", "İlahi sevgi ve teslimiyetle sarılacağınız, gözyaşlarıyla şifalanacağınız dolunay."},
                new String[]{"Neptün'ün büyülü dokunuşuyla sanatta ve spiritüel alanda mucizeler yaratacaksınız.", "Evrensel akış size ilahi eşzamanlılıklar ve gizemli şanslar getirecektir.", "Sezgilerinizin sizi tam bir koruma ve şans çemberine alacağı parıltılı evre."},
                new String[]{"Haritanızdaki Neptün transiti, derin bir adanmışlık, sınırsız hayal gücü ve şifa verir.", "Siz bu dünyanın ötesini sezen, mistik bağları çok güçlü bir ruhsal haritaya sahipsiniz.", "Gerçek dünya ile bağları koparmamak adına haritanızdaki toprak etkilerini uyandırmalısınız."},
                new String[]{"MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40", "TURN 144", "MOVE 40"},
                new String[]{"MOVE 20", "TURN 144", "MOVE 15", "TURN -45", "MOVE 20", "TURN 144", "MOVE 15"},
                new String[]{"MOVE 35", "TURN 144", "MOVE 35", "TURN 144", "MOVE 35", "TURN 12", "MOVE 10"},
                new String[]{"MOVE 50", "TURN 144", "MOVE 50", "TURN 144", "MOVE 50", "TURN 36", "MOVE 25", "TURN 144", "MOVE 25"}
        ));
    }
    public static ZodiacData get(String name) { return data.get(name); }
}