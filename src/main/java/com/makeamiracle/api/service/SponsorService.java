package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.Sponsor;
import com.makeamiracle.api.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {

    @Autowired
    SponsorRepository sponsorRepository;

    public List<Sponsor> findAll(){
        return sponsorRepository.findAll();
    }

    public Long count(){
        return sponsorRepository.count();
    }

    public Sponsor findById(Long id){
        if (!sponsorRepository.existsById(id)) throw new NotFoundException("Sponsor does not exist with id " + id);
        return sponsorRepository.getOne(id);
    }

    public Sponsor create(Sponsor sponsor){
        return sponsorRepository.save(sponsor);
    }

    public Sponsor update(Sponsor sponsor, Long id){
        if (!sponsorRepository.existsById(id)) throw new NotFoundException("Sponsor does not exist with id " + id);
        Sponsor updSponsor = sponsorRepository.getOne(id);
        if (sponsor.getPassport() != null) updSponsor.setPassport(sponsor.getPassport());
        if (sponsor.getName() != null) updSponsor.setName(sponsor.getName());
        if (sponsor.getLastName() != null) updSponsor.setLastName(sponsor.getLastName());
        if (sponsor.getCity() != null) updSponsor.setCity(sponsor.getCity());
        if (sponsor.getPhone() != null) updSponsor.setPhone(sponsor.getPhone());
        if (sponsor.getEmail() != null) updSponsor.setEmail(sponsor.getEmail());
        sponsorRepository.save(updSponsor);
        return updSponsor;
    }

    public Sponsor changeStatus(Long id){
        if (!sponsorRepository.existsById(id)) throw new NotFoundException("Sponsor does not exist with id " + id);
        Sponsor updSponsor = sponsorRepository.getOne(id);
        updSponsor.setStatus(!updSponsor.getStatus());
        sponsorRepository.save(updSponsor);
        return updSponsor;
    }
}
