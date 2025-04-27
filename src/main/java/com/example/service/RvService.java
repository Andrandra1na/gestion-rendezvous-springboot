package com.example.service;

import java.util.List;


import com.example.entity.Creneaux;
import com.example.entity.Rv;

public interface RvService {
    List<Rv> getAllRvs();
    Rv createRv(Rv rv);
    Rv updateRv(Rv rv);
    Rv getRvById(Long idRv);
    void deleteRv(Long idRv);
    boolean existsByCreneau(Creneaux creneau);
}

