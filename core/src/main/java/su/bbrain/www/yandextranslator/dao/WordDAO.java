package su.bbrain.www.yandextranslator.dao;


import org.apache.commons.lang.StringEscapeUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import su.bbrain.www.yandextranslator.database.SQLiteConnection;
import su.bbrain.www.yandextranslator.object.Word;

public class WordDAO {



    private static String sql = "SELECT * from word";






    private List<Word> getAllPost() throws SQLException {
        List<Word> postList = new ArrayList<>();
        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement(sql+" order by id desc");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            postList.add(createObject(resultSet));
        }
        return postList;
    }


    public List<Word> getFavoriteAllPost() {
        List<Word> postList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = SQLiteConnection.getConnection().prepareStatement(sql + " where favorite='true' order by id desc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postList.add(createObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public void deleteFavorite(Word word) throws SQLException {
        String text = StringEscapeUtils.escapeSql(word.getText());

        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("delete from word where \"text\" = '"+text+"'");
        preparedStatement.executeUpdate();
    }

    public void insertWordFavorite(Word word) throws SQLException {
        String text = StringEscapeUtils.escapeSql(word.getText());
        String translatorText = StringEscapeUtils.escapeSql(word.getTranslatorText());
        String codeLanguageFrom = StringEscapeUtils.escapeSql(word.getCodeLanguageFrom());
        String codeLanguageTo = StringEscapeUtils.escapeSql(word.getCodeLanguageTo());


        deleteFavorite(word);

        PreparedStatement preparedStatement = SQLiteConnection.getConnection()
                .prepareStatement("insert into word (\"text\",translatorText,codeLanguageFrom,codeLanguageTo,favorite) " +
                        "values ('"+text+"','"+translatorText+"','"+codeLanguageFrom+"','"+codeLanguageTo+"','true')\n" + "\n");
        preparedStatement.executeUpdate();
    }


    private Word createObject(ResultSet resultSet) throws SQLException {

        return new Word(
                resultSet.getInt("id"),
                resultSet.getString("text"),
                resultSet.getString("translatorText"),
                resultSet.getString("codeLanguageFrom"),
                resultSet.getString("codeLanguageTo"),
                resultSet.getString("favorite"));
    }


    public List<Word> getWordList() {
        try {
            return getAllPost();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return null;
    }


}
