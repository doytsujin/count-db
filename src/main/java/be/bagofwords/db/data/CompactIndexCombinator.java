package be.bagofwords.db.data;

import be.bagofwords.db.combinator.Combinator;
import be.bagofwords.exec.RemoteClass;

@RemoteClass
public class CompactIndexCombinator implements Combinator<CompactIndex> {

    @Override
    public CompactIndex combine(CompactIndex first, CompactIndex second) {
        return first.mergeWith(second);
    }
}
