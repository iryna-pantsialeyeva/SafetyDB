package service;

import model.Type;

public class TypeServiceImpl implements TypeService {

    @Override
    public Type save(String name) {
        Type type = null;
        if (!isPresent(name)) {
            type = new Type(name);
        }
        return type;
    }

    @Override
    public boolean isPresent(String name) {
        if (getId(name) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getId(String name) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
