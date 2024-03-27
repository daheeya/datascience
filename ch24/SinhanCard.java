package ch24;

import java.util.*;

public class SinhanCard {
    private static SinhanCard INSTANCE;
    private Map<User, List<Chargeable>> users;
    private static Long userIdx;

    private SinhanCard(){
        users=new HashMap<>();
        userIdx=1L;
    }

    public static synchronized SinhanCard getInstance(){
        if(INSTANCE== null) INSTANCE=new SinhanCard();
        return INSTANCE;
    }

    public void createUser(String email){
        users.put(new User(userIdx++, email),new ArrayList<Chargeable>());
    }

    public void createCard(Long idx, CardType cardType){

        var user = findeUser(idx);

        String cardNumber= "222-222"+idx.toString();
        switch (cardType){
            case CREDIT -> users.get(user).add(new CreditCard("2029-03-27",cardNumber));
            case CASH -> users.get(user).add(new CashCard("0000-0000","28-03-27", "123456"));
            case GIFT -> users.get(user).add(new GiftCard());
        }
    }
    private User findeUser(Long idx){
        for(var user: users.keySet()){
            if(Objects.equals(user.getIdx(), idx)) return user;
        }
        return null;
    }

    public List<Chargeable> findChargeable(Long idx){
        return users.get(findeUser(idx));
    }


}
