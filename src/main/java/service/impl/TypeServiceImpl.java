package service.impl;

import model.Type;
import service.TypeService;

public class TypeServiceImpl implements TypeService {

    @Override
    public Type save(String name) {
        Type type = null;
        if (getId(name) == 0) {
            type = new Type(name);
        }
        return type;
    }

    @Override
    public int getId(String name) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
