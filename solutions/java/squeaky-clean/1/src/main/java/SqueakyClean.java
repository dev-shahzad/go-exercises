class SqueakyClean {
    static String clean(String identifier) {
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < identifier.length(); i++) {
            
            char letter = identifier.charAt(i);
            
            if(Character.isWhitespace(letter)) {
                result.append('_');
                continue;
            }
            
            if(letter == '-') {
                capitalizeNext = true;
                continue;
            }

            switch (letter) {
                case '4': letter = 'a'; break;
                case '3': letter = 'e'; break;
                case '0': letter = 'o'; break;
                case '1': letter = 'l'; break;
                case '7': letter = 't'; break;
            }

            if (capitalizeNext) {
                letter = Character.toUpperCase(letter);
                capitalizeNext = false;
            }

            if (Character.isLetter(letter) || letter == '_') {
                result.append(letter);
            }
        }

        return result.toString();
        
    }
}
