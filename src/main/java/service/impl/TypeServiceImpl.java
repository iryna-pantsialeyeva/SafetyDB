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
    public void save(String name) {
        if (getId(name) == 0) {
            Type type = new Type(name);
            typeRepository.add(name);
        }
    }

    @Override
    public int getId(String name) {
        return typeRepository.getId(name);
    }
}
