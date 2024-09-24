package demo1;

/**
 * @author momo
 * @Version 1.0
 * @date 23.09.24
 */

public class Serialization1 {
        private static final String IDENTIFIER_STRING = "UEUEUE;";
        private Gson gson;

        public Serialization1() {
            this.gson = new Gson();
        }

        public String serialize(Map object) {
            StringBuilder textBuilder = new StringBuilder();
            textBuilder.append(IDENTIFIER_STRING);
            textBuilder.append(gson.toJson(object));
            return textBuilder.toString();
        }

        public Map deserialize(String text) {
            if (!text.startsWith(IDENTIFIER_STRING)) {
                return Collections.emptyMap();
            }

            String gsonStr = text.substring(IDENTIFIER_STRING.length());
            return gson.fromJson(gsonStr, Map.class);
        }


}
