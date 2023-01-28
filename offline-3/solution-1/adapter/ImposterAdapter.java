package adapter;

import crewmate.*;
import imposter.*;

public class ImposterAdapter implements Crewmate {
    Imposter hidden_imposter;

    public ImposterAdapter(Imposter _hidden_imposter) {
        this.hidden_imposter = _hidden_imposter;
    }

    @Override
    public void contribute() {
        this.hidden_imposter.sabotage();
    }
}