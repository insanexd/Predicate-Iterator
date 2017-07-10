public class PredicateStartsWith<String> implements Predicate<String> {


    @Override
    public boolean predicate(String element, String argument) {
        if(element == null || argument == null) return false;

        int argumentLength = argument.toString().length();
        int elementLength = element.toString().length();

        if(argumentLength > elementLength) return false;

        int numberOfCommonLetters = 0;


        for(int i = 0; i < argumentLength; i++) {
            if(element.toString().charAt(i) == argument.toString().charAt(i)) numberOfCommonLetters++;
        }
        if(numberOfCommonLetters == argumentLength) return true;

        return false;
    }
}
