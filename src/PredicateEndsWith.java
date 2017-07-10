public class PredicateEndsWith<String> implements Predicate<String> {

    @Override
    public boolean predicate(String element, String argument) {
        if(element == null || argument == null) return false;

        int argumentLength = argument.toString().length();
        int elementLength = element.toString().length();

        if(argumentLength > elementLength) return false;

        int numberOfCommonLetters = 0;
        int argumentCursor = 1;
        for(int i = elementLength - 1; i >= elementLength - argumentLength; i--) {
            if(element.toString().charAt(i) == argument.toString().charAt(argumentLength - argumentCursor)) {
                numberOfCommonLetters++;
            }
            argumentCursor++;
        }
        if(numberOfCommonLetters == argumentLength) return true;
        return false;
    }
}
