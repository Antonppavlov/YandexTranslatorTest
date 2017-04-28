package su.bbrain.yandextranslator.yandex.language;
public enum Language {

    Azerbaijani("азербайджанский", "az"),
    Albanian("албанский", "sq"),
    Amharic("амхарский", "am"),
    English("английский", "en"),
    Arab("арабский", "ar"),
    Armenian("армянский", "hy"),
    Afrikaans("африкаанс", "af"),
    Basque("баскский", "eu"),
    Bashkir("башкирский", "ba"),
    Belorussian("белорусский", "be"),
    Bengal("бенгальский", "bn"),
    Bulgarian("болгарский", "bg"),
    Bosnian("боснийский", "bs"),
    Welsh("валлийский", "cy"),
    Hungarian("венгерский", "hu"),
    Vietnamese("вьетнамский", "vi"),
    Haitian_Creole("гаитянский (креольский)", "ht"),
    Galician("галисийский", "gl"),
    Dutch("голландский", "nl"),
    Mining("горномарийский", "mr"),
    Greek("греческий", "el"),
    Georgian("грузинский", "ka"),
    Gujarati("гуджарати", "gu"),
    Danish("датский", "da"),
    Hebrew("иврит", "he"),
    Yiddish("идиш", "yi"),
    Indonesian("индонезийский", "id"),
    Irish("ирландский", "ga"),
    Italian("итальянский", "it"),
    Icelandic("исландский", "is"),
    Spanish("испанский", "es"),
    Kazakh("казахский", "kk"),
    Kannada("каннада", "kn"),
    Catalan("каталанский", "ca"),
    Kyrgyz("киргизский", "ky"),
    Chinese("китайский", "zh"),
    Korean("корейский", "ko"),
    Spit("коса", "xh"),
    Latin("латынь", "la"),
    Latvian("латышский", "lv"),
    Lithuanian("литовский", "lt"),
    Luxembourgish("люксембургский", "lb"),
    Malagasy("малагасийский", "mg"),
    Malay("малайский", "ms"),
    Malayalam("малаялам", "ml"),
    Maltese("мальтийский", "mt"),
    Macedonian("македонский", "mk"),
    Maori("маори", "mi"),
    Marathi("маратхи", "mr"),
    Mari("марийский", "mhr"),
    Mongolian("монгольский", "mn"),
    German("немецкий", "de"),
    Nepali("непальский", "ne"),
    Norwegian("норвежский", "no"),
    Punjabi("панджаби", "pa"),
    Papiamento("папьяменто", "pap"),
    Persian("персидский", "fa"),
    Polish("польский", "pl"),
    Portuguese("португальский", "pt"),
    Romanian("румынский", "ro"),
    Russian("русский", "ru"),
    Sebuanian("себуанский", "ceb"),
    Serbian("сербский", "sr"),
    Sinhalese("сингальский", "si"),
    Slovak("словацкий", "sk"),
    Slovenian("словенский", "sl"),
    Swahili("суахили", "sw"),
    Sudanese("сунданский", "su"),
    Tajik("таджикский", "tg"),
    Thai("тайский", "th"),
    Tagalog("тагальский", "tl"),
    Tamil("тамильский", "ta"),
    Tatar("татарский", "tt"),
    Telugu("телугу", "te"),
    Turkish("турецкий", "tr"),
    Udmurt("удмуртский", "udm"),
    Uzbek("узбекский", "uz"),
    Ukrainian("украинский", "uk"),
    Urdu("урду", "ur"),
    Finnish("финский", "fi"),
    French("французский", "fr"),
    Hindi("хинди", "hi"),
    Croatian("хорватский", "hr"),
    Czech("чешский", "cs"),
    Swedish("шведский", "sv"),
    Scottish("шотландский", "gd"),
    Estonian("эстонский", "et"),
    Esperanto("эсперанто", "eo"),
    Javanese("яванский", "jv"),
    Japanese("японский", "ja");


    private final String name;
    private final String code;

    Language(final String name, final String code) {
        this.name = name;
        this.code = code;
    }

    public static Language fromCode(final String code) {
        for (Language l : values()) {
            if (l.getCode().equals(code)) {
                return l;
            }
        }
        return null;
    }

    public static Language fromName(final String name) {
        for (Language l : values()) {
            if (l.getName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    public static String[] getNameList() {
        Language[] values = values();
        String[] strings = new String[values.length];
        for (int i = 0; i <values.length; i++) {
            strings[i]=values[i].getName();
        }
        return strings;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


}

