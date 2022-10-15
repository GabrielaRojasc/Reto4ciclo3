package Repository;

import Repository.CrudRepository.OrtopedicCrudRepository;
import Model.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrtopedicRepository {

    @Autowired
    private OrtopedicCrudRepository ortopedicCrudRepository;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCrudRepository.findAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicCrudRepository.findById(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return ortopedicCrudRepository.save(ortopedic);
    }

    public void delete(Ortopedic ortopedic){
        ortopedicCrudRepository.delete(ortopedic);
    }
}
