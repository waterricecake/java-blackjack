package blackjack.domain.participant;

public class Name {
    private final String value;
    public Name(String value){
        this.value = value;
    }
    public String get(){
        return this.value;
    }
}