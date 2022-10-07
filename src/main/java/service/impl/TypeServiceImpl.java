package service.impl;

import model.Type;
import repository.impl.ReporterTypeRepositoryImpl;
import service.TypeService;
import repository.*;
@Deprecated
public class TypeServiceImpl implements TypeService {

    private ReporterTypeRepository typeRepository;

    public TypeServiceImpl() {
        typeRepository = new ReporterTypeRepositoryImpl();
    }

//    @Override
//    public void save(Type type) {
//        if (getId(type) == 0) {
//            typeRepository.add(type);
//        }
//    }
//
//    @Override
//    public int getId(Type type) {
//        return typeRepository.getId(type.getName());
//    }
//
//    @Override
//    public Type getById(int id) {
//        return typeRepository.getById(id);
//    }
}
