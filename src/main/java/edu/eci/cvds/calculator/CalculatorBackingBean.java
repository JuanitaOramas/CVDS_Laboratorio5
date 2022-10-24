package  edu.eci.cvds.calculator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(name = "CalculatorBackingBean")
@ApplicationScoped
public class CalculatorBackingBean {

    private int guessNumber = (int)Math.floor(Math.random()*(100-0+1)+0);
    private int tries = 0;
    private int accumulativePrice = 100000;
    private String state = "";

    public CalculatorBackingBean() {

    }

    public void guess(int tryNumber) {
        if (tryNumber != guessNumber ){
            accumulativePrice -= 10000;
            tries += 1;
        }
    }

    public void restart() {
        guessNumber = (int)Math.floor(Math.random()*(100-0+1)+0);
        accumulativePrice = 100000;
    }


    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getAccumulativePrice() {
        return accumulativePrice;
    }

    public void setAccumulativePrice(int accumulativePrice) {
        this.accumulativePrice = accumulativePrice;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

}
