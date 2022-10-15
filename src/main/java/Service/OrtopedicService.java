package Service;

import Model.Ortopedic;
import Repository.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        if(validarCampos(ortopedic)){
            if(ortopedic.getId() == null){
                return ortopedicRepository.save(ortopedic);
            } else{
                Optional<Ortopedic> ortopedicEncontrado = ortopedicRepository.getOrtopedic(ortopedic.getId());
                if(ortopedicEncontrado.isEmpty()){
                    return ortopedicRepository.save(ortopedic);
                } else {
                    return ortopedic;
                }
            }
        }
        return ortopedic;
    }
        public Ortopedic update(Ortopedic ortopedic){
            if(validarCampos(ortopedic)) {
                if (ortopedic.getId() != null) {
                    Optional<Ortopedic> ortopedicEncontrado = ortopedicRepository.getOrtopedic(ortopedic.getId());
                    if (!ortopedicEncontrado.isEmpty()) {
                        if (ortopedic.getName() != null) {
                            ortopedicEncontrado.get().setName(ortopedic.getName());
                        }
                        if (ortopedic.getBrand() != null) {
                            ortopedicEncontrado.get().setBrand(ortopedic.getBrand());
                        }
                        if (ortopedic.getYear() != null) {
                            ortopedicEncontrado.get().setYear(ortopedic.getYear());
                        }
                        if (ortopedic.getDescription() != null) {
                            ortopedicEncontrado.get().setDescription(ortopedic.getDescription());
                        }
                        if (ortopedic.getCategory() != null) {
                            ortopedicEncontrado.get().setCategory(ortopedic.getCategory());
                        }
                        return ortopedicRepository.save(ortopedicEncontrado.get());
                      }
                    }
                return ortopedic;
                }
            return ortopedic;
            }

            public boolean delete(int id){
                Boolean resultado = getOrtopedic(id).map(ortopedicPorEliminar ->{
                    ortopedicRepository.delete(ortopedicPorEliminar);
                    return true;
                }) .orElse(false);
                return resultado;
            }
            public boolean validarCampos(Ortopedic ortopedic){
                return (ortopedic.getBrand().length()<=45 && ortopedic.getName().length()<=45 &&
                  String.valueOf(ortopedic.getYear()).length()==4 && ortopedic.getDescription().length() <= 250);
    }

}

