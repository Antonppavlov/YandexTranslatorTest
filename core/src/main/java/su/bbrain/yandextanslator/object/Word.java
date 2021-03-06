package su.bbrain.yandextanslator.object;


public class Word {
    private int id;
    private String text;
    private String translatorText;
    private String codeLanguageFrom;
    private String codeLanguageTo;
    private String favorite;

    public Word(int id, String text, String translatorText, String codeLanguageFrom, String codeLanguageTo, String favorite) {
        this.id = id;
        this.text = text;
        this.translatorText = translatorText;
        this.codeLanguageFrom = codeLanguageFrom;
        this.codeLanguageTo = codeLanguageTo;
        this.favorite = favorite;
    }

    public Word( String text, String translatorText, String codeLanguageFrom, String codeLanguageTo) {
        this.text = text;
        this.translatorText = translatorText;
        this.codeLanguageFrom = codeLanguageFrom;
        this.codeLanguageTo = codeLanguageTo;
        this.favorite = "true";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslatorText() {
        return translatorText;
    }

    public void setTranslatorText(String translatorText) {
        this.translatorText = translatorText;
    }

    public String getCodeLanguageFrom() {
        return codeLanguageFrom;
    }

    public void setCodeLanguageFrom(String codeLanguageFrom) {
        this.codeLanguageFrom = codeLanguageFrom;
    }

    public String getCodeLanguageTo() {
        return codeLanguageTo;
    }

    public void setCodeLanguageTo(String codeLanguageTo) {
        this.codeLanguageTo = codeLanguageTo;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!text.equals(word.text)) return false;
        if (!codeLanguageFrom.equals(word.codeLanguageFrom)) return false;
        return codeLanguageTo.equals(word.codeLanguageTo);

    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + codeLanguageFrom.hashCode();
        result = 31 * result + codeLanguageTo.hashCode();
        return result;
    }
}
