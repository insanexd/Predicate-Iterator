public class PredicateLength<String> implements Predicate<String> {

    @Override
    public boolean predicate(String element, String argument) {
        if(argument == null || element == null) return false;
        if(element.toString().isEmpty() && argument == "0") return true;
        if(element.toString().length() == new Integer(Integer.parseInt(argument.toString()))) {
            return true;
        }
        return false;
    }
}
