package Backend.apiEngine.Endpoints;

import Backend.Steps.Hooks;

public class DeleteEndpoints extends Hooks{
    Hooks hook;

    public void deleteUser(){
        String token=hook.generateAndGetToken();
        Hooks.iSetTheRequestSpecifications().header("Authorization","Bearer"+token);
        String UserId= Hooks.getUserId();

    }
}
