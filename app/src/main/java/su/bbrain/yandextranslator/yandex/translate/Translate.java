package su.bbrain.yandextranslator.yandex.translate;/*
 * Copyright 2013 Robert Theis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import su.bbrain.yandextranslator.yandex.YandexTranslatorAPI;
import su.bbrain.yandextranslator.yandex.language.Language;

import java.net.URL;
import java.net.URLEncoder;


public final class Translate extends YandexTranslatorAPI {

  private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
  private static final String TRANSLATION_LABEL = "text";

  private Translate(){};


  public static String execute(final String text, final Language from, final Language to) throws Exception {
    validateServiceState(text);
    final String params =
        PARAM_API_KEY + URLEncoder.encode(apiKey,ENCODING)
        + PARAM_LANG_PAIR + URLEncoder.encode(from.getCode(),ENCODING) + URLEncoder.encode("-",ENCODING) + URLEncoder.encode(to.getCode(),ENCODING)
        + PARAM_TEXT + URLEncoder.encode(text,ENCODING);
//     Log.i("!!!!!!",params);
    final URL url = new URL(SERVICE_URL + params);
//     Log.i("!!!!!!",url.toString());

    return retrievePropArrString(url, TRANSLATION_LABEL).trim();
  }

  private static void validateServiceState(final String text) throws Exception {
    final int byteLength = text.getBytes(ENCODING).length;
    if(byteLength>10240) { // TODO What is the maximum text length allowable for Yandex?
      throw new RuntimeException("TEXT_TOO_LARGE");
    }
    validateServiceState();
  }

//  public static void main(String[] args) {
//    try {
//      Translate.setKey(ApiKeys.YANDEX_API_KEY);
//      String translation = Translate.execute("The quick brown fox jumps over the lazy dog.", Language.English, Language.Russian);
//      System.out.println("Translation: " + translation);
//    } catch (Exception e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//  }
}
