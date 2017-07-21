package be.bagofwords.db.combinator;

import be.bagofwords.exec.RemoteClass;

@RemoteClass
public class DoubleCombinator implements Combinator<Double> {

    @Override
    public Double combine(Double first, Double second) {
        return first + second;
    }
}
