package su.bbrain.yandextranslator.yandex.detect;//package su.bbrain.yandextranslator.yandex.detect;/*
// * Copyright 2013 Robert Theis
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//
//import su.bbrain.yandextranslator.yandex.ApiKeys;
//import su.bbrain.yandextranslator.yandex.YandexTranslatorAPI;
//import su.bbrain.yandextranslator.yandex.language.Language;
//import su.bbrain.yandextranslator.yandex.translate.Translate;
//
//import java.net.URL;
//import java.net.URLEncoder;
//
//public final class Detect extends YandexTranslatorAPI {
//    private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/detect?";
//    private static final String DETECTION_LABEL = "lang";
//
//    private Detect() {
//    }
//
//    public static Language execute(final String text) throws Exception {
//        validateServiceState(text);
//        final String params = PARAM_API_KEY + URLEncoder.encode(apiKey, ENCODING) + PARAM_TEXT + URLEncoder.encode(text, ENCODING);
//        final URL url = new URL(SERVICE_URL + params);
//        return Language.fromCode(retrievePropString(url, DETECTION_LABEL));
//    }
//
//    private static void validateServiceState(final String text) throws Exception {
//        final int byteLength = text.getBytes(ENCODING).length;
//        if (byteLength > 10240) { // TODO What is the maximum text length allowable for Yandex?
//            throw new RuntimeException("TEXT_TOO_LARGE - Yandex Translator (Detect) can handle up to 10,240 bytes per request");
//        }
//        validateServiceState();
//    }
//
//    public static void main(String[] args) {
//        try {
//            Translate.setKey(ApiKeys.YANDEX_API_KEY);
//            Language translation = Detect.execute("і");
//            String execute = Translate.execute("і", translation, Language.Russian);
//
//            System.out.println("Detected: " + translation.toString());
//            System.out.println(execute);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//}
