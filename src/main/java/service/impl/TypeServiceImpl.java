package service.impl;

import model.Type;
import service.TypeService;
import repository.*;

public class TypeServiceImpl implements TypeService {

    private ReporterTypeRepository typeRepository;

    public TypeServiceImpl() {
        typeRepository = new ReporterTypeRepositoryImpl();
    }

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
        return typeRepository.getId(name);
    }
}
