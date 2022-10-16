package service;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import java.util.List;

public interface ADRService {

    void save(AdverseReaction reaction);

    List<AdverseReaction> getAll();
}
