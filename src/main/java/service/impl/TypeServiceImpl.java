package service.impl;

import model.Type;
import model.enums.ReporterType;
import service.TypeService;
import repository.*;

public class TypeServiceImpl implements TypeService {

    private ReporterTypeRepository typeRepository;

    public TypeServiceImpl() {
        typeRepository = new ReporterTypeRepositoryImpl();
    }

    @Override
    public void save(ReporterType name) {
        if (getId(name) == 0) {
            Type type = new Type(name);
            typeRepository.add(name);
        }
    }

    @Override
    public int getId(ReporterType name) {
        return typeRepository.getId(name);
    }

    public Type getByID(int id) {
        return typeRepository.getByID(id);
    }
}
